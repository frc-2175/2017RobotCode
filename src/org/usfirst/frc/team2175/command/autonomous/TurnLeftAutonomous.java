package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.single.TurnDegreesWithGyroCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnLeftAutonomous extends CommandGroup {

    public TurnLeftAutonomous() {
        addSequential(new TurnDegreesWithGyroCommand(-90));
    }
}
