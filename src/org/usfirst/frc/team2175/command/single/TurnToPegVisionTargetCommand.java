package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.communications.CommunicationSubsystem;
import org.usfirst.frc.team2175.subsystem.visionprocessing.VisionSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class TurnToPegVisionTargetCommand extends BaseCommand {
    private double degreesToTurn;
    private VisionSubsystem visionSubsystem;
    
    
    private CommunicationSubsystem communicationSubsystem;
    private final boolean USE_JETSON = false;
    
    private Command turnDegrees;
    private boolean hasStarted;

    public TurnToPegVisionTargetCommand() {
        visionSubsystem = ServiceLocator.get(VisionSubsystem.class);
        communicationSubsystem = ServiceLocator.get(CommunicationSubsystem.class);
    }

    @Override
    protected void initialize() {
        super.initialize();
        
        double udpAngle = communicationSubsystem.getSetpoint();
        if (USE_JETSON && Math.abs(udpAngle) < 45)
        {
        	degreesToTurn = udpAngle;
        }
        else
        {        	
        	degreesToTurn = visionSubsystem.getDegreesToTurnToPeg();
        }
        turnDegrees = new TurnDegreesWithGyroCommand(degreesToTurn, false);
        turnDegrees.start();
        hasStarted = false;
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
