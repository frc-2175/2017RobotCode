package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.single.ActuateGearIntakeInCommand;
import org.usfirst.frc.team2175.command.single.ActuateGearIntakeOutAndSpinCommand;
import org.usfirst.frc.team2175.command.single.ArcadeDriveForAutonCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveForwardAndPlaceGearOnPegAutonomous extends CommandGroup {
    public DriveForwardAndPlaceGearOnPegAutonomous() {
        addSequential(new ArcadeDriveForAutonCommand(-0.6, 0), 4);
        addParallel(new ArcadeDriveForAutonCommand(0.5, 0), 0.5);
        addSequential(new ActuateGearIntakeOutAndSpinCommand(), 1.8);
        addSequential(new ArcadeDriveForAutonCommand(0.7, 0), 1);
        addSequential(new ActuateGearIntakeInCommand());
    }
}
