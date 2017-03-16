package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.group.DriveInAutonCommandGroup;
import org.usfirst.frc.team2175.command.single.TurnDegreesWithGyroCommand;
import org.usfirst.frc.team2175.command.single.TurnToPegVisionTargetCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class SideGearsAutonomous extends CommandGroup {
    private double degreesToTurn;

    public SideGearsAutonomous(final boolean isLeftPeg) {
        degreesToTurn = -60;
        addSequential(new DriveInAutonCommandGroup(true, -90.5));
        addSequential(new WaitCommand(.25));
        if (isLeftPeg) {
            degreesToTurn = 60;
        }
        addSequential(new TurnDegreesWithGyroCommand(degreesToTurn));
        addSequential(new WaitCommand(.15));
        addSequential(new TurnToPegVisionTargetCommand());
        addSequential(new WaitCommand(.15));
        addSequential(new DriveForwardAndPlaceGearOnPegAutonomous());

    }
}
