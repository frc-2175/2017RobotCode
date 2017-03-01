package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;
import org.usfirst.frc.team2175.subsystem.visionprocessing.VisionSubsystem;

public class DriveForwardUntilAtGearCommand extends BaseCommand {
    DrivetrainSubsystem drivetrainSubsystem;
    VisionSubsystem visionSubsystem;

    public DriveForwardUntilAtGearCommand() {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);

    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        drivetrainSubsystem.arcadeDrive(0.8,
                visionSubsystem.getDegreesToTurnToGear());
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
    }
}
