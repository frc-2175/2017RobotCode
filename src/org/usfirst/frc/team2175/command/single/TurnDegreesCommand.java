package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;

public class TurnDegreesCommand extends BaseCommand {
    private final DrivetrainSubsystem drivetrainSubsystem;

    private final double degreesToTurn;

    // 0 for clockwise, 1 for counter clockwise, 2 for none
    private int turnDirection;

    public TurnDegreesCommand(double degreesToTurn) {
        super();
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        this.degreesToTurn = degreesToTurn;
        requires(drivetrainSubsystem);

    }

    @Override
    protected void initialize() {
        super.initialize();
        // this sets drivetrain speed turning based on
        // the degrees to turn and also sets the turn direction ^^
        // for later

        if (degreesToTurn > 0) {
            // TODO get speed value from properties file
            turnDirection = 0;
        }

        else if (degreesToTurn < 0) {
            // TODO get speed value from properties file
            turnDirection = 1;
        } else {
            turnDirection = 2;
        }

        drivetrainSubsystem.resetAnalogGyro();
    }

    @Override
    protected void execute() {
        if (degreesToTurn > 0) {
            // TODO get speed value from properties file
            drivetrainSubsystem.arcadeDrive(0, 1);

        }

        else if (degreesToTurn < 0) {
            // TODO get speed value from properties file
            drivetrainSubsystem.arcadeDrive(0, -1);
        }
    }

    @Override
    protected boolean isFinished() {
        if (turnDirection == 0) {
            return drivetrainSubsystem.getAnalogAngle() >= degreesToTurn;
        }

        else if (turnDirection == 1) {
            return drivetrainSubsystem.getAnalogAngle() <= degreesToTurn;
        }

        else {
            return true;
        }
    }

    @Override
    protected void end() {
        super.end();
        drivetrainSubsystem.stopAllMotors();
    }
}
