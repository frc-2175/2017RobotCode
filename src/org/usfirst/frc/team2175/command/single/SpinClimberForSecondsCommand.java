package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.ClimberSubsystem;

public class SpinClimberForSecondsCommand extends BaseCommand {

    // TODO: Is this command even necessary?

    private final ClimberSubsystem climberSubsystem;
    private final double timeToSpin;

    public SpinClimberForSecondsCommand(double timeToSpin) {
        climberSubsystem = ServiceLocator.get(ClimberSubsystem.class);
        this.timeToSpin = timeToSpin;
    }

    @Override
    protected void initialize() {
        super.initialize();
        climberSubsystem
                .setClimberSpeed(climberSubsystem.getMainMotorDefaultSpeed());
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return timeSinceInitialized() >= timeToSpin;
    }

    @Override
    protected void end() {
        super.end();
        climberSubsystem.setClimberSpeed(0);
    }

}
