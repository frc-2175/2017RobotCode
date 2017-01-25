package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.ClimberSubsystem;

public class RunClimberCommand extends BaseCommand {
    private final ClimberSubsystem climberSubsystem;

    public RunClimberCommand() {
        climberSubsystem = ServiceLocator.get(ClimberSubsystem.class);
    }

    @Override
    protected void initialize() {
        super.initialize();
        // TODO get climber speed from properties file
        climberSubsystem.setClimberSpeed(1);
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        super.end();
        climberSubsystem.setClimberSpeed(0);
    }
}
