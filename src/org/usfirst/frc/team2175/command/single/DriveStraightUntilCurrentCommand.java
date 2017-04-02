package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;

public class DriveStraightUntilCurrentCommand extends BaseCommand {
    private final DrivetrainSubsystem drivetrainSubsystem;
    private final double moveValue;
    final boolean shouldStopIfHitsSomething;

    // public DriveUntilCurrentCommand(final double moveValue) {
    // this(moveValue, true);
    // }

    public DriveStraightUntilCurrentCommand(final double moveValue,
            final boolean shouldStopIfHitsSomething) {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        this.moveValue = moveValue;
        this.shouldStopIfHitsSomething = shouldStopIfHitsSomething;

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
        if (shouldStopIfHitsSomething && timeSinceInitialized() > 1) {
            return drivetrainSubsystem.isCurrentGreatEnough();
        } else {
            return false;
        }
    }

    @Override
    protected void end() {
        super.end();
    }
}
