package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.drivetrain.DrivetrainSubsystem;

public class DriveInchesSimpleCommand extends BaseCommand {
    private DrivetrainSubsystem drivetrainSubsystem;
    private double ticksToDrive;

    public DriveInchesSimpleCommand(double inchesToDrive) {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        this.ticksToDrive =
                drivetrainSubsystem.convertFromInchesToClicks(inchesToDrive);
        requires(drivetrainSubsystem);
    }

    @Override
    protected void initialize() {
        drivetrainSubsystem.resetEncoders();
    }

    @Override
    protected void execute() {
        drivetrainSubsystem.arcadeDrive(0.7, 0);
    }

    @Override
    protected boolean isFinished() {
        return drivetrainSubsystem.getEncoderDistance() > ticksToDrive;
    }

    @Override
    protected void end() {
        drivetrainSubsystem.stopAllMotors();
    }
}
