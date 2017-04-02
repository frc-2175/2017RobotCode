package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.BaseCommandGroup;
import org.usfirst.frc.team2175.command.group.SideGearCommandGroup;
import org.usfirst.frc.team2175.command.single.DriveInchesSimpleCommand;

public class SideGearAndShootAutonomous extends BaseCommandGroup {
    public SideGearAndShootAutonomous(boolean isLeftPeg) {
        addSequential(new SideGearCommandGroup(isLeftPeg));
        addSequential(new DriveInchesSimpleCommand(36));
        // addSequential(new TurnToBoilerTargetCommand(isLeftPeg));
    }
}
