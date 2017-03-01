package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.single.ActuateGearIntakeInCommand;
import org.usfirst.frc.team2175.command.single.ActuateGearIntakeOutAndSpinCommand;
import org.usfirst.frc.team2175.command.single.ArcadeDriveForAutonCommand;
import org.usfirst.frc.team2175.command.single.DriveForwardUntilAtGearCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterGearTimeBasedAutonomous extends CommandGroup {
    public CenterGearTimeBasedAutonomous() {
        addSequential(new DriveForwardUntilAtGearCommand(), 7);
        addSequential(new ActuateGearIntakeOutAndSpinCommand(), 0.5);
        addSequential(new ArcadeDriveForAutonCommand(-0.5, 0), 2);
        addSequential(new ActuateGearIntakeInCommand());
    }
}
