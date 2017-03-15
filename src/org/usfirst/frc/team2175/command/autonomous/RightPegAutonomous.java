package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.single.DriveInchesSimpleCommand;
import org.usfirst.frc.team2175.command.single.TurnDegreesWithGyroCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class RightPegAutonomous extends CommandGroup {

    public RightPegAutonomous() {
        addSequential(new DriveInchesSimpleCommand(-90.5));
        addSequential(new WaitCommand(.25));
        addSequential(new TurnDegreesWithGyroCommand(-60));
    }

}
