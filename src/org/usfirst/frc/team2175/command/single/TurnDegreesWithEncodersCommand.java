package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;

public class TurnDegreesWithEncodersCommand extends BaseCommand {

    private final DrivetrainSubsystem drivetrainSubsystem;

    private final double degreesToTurn;
    private int turnDirection;
    private double setpointOfTurn;

    public TurnDegreesWithEncodersCommand(final double degreesToTurn) {
        super();
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);

        this.degreesToTurn = degreesToTurn;

        requires(drivetrainSubsystem);
    }

    @Override
    protected void initialize() {
        super.initialize();

        // Clockwise is negative, CounterClockwise is positive
        if (degreesToTurn != 0) {
            turnDirection = (int) (degreesToTurn / Math.abs(degreesToTurn));
        } else {
            end();
        }

        drivetrainSubsystem.resetEncoders();
        drivetrainSubsystem.resetGyro();

        setpointOfTurn = getSetpointOfTurn(degreesToTurn);
        final double endPosition =
                turnDirection * getSetpointOfTurn(degreesToTurn);
        drivetrainSubsystem.setSetpoints(-endPosition, endPosition);
    }

    private double getSetpointOfTurn(final double degreesToTurn) {
        // Circumference = 2 * pi * radius
        // Degrees to radians = degrees * pi / 180
        // Distance using circumference = degreesToRadians * pi * radius
        final double radiansToTurn = degreesToTurn * Math.PI / 180;
        return radiansToTurn * Math.PI * drivetrainSubsystem.RADIUSOFTURN;
    }

    @Override
    protected void execute() {
        final double encPos = drivetrainSubsystem.getCurrentEncPosition();
        final double driveFactor = Math.abs(setpointOfTurn - encPos);
        drivetrainSubsystem.arcadeDrive(0, -turnDirection * 0.02 / driveFactor);
    }

    @Override
    protected boolean isFinished() {
        final double gyroAngle = drivetrainSubsystem.getGyroAngle();
        return turnDirection * gyroAngle >= turnDirection * degreesToTurn;
    }

    @Override
    protected void end() {
        super.end();
        drivetrainSubsystem.stopAllMotors();
    }

}
