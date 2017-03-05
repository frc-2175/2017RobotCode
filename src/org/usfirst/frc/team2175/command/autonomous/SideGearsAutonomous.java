package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.single.DriveInchesSimpleCommand;
import org.usfirst.frc.team2175.command.single.TurnDegreesWithGyroCommand;
import org.usfirst.frc.team2175.command.single.TurnToPegVisionTargetCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SideGearsAutonomous extends CommandGroup {
    private double degreesToTurn;

    public SideGearsAutonomous(boolean isLeftPeg) {
        degreesToTurn = -60;
        addSequential(new DriveInchesSimpleCommand(106));
        if (isLeftPeg) {
            degreesToTurn = 60;
        }
        addSequential(new TurnDegreesWithGyroCommand(degreesToTurn));
        addSequential(new TurnToPegVisionTargetCommand());
        addSequential(new DriveForwardAndPlaceGearOnPegAutonomous());
    }
}
