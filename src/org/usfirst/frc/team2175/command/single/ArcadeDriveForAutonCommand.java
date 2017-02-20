package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;

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

        requires(drivetrainSubsystem);
    }

    @Override
    protected void initialize() {
        super.initialize();
        drivetrainSubsystem.resetGyro();
    }

    @Override
    protected void execute() {

        if (rotateValue != 0) {
            drivetrainSubsystem.arcadeDrive(moveValue, rotateValue);
        } else {
            drivetrainSubsystem.arcadeDrive(moveValue,
                    -(drivetrainSubsystem.getGyroAngle() / 20));
        }
    }

    @Override
    protected boolean isFinished() {
        if (timeSinceInitialized() > 1.5) {
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
