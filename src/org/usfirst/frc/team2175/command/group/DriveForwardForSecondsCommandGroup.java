package org.usfirst.frc.team2175.command.group;

import org.usfirst.frc.team2175.command.single.ArcadeDriveForAutonCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveForwardForSecondsCommandGroup extends CommandGroup {
    public DriveForwardForSecondsCommandGroup(final double timeToDriveForward) {
        addSequential(new ArcadeDriveForAutonCommand(0.5, 0),
                timeToDriveForward);
    }
}
