package org.usfirst.frc.team2175.subsystem.drivetrain;

import org.usfirst.frc.team2175.ServiceLocator;

public class TrapezoidalMotionProfile {
    public static final double INCHES_TO_TICKS = 11.047;

    private double percentToReachMaxSpeed = .2;
    private double percentComplement = 1 - percentToReachMaxSpeed;
    private double maxSpeed = .9;
    private double currentSpeed;
    private double tickDistance;
    private double direction;

    private DrivetrainSubsystem drivetrainSubsystem;

    public TrapezoidalMotionProfile() {
        ServiceLocator.register(this);
    }

    public void setUpDrive(final double inchesToDrive) {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        tickDistance = inchesToTicks(inchesToDrive);
        direction = Math.signum(inchesToDrive);
    }

    protected double inchesToTicks(final double inches) {
        return inches * INCHES_TO_TICKS;
    }

    public double getCurrentSpeed() {
        currentSpeed = getNextSpeed();
        return currentSpeed;
    }

    private double getNextSpeed() {
        final double percentSpeed;
        if (!(atMaxSpeed())) {
            percentSpeed = nextPercentOfMax(getSpecificTail());
        } else {
            percentSpeed = 1;
        }
        currentSpeed = direction * maxSpeed * percentSpeed;
        return currentSpeed;
    }

    private double nextPercentOfMax(final boolean isLeftTail) {
        if (isLeftTail) {
            return getPastSpeedZero(getPercentCompleted())
                    / percentToReachMaxSpeed;
        } else {
            return (1 - getPercentCompleted()) / percentToReachMaxSpeed;
        }
    }

    private boolean getSpecificTail() {
        return getPercentCompleted() <= percentToReachMaxSpeed;
    }

    private boolean atMaxSpeed() {
        return percentToReachMaxSpeed < getPercentCompleted()
                && getPercentCompleted() < percentComplement;
    }

    private double getPastSpeedZero(final double percentComplete) {
        if (percentComplete < .02) {
            return percentComplete + .02;
        } else {
            return percentComplete;
        }
    }

    private double getPercentCompleted() {
        return drivetrainSubsystem.getLeftEncoderDistance() / tickDistance;
    }

    public boolean isFinishedMoving() {
        return getPercentCompleted() > .98 && getPercentCompleted() < 1.02;
    }
}
