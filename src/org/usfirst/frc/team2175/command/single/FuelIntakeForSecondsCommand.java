package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;

public class FuelIntakeForSecondsCommand extends BaseCommand {

    // TODO: Is this command even necessary?

    private final FuelIntakeSubsystem fuelIntakeSubsystem;

    private final double timeToSpin;

    public FuelIntakeForSecondsCommand(double timeToSpin) {
        super();
        fuelIntakeSubsystem = ServiceLocator.get(FuelIntakeSubsystem.class);
        this.timeToSpin = timeToSpin;

        // TODO: Make this command require the fuel intake subsystem.
    }

    @Override
    protected void initialize() {
        super.initialize();
        // TODO: Do we really want to use the default *out* speed here?
        fuelIntakeSubsystem.setMotorSpeed(
                fuelIntakeSubsystem.getMainMotorDefaultOutSpeed());
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
