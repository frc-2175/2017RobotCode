package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;

public class FuelIntakeActuateOutCommand extends BaseCommand {
    FuelIntakeSubsystem fuelIntakeSubsystem;

    public FuelIntakeActuateOutCommand() {
        super();
        fuelIntakeSubsystem = ServiceLocator.get(FuelIntakeSubsystem.class);
    }

    @Override
    protected void initialize() {
        super.initialize();
        fuelIntakeSubsystem.actuateOut();
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
        super.end();
    }

    @Override
    protected void interrupted() {
    }
}
