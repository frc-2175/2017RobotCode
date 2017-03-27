package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;

public class DriveInchesSimpleCommand extends BaseCommand {
    private DrivetrainSubsystem drivetrainSubsystem;
    private double ticksToDrive;
    private double sign;

    public DriveInchesSimpleCommand(final double inchesToDrive) {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        this.ticksToDrive =
                drivetrainSubsystem.convertFromInchesToClicks(inchesToDrive);
        requires(drivetrainSubsystem);
        sign = Math.signum(inchesToDrive);
    }

    @Override
    protected void initialize() {
        drivetrainSubsystem.resetEncoders();
        drivetrainSubsystem.resetGyro();
    }

    @Override
    protected void execute() {
        drivetrainSubsystem.straightArcadeDrive(0.85 * sign);
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(drivetrainSubsystem.getEncoderDistance()) > Math
                .abs(ticksToDrive);
    }

    @Override
    protected void end() {
        drivetrainSubsystem.stopAllMotors();
    }
}
