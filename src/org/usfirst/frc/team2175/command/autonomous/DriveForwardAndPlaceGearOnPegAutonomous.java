package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.BaseCommandGroup;
import org.usfirst.frc.team2175.command.group.DriveInAutonCommandGroup;
import org.usfirst.frc.team2175.command.group.PlaceGearOnPegAndRetreatCommandGroup;

public class DriveForwardAndPlaceGearOnPegAutonomous extends BaseCommandGroup {

    public DriveForwardAndPlaceGearOnPegAutonomous() {
        this(-0.6);
    }

    public DriveForwardAndPlaceGearOnPegAutonomous(double speed) {
        addSequential(new DriveInAutonCommandGroup(speed), 5);

        addParallel(new DriveInAutonCommandGroup(0.5), 0.5);
        addSequential(new PlaceGearOnPegAndRetreatCommandGroup());
    }

}
