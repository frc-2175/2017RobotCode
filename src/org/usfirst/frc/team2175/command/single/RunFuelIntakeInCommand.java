package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class RunFuelIntakeInCommand extends BaseCommand {

    private final FuelIntakeSubsystem fuelIntakeSubsystem;
    private ShooterSubsystem shooterSubsystem;

    public RunFuelIntakeInCommand() {
        fuelIntakeSubsystem = ServiceLocator.get(FuelIntakeSubsystem.class);
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);

        requires(fuelIntakeSubsystem);
        requires(shooterSubsystem);
    }

    @Override
    protected void initialize() {
        super.initialize();
        fuelIntakeSubsystem.setMotorSpeed(
                fuelIntakeSubsystem.getMainMotorDefaultInSpeed());
        shooterSubsystem.setAgitatorDefaultSpeed();
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
        shooterSubsystem.setAgitatorSpeedZero();
    }
}
