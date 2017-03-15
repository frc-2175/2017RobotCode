package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.single.TurnDegreesWithGyroCommand;
import org.usfirst.frc.team2175.subsystem.communications.CommunicationSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnDegreesFromUDP extends CommandGroup {
    private CommunicationSubsystem communicationSubsystem;

    public TurnDegreesFromUDP() {
        communicationSubsystem =
                ServiceLocator.get(CommunicationSubsystem.class);
        addSequential(new TurnDegreesWithGyroCommand(
                communicationSubsystem.getSetpoint()));
    }

}
