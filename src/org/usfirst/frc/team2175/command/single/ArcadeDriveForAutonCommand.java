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
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        drivetrainSubsystem.arcadeDrive(moveValue, rotateValue);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }
}
