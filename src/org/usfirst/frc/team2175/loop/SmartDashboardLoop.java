package org.usfirst.frc.team2175.loop;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.autonomous.CrossBaselineTimeBasedAutonomous;
import org.usfirst.frc.team2175.command.autonomous.DoNothingAutonomous;
import org.usfirst.frc.team2175.command.autonomous.DriveForwardAndPlaceGearOnPegAutonomous;
import org.usfirst.frc.team2175.command.autonomous.DriveForwardForTenSecondsAutonomous;
import org.usfirst.frc.team2175.command.autonomous.DriveOneFootForwardSimpleAutonomous;
import org.usfirst.frc.team2175.command.autonomous.TurnDegreesFromUDP;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;
import org.usfirst.frc.team2175.subsystem.GearIntakeSubsystem;
import org.usfirst.frc.team2175.subsystem.communications.CommunicationSubsystem;
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
        SmartDashboard.putBoolean("Is Hopper Up",
                ServiceLocator.get(FuelIntakeSubsystem.class).isHopperUp());
        SmartDashboard.putNumber("Right Encoder", ServiceLocator
                .get(DrivetrainSubsystem.class).getRightEncoderDistance());

        SmartDashboard.putNumber("GyroVal",
                ServiceLocator.get(CommunicationSubsystem.class).getSetpoint());
    }

    protected void showGearIntakeInfo() {
        SmartDashboard.putNumber("Current",
                gearIntakeSubsystem.getLeftMotorCurrent());
        SmartDashboard.putBoolean("Gear in Gear Intake",
                gearIntakeSubsystem.isCancelled());
    }

    private void populateAutonSelector() {
        autonSelector.addObject("No Auton", new DoNothingAutonomous());
        autonSelector.addObject("Cross Baseline",
                new CrossBaselineTimeBasedAutonomous());
        autonSelector.addObject("Center Peg Auton",
                new DriveForwardAndPlaceGearOnPegAutonomous());
        autonSelector.addDefault("Turn Degrees From UDP",
                new TurnDegreesFromUDP());
        autonSelector.addObject("Drive Two Feet Forward",
                new DriveOneFootForwardSimpleAutonomous());
        autonSelector.addObject("Drive Forward For Ten Seconds Straight",
                new DriveForwardForTenSecondsAutonomous());
    }

    public Command getAuton() {
        return autonSelector.getSelected();
    }

}
