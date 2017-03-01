package org.usfirst.frc.team2175.command.group;

import org.usfirst.frc.team2175.command.single.ActuateGearIntakeInCommand;
import org.usfirst.frc.team2175.command.single.ActuateGearIntakeOutAndSpinCommand;
import org.usfirst.frc.team2175.command.single.ArcadeDriveForAutonCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PlaceGearOnPegAndRetreatCommandGroup extends CommandGroup {
    public PlaceGearOnPegAndRetreatCommandGroup() {
        addSequential(new ActuateGearIntakeOutAndSpinCommand());
        addSequential(new ArcadeDriveForAutonCommand(-0.7, 0), 0.5);
        addSequential(new ActuateGearIntakeInCommand());
    }
}
