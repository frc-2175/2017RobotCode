package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.driverstation.DriverStation;
import org.usfirst.frc.team2175.subsystem.drivetrain.DrivetrainSubsystem;

public class ArcadeDriveWithJoysticksCommand extends BaseCommand {

    private final DrivetrainSubsystem drivetrainSubsystem;
    private final DriverStation driverStation;

    public ArcadeDriveWithJoysticksCommand() {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        driverStation = ServiceLocator.get(DriverStation.class);

        requires(drivetrainSubsystem);
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected void execute() {
        double moveValue;
        double turnValue;
        if (driverStation.isPrecisionButtonPressed()) {
            moveValue = driverStation.getMoveValue() / 2;
            turnValue = driverStation.getTurnValue() / 2;
        } else {
            moveValue = driverStation.getMoveValue();
            turnValue = driverStation.getTurnValue();
        }
        drivetrainSubsystem.arcadeDrive(moveValue, turnValue);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        super.end();
        drivetrainSubsystem.stopAllMotors();
    }

}
