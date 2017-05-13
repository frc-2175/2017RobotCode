package org.usfirst.frc.team2175.command.group;

import org.usfirst.frc.team2175.command.BaseCommandGroup;
import org.usfirst.frc.team2175.command.autonomous.DriveForwardAndPlaceGearOnPegAutonomous;
import org.usfirst.frc.team2175.command.single.TurnDegreesWithGyroCommand;
import org.usfirst.frc.team2175.command.single.TurnToPegVisionTargetCommand;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class SideGearCommandGroup extends BaseCommandGroup {
    private double turn = 49;

    public SideGearCommandGroup(boolean isLeftPeg, boolean shouldUseJetson) {
        double degreesToTurn = -turn;
        addSequential(new DriveInAutonCommandGroup(true, -81.5), 2.8);
        addSequential(new WaitCommand(.25));
        if (isLeftPeg) {
            degreesToTurn = turn;
        }
        addSequential(new TurnDegreesWithGyroCommand(degreesToTurn));
        addSequential(new WaitCommand(.15));
        addSequential(new TurnToPegVisionTargetCommand(shouldUseJetson), 3);
        addSequential(new WaitCommand(.15));
        addSequential(new DriveForwardAndPlaceGearOnPegAutonomous());
    }
}
