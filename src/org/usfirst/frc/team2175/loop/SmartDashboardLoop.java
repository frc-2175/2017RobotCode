package org.usfirst.frc.team2175.loop;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.autonomous.CrossBaselineTimeBasedAutonomous;
import org.usfirst.frc.team2175.command.autonomous.DoNothingAutonomous;
import org.usfirst.frc.team2175.command.autonomous.DriveForwardAndPlaceGearOnPegAutonomous;
import org.usfirst.frc.team2175.command.autonomous.SideGearsAutonomous;
import org.usfirst.frc.team2175.command.autonomous.TurnDegreesFromUDP;
import org.usfirst.frc.team2175.subsystem.ClimberSubsystem;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;
import org.usfirst.frc.team2175.subsystem.GearIntakeSubsystem;
import org.usfirst.frc.team2175.subsystem.communications.CommunicationSubsystem;
import org.usfirst.frc.team2175.subsystem.visionprocessing.VisionSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardLoop extends ControlLoop {
    private final GearIntakeSubsystem gearIntakeSubsystem;
    private final DrivetrainSubsystem drivetrainSubsystem;
    private final VisionSubsystem visionSubsystem;

    private SendableChooser<Command> autonSelector;

    public SmartDashboardLoop() {
        gearIntakeSubsystem = ServiceLocator.get(GearIntakeSubsystem.class);
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        visionSubsystem = ServiceLocator.get(VisionSubsystem.class);
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
        autonSelector.addObject("Left Peg Auton",
                new SideGearsAutonomous(true));
        autonSelector.addObject("Right Peg Auton",
                new SideGearsAutonomous(false));
        autonSelector.addDefault("Turn Degrees From UDP",
                new TurnDegreesFromUDP());
    }

    @Override
    protected void runTask() {
        showGearIntakeInfo();
        showDrivetrainInfo();
        showVisionInfo();

        SmartDashboard.putNumber("Gyro value from UDP",
                ServiceLocator.get(CommunicationSubsystem.class).getSetpoint());
        SmartDashboard.putNumber("Current Output",
                ServiceLocator.get(ClimberSubsystem.class).getOutputCurrent());
    }

    protected void showGearIntakeInfo() {
        SmartDashboard.putNumber("Current",
                gearIntakeSubsystem.getMotorCurrent());
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

    protected void showVisionInfo() {
        SmartDashboard.putNumber("Degrees Till Centered",
                visionSubsystem.getDegreesToTurnToPeg());
        SmartDashboard.putNumber("Pixel Value Of Center",
                visionSubsystem.getCenterPegInPixels());
    }

    public Command getAuton() {
        return autonSelector.getSelected();
    }

}
