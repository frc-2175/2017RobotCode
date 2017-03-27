package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;
import org.usfirst.frc.team2175.subsystem.visionprocessing.VisionSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class TurnToPegVisionTargetCommand extends BaseCommand {
    private DrivetrainSubsystem drivetrainSubsystem;
    private double degreesToTurn;
    private VisionSubsystem visionSubsystem;
    private Command turnDegrees;
    private boolean hasStarted = false;

    public TurnToPegVisionTargetCommand() {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        visionSubsystem = ServiceLocator.get(VisionSubsystem.class);
    }

    @Override
    protected void initialize() {
        super.initialize();
        degreesToTurn = visionSubsystem.getDegreesToTurnToPeg();
        turnDegrees = new TurnDegreesWithGyroCommand(degreesToTurn, false);
        turnDegrees.start();
    }

    @Override
    protected void execute() {
        if (turnDegrees.isRunning()) {
            hasStarted = true;
        }
    }

    @Override
    protected boolean isFinished() {
        return hasStarted && !turnDegrees.isRunning();
    }

    @Override
    protected void end() {
        super.end();
        turnDegrees.cancel();
    }

}
