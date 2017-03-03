package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.drivetrain.DrivetrainSubsystem;

public class ArcadeDriveForAutonCommand extends BaseCommand {
    private final DrivetrainSubsystem drivetrainSubsystem;
    private final double moveValue;
    private final double rotateValue;

    public ArcadeDriveForAutonCommand(final double moveValue,
            final double rotateValue) {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        this.moveValue = moveValue;
        this.rotateValue = rotateValue;

        drivetrainSubsystem.resetGyro();
        drivetrainSubsystem.resetEncoders();

        requires(drivetrainSubsystem);
    }

    @Override
    protected void initialize() {
        super.initialize();
        drivetrainSubsystem.resetGyro();
        drivetrainSubsystem.resetEncoders();
    }

    @Override
    protected void execute() {

        drivetrainSubsystem.straightArcadeDrive(moveValue);

    }

    @Override
    protected boolean isFinished() {
        if (timeSinceInitialized() > .75) {
            return drivetrainSubsystem.getOutputCurrent() > 3;
        } else {
            return false;
        }
    }

    @Override
    protected void end() {
        super.end();
    }
}
