package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.BaseCommandGroup;
import org.usfirst.frc.team2175.command.group.SideGearCommandGroup;
import org.usfirst.frc.team2175.command.single.DriveInchesSimpleCommand;
import org.usfirst.frc.team2175.command.single.RunFeedingMechanismsCommand;
import org.usfirst.frc.team2175.command.single.RunShooterPercentVbusCommand;
import org.usfirst.frc.team2175.command.single.TurnDegreesWithGyroCommand;

public class SideGearAndShootAutonomous extends BaseCommandGroup {
    public SideGearAndShootAutonomous(boolean isLeftPeg,
            boolean shouldUseJetson) {
        addSequential(new SideGearCommandGroup(isLeftPeg, shouldUseJetson));
        addSequential(new DriveInchesSimpleCommand(10));
        // addSequential(new TurnToBoilerTargetCommand(isLeftPeg));
        addSequential(new TurnDegreesWithGyroCommand(-12));
        addParallel(new RunShooterPercentVbusCommand());
        addSequential(new RunFeedingMechanismsCommand());
    }
}
