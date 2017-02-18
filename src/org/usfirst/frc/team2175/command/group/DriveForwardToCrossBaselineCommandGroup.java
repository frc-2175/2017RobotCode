package org.usfirst.frc.team2175.command.group;

import org.usfirst.frc.team2175.command.single.DriveInchesCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveForwardToCrossBaselineCommandGroup extends CommandGroup {
    public DriveForwardToCrossBaselineCommandGroup() {
        addSequential(new DriveInchesCommand(95.0));
    }
}
