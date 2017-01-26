package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class RunShooterCommand extends BaseCommand {
    private final ShooterSubsystem shooterSubsystem;

    public RunShooterCommand() {
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {

        shooterSubsystem.setMotorSpeed();

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
    }

}
