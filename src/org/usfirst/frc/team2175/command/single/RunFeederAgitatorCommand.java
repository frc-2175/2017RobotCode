package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class RunFeederAgitatorCommand extends BaseCommand {

    private final ShooterSubsystem shooterSubsystem;

    public RunFeederAgitatorCommand() {
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        shooterSubsystem.setAgitatorReverseSpeed();

        shooterSubsystem.setFeederReverseSpeed();

    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        shooterSubsystem.setFeederMotorSpeedZero();
        shooterSubsystem.setAgitatorMotorSpeedZero();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
