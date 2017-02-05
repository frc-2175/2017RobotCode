package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;

public class FuelIntakeForSecondsCommand extends BaseCommand {

    // TODO: Is this command even necessary?

    private final FuelIntakeSubsystem fuelIntakeSubsystem;

    private final double timeToSpin;

    public FuelIntakeForSecondsCommand(final double timeToSpin) {
        super();
        fuelIntakeSubsystem = ServiceLocator.get(FuelIntakeSubsystem.class);
        this.timeToSpin = timeToSpin;
        requires(fuelIntakeSubsystem);
    }

    @Override
    protected void initialize() {
        super.initialize();
        fuelIntakeSubsystem.setMotorSpeed(
                fuelIntakeSubsystem.getMainMotorDefaultInSpeed());
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
