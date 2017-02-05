package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;

public class RunFuelIntakeOutCommand extends BaseCommand {

    private final FuelIntakeSubsystem fuelIntakeSubsystem;

    public RunFuelIntakeOutCommand() {
        fuelIntakeSubsystem = ServiceLocator.get(FuelIntakeSubsystem.class);

        // TODO: Make this command require the fuel intake subsystem.
    }

    @Override
    protected void initialize() {
        super.initialize();
        fuelIntakeSubsystem.setMotorSpeed(
                fuelIntakeSubsystem.getMainMotorDefaultOutSpeed());
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

}
