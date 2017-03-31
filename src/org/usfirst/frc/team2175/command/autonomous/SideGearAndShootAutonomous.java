package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.BaseCommandGroup;
import org.usfirst.frc.team2175.command.group.SideGearCommandGroup;
import org.usfirst.frc.team2175.command.single.DriveInchesSimpleCommand;
import org.usfirst.frc.team2175.command.single.TurnToBoilerTargetCommand;

public class SideGearAndShootAutonomous extends BaseCommandGroup {
    public SideGearAndShootAutonomous(boolean isLeftPeg) {
        addSequential(new SideGearCommandGroup(isLeftPeg));
        addSequential(new DriveInchesSimpleCommand(48));
        addSequential(new TurnToBoilerTargetCommand(isLeftPeg));
    }
}
