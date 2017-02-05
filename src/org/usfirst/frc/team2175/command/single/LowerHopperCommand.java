package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;

public class LowerHopperCommand extends BaseCommand {

    FuelIntakeSubsystem fuelIntakeSubsystem;

    public LowerHopperCommand() {
        fuelIntakeSubsystem = ServiceLocator.get(FuelIntakeSubsystem.class);
    }

    @Override
    protected void initialize() {
        super.initialize();
        fuelIntakeSubsystem.lowerHopper();
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
        fuelIntakeSubsystem.raiseHopper();
    }

}
