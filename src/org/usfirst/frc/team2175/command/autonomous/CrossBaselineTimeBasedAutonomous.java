package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.BaseCommandGroup;
import org.usfirst.frc.team2175.command.group.DriveInAutonCommandGroup;

public class CrossBaselineTimeBasedAutonomous extends BaseCommandGroup {

    public CrossBaselineTimeBasedAutonomous() {
        addSequential(new DriveInAutonCommandGroup(0.8, false), 3);
    }

}
