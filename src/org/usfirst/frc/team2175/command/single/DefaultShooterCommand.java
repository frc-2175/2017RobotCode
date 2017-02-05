package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.driverstation.DriverStation;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class DefaultShooterCommand extends BaseCommand {
    private final ShooterSubsystem shooterSubsystem;
    private final DriverStation driverStation;

    public DefaultShooterCommand() {
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
        driverStation = ServiceLocator.get(DriverStation.class);
        requires(shooterSubsystem);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        if (driverStation.getDownPOVIsPressed()) {
            shooterSubsystem.setShooterReverseSpeed();
        } else {
            shooterSubsystem.setShooterSpeedZero();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        shooterSubsystem.setShooterSpeedZero();
    }
}
