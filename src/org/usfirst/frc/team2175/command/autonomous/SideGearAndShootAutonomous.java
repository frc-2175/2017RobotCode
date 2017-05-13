package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.BaseCommandGroup;
import org.usfirst.frc.team2175.command.group.SideGearCommandGroup;
import org.usfirst.frc.team2175.command.single.DriveInchesSimpleCommand;

public class SideGearAndShootAutonomous extends BaseCommandGroup {
    public SideGearAndShootAutonomous(boolean isLeftPeg,
            boolean shouldUseJetson) {
        addSequential(new SideGearCommandGroup(isLeftPeg, shouldUseJetson));
        addSequential(new DriveInchesSimpleCommand(12));
        // addSequential(new TurnToBoilerTargetCommand(isLeftPeg));
        // addParallel(new RunShooterPercentVbusCommand());
        // addSequential(new RunFeedingMechanismsCommand());
    }
}
