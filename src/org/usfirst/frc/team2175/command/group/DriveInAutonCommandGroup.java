package org.usfirst.frc.team2175.command.group;

import org.usfirst.frc.team2175.command.BaseCommandGroup;
import org.usfirst.frc.team2175.command.single.DriveInchesSimpleCommand;
import org.usfirst.frc.team2175.command.single.DriveStraightUntilCurrentCommand;

public class DriveInAutonCommandGroup extends BaseCommandGroup {

    public DriveInAutonCommandGroup(final boolean usingInches,
            final double doubleValue, final boolean stopOnCurrentJump) {
        if (usingInches) {
            addSequential(new DriveInchesSimpleCommand(doubleValue));
        } else {
            addSequential(new DriveStraightUntilCurrentCommand(doubleValue,
                    stopOnCurrentJump));
        }
    }

    public DriveInAutonCommandGroup(final boolean usingInches,
            final double doubleValue) {
        this(usingInches, doubleValue, true);
    }

    public DriveInAutonCommandGroup(final double moveValue) {
        this(false, moveValue);
    }

    public DriveInAutonCommandGroup(final double moveValue,
            final boolean stopOnCurrentJump) {
        this(false, moveValue, stopOnCurrentJump);
    }

}
