package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.group.DriveInAutonCommandGroup;
import org.usfirst.frc.team2175.command.group.PlaceGearOnPegAndRetreatCommandGroup;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveForwardAndPlaceGearOnPegAutonomous extends CommandGroup {
    public DriveForwardAndPlaceGearOnPegAutonomous() {
        addSequential(new DriveInAutonCommandGroup(-0.7), 5);
        addParallel(new DriveInAutonCommandGroup(0.5), 0.5);
        addSequential(new PlaceGearOnPegAndRetreatCommandGroup());
    }
}
