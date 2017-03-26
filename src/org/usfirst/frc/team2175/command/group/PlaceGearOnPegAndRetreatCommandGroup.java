package org.usfirst.frc.team2175.command.group;

import org.usfirst.frc.team2175.command.BaseCommandGroup;
import org.usfirst.frc.team2175.command.single.ActuateGearIntakeInCommand;
import org.usfirst.frc.team2175.command.single.ActuateGearIntakeOutAndSpinCommand;

// TODO: Either use this as a building block in other auto routines, or delete this.
public class PlaceGearOnPegAndRetreatCommandGroup extends BaseCommandGroup {
    public PlaceGearOnPegAndRetreatCommandGroup() {
        addSequential(new ActuateGearIntakeOutAndSpinCommand(), 0.5);
        addSequential(new DriveInAutonCommandGroup(0.7), 1);
        addSequential(new ActuateGearIntakeInCommand());
    }
}
