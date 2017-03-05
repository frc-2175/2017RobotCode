package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.single.ArcadeDriveForAutonCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossBaselineTimeBasedAutonomous extends CommandGroup {
    public CrossBaselineTimeBasedAutonomous() {
        addSequential(new ArcadeDriveForAutonCommand(0.8, 0, false), 3);
    }
}
