package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.driverstation.DriverStation;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class RunShooterOnAxisCommand extends BaseCommand {
    ShooterSubsystem shooterSubsystem;
    DriverStation driverStation;

    public RunShooterOnAxisCommand() {
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
        driverStation = ServiceLocator.get(DriverStation.class);
        requires(shooterSubsystem);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        shooterSubsystem.setShooterToSpeed(
                -driverStation.getShooterTurnSpeed() * 0.875);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
    }
}
