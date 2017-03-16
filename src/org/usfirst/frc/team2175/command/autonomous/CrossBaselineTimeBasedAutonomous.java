package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.group.DriveInAutonCommandGroup;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossBaselineTimeBasedAutonomous extends CommandGroup {
    public CrossBaselineTimeBasedAutonomous() {
        addSequential(new DriveInAutonCommandGroup(0.8, false), 3);
    }
}
