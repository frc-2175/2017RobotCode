package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class RunShooterReverseCommand extends BaseCommand {

    private final ShooterSubsystem shooterSubsystem;

    public RunShooterReverseCommand() {
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
        requires(shooterSubsystem);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        shooterSubsystem.setShooterReverseSpeed();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        shooterSubsystem.setShooterSpeedZero();
    }

    @Override
    protected void interrupted() {
        end();
    }

}
