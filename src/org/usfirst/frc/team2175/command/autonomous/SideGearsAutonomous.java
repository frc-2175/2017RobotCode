package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.BaseCommandGroup;
import org.usfirst.frc.team2175.command.group.SideGearCommandGroup;

public class SideGearsAutonomous extends BaseCommandGroup {

    public SideGearsAutonomous(final boolean isLeftPeg,
            boolean shouldUseJetson) {
        addSequential(new SideGearCommandGroup(isLeftPeg, shouldUseJetson));
    }

}
