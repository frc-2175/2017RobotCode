package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.command.single.TurnDegreesWithGyroCommand;
import org.usfirst.frc.team2175.subsystem.communications.CommunicationSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class TurnDegreesFromUDP extends BaseCommand {
    private CommunicationSubsystem communicationSubsystem;

    public TurnDegreesFromUDP() {
        communicationSubsystem =
                ServiceLocator.get(CommunicationSubsystem.class);
    }

    @Override
    protected void initialize() {
        final double setpoint = communicationSubsystem.getSetpoint();
        final Command turnDegrees = new TurnDegreesWithGyroCommand(setpoint);
        turnDegrees.start();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}
