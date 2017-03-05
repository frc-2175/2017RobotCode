package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.drivetrain.DrivetrainSubsystem;
import org.usfirst.frc.team2175.subsystem.visionprocessing.VisionSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class TurnToPegVisionTargetCommand extends BaseCommand {
    private DrivetrainSubsystem drivetrainSubsystem;
    private double degreesToTurn;
    private VisionSubsystem visionSubsystem;

    public TurnToPegVisionTargetCommand() {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        visionSubsystem = ServiceLocator.get(VisionSubsystem.class);
    }

    @Override
    protected void initialize() {
        // degreesToTurn = visionSubsystem.getDegreesToTurn();
        Command turnDegrees = new TurnDegreesWithGyroCommand(degreesToTurn);
        turnDegrees.start();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
