package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.visionprocessing.VisionSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class TurnToBoilerTargetCommand extends BaseCommand {
    private double degreesToTurn;
    private VisionSubsystem visionSubsystem;
    private Command turnDegrees;
    private boolean hasStarted = false;
    private boolean isLeftSide;

    public TurnToBoilerTargetCommand(boolean isLeftSide) {
        visionSubsystem = ServiceLocator.get(VisionSubsystem.class);
        this.isLeftSide = isLeftSide;
    }

    @Override
    protected void initialize() {
        super.initialize();
        degreesToTurn = visionSubsystem.getDegreesToTurnToBoiler(isLeftSide);
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
