package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;

public class RunFuelIntakeInCommand extends BaseCommand {
    FuelIntakeSubsystem fuelIntakeSubsystem;

    public RunFuelIntakeInCommand() {
        super();
        fuelIntakeSubsystem = ServiceLocator.get(FuelIntakeSubsystem.class);
    }

    @Override
    protected void initialize() {
        super.initialize();
        // TODO get speed value from properties file
        fuelIntakeSubsystem.setMotorSpeed(
                fuelIntakeSubsystem.getMainMotorDefaultInSpeed());
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
        fuelIntakeSubsystem.setMotorSpeed(0);
    }

    @Override
    protected void interrupted() {
    }
}
