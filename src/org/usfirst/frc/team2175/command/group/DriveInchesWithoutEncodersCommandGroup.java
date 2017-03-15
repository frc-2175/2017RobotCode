package org.usfirst.frc.team2175.command.group;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.single.ArcadeDriveForAutonCommand;
import org.usfirst.frc.team2175.subsystem.drivetrain.DrivetrainSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveInchesWithoutEncodersCommandGroup extends CommandGroup {
    // TODO: Remove unnecessary instance variables
    private DrivetrainSubsystem drivetrainSubsystem;
    private final double inches;
    private final double percentVbus;
    private final double seconds;

    public DriveInchesWithoutEncodersCommandGroup(final double inches,
            final double percentVbus) {
        this.inches = inches;
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        this.percentVbus = percentVbus;
        seconds = calculateSecondsFromInches(inches, percentVbus);
        addSequential(new ArcadeDriveForAutonCommand(percentVbus, 0), seconds);
    }

    // TODO: This assumes a speed of 0.8 by default. Is that ok, or should we
    // handle it in some way, like throwing an exception?
    private double calculateSecondsFromInches(final double inches,
            final double percentVbus) {
        double seconds;
        final double INCHES_PER_SECOND_ZERO_POINT_SIX = 22.6008;
        final double INCHES_PER_SECOND_ZERO_POINT_SEVEN = 24.375;
        final double INCHES_PER_SECOND_ZERO_POINT_EIGHT = 42.6;
        if (percentVbus == 0.6) {
            seconds = inches / INCHES_PER_SECOND_ZERO_POINT_SIX;
        } else if (percentVbus == 0.7) {
            seconds = inches / INCHES_PER_SECOND_ZERO_POINT_SEVEN;
        } else {
            seconds = inches / INCHES_PER_SECOND_ZERO_POINT_EIGHT;
        }
        return seconds;
    }
}
