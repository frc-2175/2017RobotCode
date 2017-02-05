package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.driverstation.DriverStation;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;

public class DefaultFuelIntakeCommand extends BaseCommand {
    private final FuelIntakeSubsystem fuelIntakeSubsystem;
    private final DriverStation driverStation;

    public DefaultFuelIntakeCommand() {
        fuelIntakeSubsystem = ServiceLocator.get(FuelIntakeSubsystem.class);
        driverStation = ServiceLocator.get(DriverStation.class);
        requires(fuelIntakeSubsystem);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        if (driverStation.getRightPOVIsPressed()) {
            fuelIntakeSubsystem.setMotorSpeed(
                    fuelIntakeSubsystem.getMainMotorDefaultOutSpeed());
        } else {
            fuelIntakeSubsystem.setMotorSpeed(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        fuelIntakeSubsystem.setMotorSpeed(0);
    }
}
