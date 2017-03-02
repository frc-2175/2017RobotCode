package org.usfirst.frc.team2175.loop;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.autonomous.CrossBaselineTimeBasedAutonomous;
import org.usfirst.frc.team2175.subsystem.GearIntakeSubsystem;
import org.usfirst.frc.team2175.subsystem.drivetrain.DrivetrainSubsystem;

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
        SmartDashboard.putNumber("Encoder", ServiceLocator
                .get(DrivetrainSubsystem.class).getLeftEncoderDistance());
    }

    protected void showGearIntakeInfo() {
        SmartDashboard.putNumber("Current",
                gearIntakeSubsystem.getLeftMotorCurrent());
        SmartDashboard.putBoolean("Gear in Gear Intake",
                gearIntakeSubsystem.getLeftMotorCurrent() > 2.5);
    }

    private void populateAutonSelector() {
        // autonSelector.addDefault("Drive Forward and place gear on peg",
        // new DriveInchesWithPercentVbusCommand(12));
        autonSelector.addDefault("Cross Baseline",
                new CrossBaselineTimeBasedAutonomous());
    }

    public Command getAuton() {
        return autonSelector.getSelected();
    }

}
