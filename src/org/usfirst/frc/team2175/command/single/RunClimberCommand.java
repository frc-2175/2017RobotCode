package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.driverstation.DriverStation;
import org.usfirst.frc.team2175.subsystem.ClimberSubsystem;

public class RunClimberCommand extends BaseCommand {
    private final ClimberSubsystem climberSubsystem;
    private final DriverStation driverStation;

    public RunClimberCommand() {
        climberSubsystem = ServiceLocator.get(ClimberSubsystem.class);
        driverStation = ServiceLocator.get(DriverStation.class);
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected void execute() {
        climberSubsystem.setClimberSpeed(driverStation.getClimberSpinSpeed());
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
