package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class RunShooterCommand extends BaseCommand {
    private final ShooterSubsystem shooterSubsystem;
    final double initialShooterSpeed = 1.0;
    final double initialFeederSpeed = 0.8;
    final double initialAgitatorSpeed = 0.5;

    public RunShooterCommand() {
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {

        shooterSubsystem.setMotorSpeed(initialShooterSpeed);

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        shooterSubsystem.setMotorSpeed(0);

    }

    @Override
    protected void interrupted() {
    }

}
