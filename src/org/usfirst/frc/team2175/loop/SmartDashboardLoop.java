package org.usfirst.frc.team2175.loop;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.autonomous.DriveForwardAndPlaceGearOnPegAutonomous;
import org.usfirst.frc.team2175.command.autonomous.TurnLeftAutonomous;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;
import org.usfirst.frc.team2175.subsystem.GearIntakeSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardLoop extends ControlLoop {
    private final GearIntakeSubsystem gearIntakeSubsystem;

    private final SendableChooser<Command> autonSelector;

    public SmartDashboardLoop() {
        gearIntakeSubsystem = ServiceLocator.get(GearIntakeSubsystem.class);

        autonSelector = new SendableChooser<>();

        populateAutonSelector();
        SmartDashboard.putData("Auton", autonSelector);

        ServiceLocator.register(this);
    }

    @Override
    protected long getPeriodMs() {
        return 10;
    }

    @Override
    protected void runTask() {
        showGearIntakeInfo();
        SmartDashboard.putNumber("CurrentDraw", ServiceLocator
                .get(DrivetrainSubsystem.class).getOutputCurrent());
        SmartDashboard.putNumber("Gyro",
                ServiceLocator.get(DrivetrainSubsystem.class).getGyroAngle());
        SmartDashboard.putNumber("GyroGraph",
                ServiceLocator.get(DrivetrainSubsystem.class).getGyroAngle());
        SmartDashboard.putBoolean("GearActuatorOut", ServiceLocator
                .get(GearIntakeSubsystem.class).getIsGearIntakeOut());
    }

    protected void showGearIntakeInfo() {
        SmartDashboard.putNumber("Current",
                gearIntakeSubsystem.getLeftMotorCurrent());
        SmartDashboard.putBoolean("Gear in Gear Intake",
                gearIntakeSubsystem.getLeftMotorCurrent() > 2.5);
    }

    private void populateAutonSelector() {
        autonSelector.addDefault("Drive Forward and place gear on peg",
                new DriveForwardAndPlaceGearOnPegAutonomous());
        autonSelector.addObject("Turn Left Auton", new TurnLeftAutonomous());
    }

    public Command getAuton() {
        return autonSelector.getSelected();
    }

}
