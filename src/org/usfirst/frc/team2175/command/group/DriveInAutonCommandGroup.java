package org.usfirst.frc.team2175.command.group;

import org.usfirst.frc.team2175.command.single.DriveInchesSimpleCommand;
import org.usfirst.frc.team2175.command.single.DriveStraightUntilCurrentCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveInAutonCommandGroup extends CommandGroup {

    public DriveInAutonCommandGroup(boolean usingInches, double doubleValue,
            boolean stopOnCurrentJump) {
        if (usingInches) {
            addSequential(new DriveInchesSimpleCommand(doubleValue));
        } else {
            addSequential(new DriveStraightUntilCurrentCommand(doubleValue,
                    stopOnCurrentJump));
        }
    }

    public DriveInAutonCommandGroup(boolean usingInches, double doubleValue) {
        this(usingInches, doubleValue, true);
    }

    public DriveInAutonCommandGroup(double moveValue) {
        this(false, moveValue);
    }

    public DriveInAutonCommandGroup(double moveValue,
            boolean stopOnCurrentJump) {
        this(false, moveValue, stopOnCurrentJump);
    }

}
