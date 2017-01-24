package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;

public class FuelIntakeActuateInCommand extends BaseCommand {
    FuelIntakeSubsystem fuelIntakeSubsystem;

    public FuelIntakeActuateInCommand() {
        super();
        fuelIntakeSubsystem = ServiceLocator.get(FuelIntakeSubsystem.class);
    }

    @Override
    protected void initialize() {
        super.initialize();
        fuelIntakeSubsystem.actuateIn();
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
    }

    @Override
    protected void interrupted() {
    }
}
