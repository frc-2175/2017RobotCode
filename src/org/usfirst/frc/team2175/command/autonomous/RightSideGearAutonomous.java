package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.group.PlaceGearOnPegAndRetreatCommandGroup;
import org.usfirst.frc.team2175.command.single.ArcadeDriveForAutonCommand;
import org.usfirst.frc.team2175.command.single.DriveInchesWithPercentVbusCommand;
import org.usfirst.frc.team2175.command.single.TurnDegreesWithGyroCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSideGearAutonomous extends CommandGroup {
    public RightSideGearAutonomous() {
        addSequential(new DriveInchesWithPercentVbusCommand(-50));
        addSequential(new TurnDegreesWithGyroCommand(-45));
        addSequential(new ArcadeDriveForAutonCommand(-0.5, 0), 6);
        addSequential(new PlaceGearOnPegAndRetreatCommandGroup());
    }
}
