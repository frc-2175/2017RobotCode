package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.drivetrain.DrivetrainSubsystem;

public class ArcadeDriveForAutonCommand extends BaseCommand {
    private final DrivetrainSubsystem drivetrainSubsystem;
    private final double moveValue;
    private final double rotateValue;
    final boolean shouldStopIfHitsSomething;

    public ArcadeDriveForAutonCommand(final double moveValue,
            final double rotateValue) {
        this(moveValue, rotateValue, true);
    }

    public ArcadeDriveForAutonCommand(final double moveValue,
            final double rotateValue, final boolean shouldStopIfHitsSomething) {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        this.moveValue = moveValue;
        this.rotateValue = rotateValue;
        this.shouldStopIfHitsSomething = shouldStopIfHitsSomething;

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
        // TODO: At the moment, this command can't turn. We should probably only
        // do straightArcadeDrive if rotateValue == 0, or we should make a
        // separate command for using straightArcadeDrive in auto.
        drivetrainSubsystem.straightArcadeDrive(moveValue);
    }

    @Override
    protected boolean isFinished() {
        // TODO: This could be simplified into one if/else statement:
        // if (shouldStopIfHitsSomething && timeSinceInitialized() > .75)
        if (shouldStopIfHitsSomething) {
            if (timeSinceInitialized() > .75) {
                return drivetrainSubsystem.getOutputCurrent() > 3;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    protected void end() {
        super.end();
    }
}
