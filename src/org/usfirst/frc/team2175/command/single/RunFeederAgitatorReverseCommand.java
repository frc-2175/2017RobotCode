package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class RunFeederAgitatorReverseCommand extends BaseCommand {

    private final ShooterSubsystem shooterSubsystem;

    public RunFeederAgitatorReverseCommand() {
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        // TODO: Do we even need to run the agitator in reverse?
        shooterSubsystem.setAgitatorReverseSpeed();
        shooterSubsystem.setFeederReverseSpeed();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        shooterSubsystem.setAgitatorSpeedZero();
        shooterSubsystem.setFeederSpeedZero();
    }

    @Override
    protected void interrupted() {
        end();
    }

}
