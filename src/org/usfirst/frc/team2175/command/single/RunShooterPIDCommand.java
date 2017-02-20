package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class RunShooterPIDCommand extends BaseCommand {
    private final ShooterSubsystem shooterSubsystem;

    public RunShooterPIDCommand() {
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
    }

    @Override
    protected void initialize() {
        super.initialize();
        shooterSubsystem.switchToPIDMode();
    }

    @Override
    protected void execute() {
        shooterSubsystem.setShooterDefaultSetpoint();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        super.end();
        shooterSubsystem.setShooterSpeedZero();
    }
}
