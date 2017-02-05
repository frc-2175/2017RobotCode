package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.driverstation.DriverStation;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;

public class DefaultFuelIntakeCommand extends BaseCommand {

    // TODO noahconnors: Give this command a more descriptive name. What does it
    // actually do?

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
        // TODO noahconnors: Using a method like `getRightPOVIsPressed` assumes
        // we always want to run the fuel intake off the right POV. Let's make a
        // method on DriverStation like 'shouldRunFuelIntakeOut' instead.
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
