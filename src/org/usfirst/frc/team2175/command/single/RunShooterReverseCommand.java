package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class RunShooterReverseCommand extends BaseCommand {

    private final ShooterSubsystem shooterSubsystem;

    public RunShooterReverseCommand() {
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        // TODO get speed value from properties file
        shooterSubsystem.setShooterReverseSpeed();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        shooterSubsystem.setShooterMotorSpeedZero();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
