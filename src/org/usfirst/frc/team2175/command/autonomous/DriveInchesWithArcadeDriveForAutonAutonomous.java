package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.single.DriveInchesWithPercentVbusCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveInchesWithArcadeDriveForAutonAutonomous extends CommandGroup {
    public DriveInchesWithArcadeDriveForAutonAutonomous() {
        // DrivetrainSubsystem drivetrainSubsystem =
        // ServiceLocator.get(DrivetrainSubsystem.class);
        // TrapezoidalMotionProfile trapezoidalMotionProfile =
        // ServiceLocator.get(TrapezoidalMotionProfile.class);
        addSequential(new DriveInchesWithPercentVbusCommand(-30));
    }
}
