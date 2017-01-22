package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;

public class FuelIntakeForSecondsCommand extends BaseCommand {
    private final FuelIntakeSubsystem fuelIntakeSubsystem;

    private final double timeToSpin;

    public FuelIntakeForSecondsCommand(double timeToSpin) {
        super();
        fuelIntakeSubsystem = ServiceLocator.get(FuelIntakeSubsystem.class);
        this.timeToSpin = timeToSpin;
    }

    @Override
    protected void initialize() {
        super.initialize();
        // TODO Load speed value from properties file
        fuelIntakeSubsystem.setMotorSpeed(1);
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
        fuelIntakeSubsystem.setMotorSpeed(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
