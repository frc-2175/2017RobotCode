package org.usfirst.frc.team2175.command.group;

import org.usfirst.frc.team2175.command.BaseCommandGroup;
import org.usfirst.frc.team2175.command.autonomous.DriveForwardAndPlaceGearOnPegAutonomous;
import org.usfirst.frc.team2175.command.single.TurnDegreesWithGyroCommand;
import org.usfirst.frc.team2175.command.single.TurnToPegVisionTargetCommand;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class SideGearCommandGroup extends BaseCommandGroup {
    public SideGearCommandGroup(boolean isLeftPeg) {
        double degreesToTurn = -60;
        addSequential(new DriveInAutonCommandGroup(true, -90.5));
        addSequential(new WaitCommand(.25));
        if (isLeftPeg) {
            degreesToTurn = 60;
        }
        addSequential(new TurnDegreesWithGyroCommand(degreesToTurn));
        addSequential(new WaitCommand(.15));
        addSequential(new TurnToPegVisionTargetCommand(), 3);
        addSequential(new WaitCommand(.15));
        addSequential(new DriveForwardAndPlaceGearOnPegAutonomous());
    }
}
