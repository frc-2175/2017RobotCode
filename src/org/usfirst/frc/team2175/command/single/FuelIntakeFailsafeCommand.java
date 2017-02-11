package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.driverstation.DriverStation;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;

public class FuelIntakeFailsafeCommand extends BaseCommand {

    private final FuelIntakeSubsystem fuelIntakeSubsystem;
    private final DriverStation driverStation;

    public FuelIntakeFailsafeCommand() {
        fuelIntakeSubsystem = ServiceLocator.get(FuelIntakeSubsystem.class);
        driverStation = ServiceLocator.get(DriverStation.class);

        requires(fuelIntakeSubsystem);
    }

    @Override
    protected void initialize() {
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
        fuelIntakeSubsystem.setMotorSpeed(0);
    }

}
