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
        // TODO put pid stuff here
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
    }
}
