package org.usfirst.frc.team2175.subsystem.drivetrain;

import org.usfirst.frc.team2175.ServiceLocator;

public class TrapezoidalMotionProfile {
    private double percentToReachMaxSpeed = .2;
    private double maxSpeed = .9;
    private double ticksToDrive;
    private double inchesDriven;
    private double currentSpeed;
    private DrivetrainSubsystem drivetrainSubsystem;

    public TrapezoidalMotionProfile() {
        ServiceLocator.register(this);
    }

    public void setupDrive(final double inchesToDrive) {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        this.ticksToDrive = inchesToTicks(inchesToDrive);
        inchesDriven = 0;
    }

    protected double inchesToTicks(final double inches) {
        return inches / 111.5 * 1231.75;
    }

    public double getCurrentSpeed() {
        currentSpeed = getNextSpeed() + .01;
        return currentSpeed;
    }

    public boolean getIsFinishedMoving() {
        return getPercentComplete() > .98 && getPercentComplete() < 1.02;
    }

    private double getNextSpeed() {
        if (!(hitMaxSpeed())) {
            if (isAccelerating()) {
                currentSpeed = maxSpeed * getPercentAccelerated();
            } else if (isDecelerating()) {
                currentSpeed = maxSpeed * -getPercentDecelerated();
            }
        }
        return currentSpeed;
    }

    private boolean hitMaxSpeed() {
        return getPercentComplete() > percentToReachMaxSpeed
                || getPercentComplete() < 1 - getPercentComplete();
    }

    private double getPercentComplete() {
        return getInchesDriven() / ticksToDrive;
    }

    private boolean isAccelerating() {
        return getPercentComplete() < percentToReachMaxSpeed;
    }

    private boolean isDecelerating() {
        return getPercentComplete() > (1 - percentToReachMaxSpeed);
    }

    private double getPercentAccelerated() {
        return getPercentComplete() / percentToReachMaxSpeed;
    }

    private double getPercentDecelerated() {
        return getPercentComplete() / (1 - percentToReachMaxSpeed);
    }

    private double getInchesDriven() {
        return drivetrainSubsystem.getLeftEncoderDistance();
    }
}
