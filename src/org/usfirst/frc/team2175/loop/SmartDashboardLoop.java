package org.usfirst.frc.team2175.loop;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.autonomous.CrossBaselineTimeBasedAutonomous;
import org.usfirst.frc.team2175.command.autonomous.DoNothingAutonomous;
import org.usfirst.frc.team2175.command.autonomous.DriveForwardAndPlaceGearOnPegAutonomous;
import org.usfirst.frc.team2175.command.autonomous.RightPegAutonomous;
import org.usfirst.frc.team2175.command.autonomous.TurnDegreesFromUDP;
import org.usfirst.frc.team2175.subsystem.ClimberSubsystem;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;
import org.usfirst.frc.team2175.subsystem.GearIntakeSubsystem;
import org.usfirst.frc.team2175.subsystem.communications.CommunicationSubsystem;
import org.usfirst.frc.team2175.subsystem.drivetrain.DrivetrainSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardLoop extends ControlLoop {
    private final GearIntakeSubsystem gearIntakeSubsystem;
    private final DrivetrainSubsystem drivetrainSubsystem;

    private SendableChooser<Command> autonSelector;

    public SmartDashboardLoop() {
        gearIntakeSubsystem = ServiceLocator.get(GearIntakeSubsystem.class);
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);

        autonSelector = new SendableChooser<>();

        populateAutonSelector();
        SmartDashboard.putData("Auton", autonSelector);

        ServiceLocator.register(this);
    }

    @Override
    protected long getPeriodMs() {
        return 10;
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
                new RightPegAutonomous());
    }

    @Override
    protected void runTask() {
        showGearIntakeInfo();
        showDrivetrainInfo();

        SmartDashboard.putNumber("Gyro value from UDP",
                ServiceLocator.get(CommunicationSubsystem.class).getSetpoint());
        SmartDashboard.putNumber("Current Output",
                ServiceLocator.get(ClimberSubsystem.class).getOutputCurrent());
    }

    protected void showGearIntakeInfo() {
        SmartDashboard.putNumber("Current",
                gearIntakeSubsystem.getLeftMotorCurrent());
        SmartDashboard.putBoolean("Gear in Gear Intake",
                gearIntakeSubsystem.isCancelled());
        SmartDashboard.putBoolean("GearActuatorOut",
                gearIntakeSubsystem.getIsGearIntakeOut());
    }

    protected void showDrivetrainInfo() {
        SmartDashboard.putNumber("CurrentDraw",
                drivetrainSubsystem.getOutputCurrent());
        SmartDashboard.putNumber("Gyro", drivetrainSubsystem.getGyroAngle());
        SmartDashboard.putNumber("GyroGraph",
                drivetrainSubsystem.getGyroAngle());
        SmartDashboard.putNumber("Encoder",
                drivetrainSubsystem.getLeftEncoderDistance());
        SmartDashboard.putBoolean("Is Hopper Up",
                ServiceLocator.get(FuelIntakeSubsystem.class).isHopperUp());
        SmartDashboard.putNumber("Right Encoder",
                drivetrainSubsystem.getRightEncoderDistance());
    }

    public Command getAuton() {
        return autonSelector.getSelected();
    }

}
