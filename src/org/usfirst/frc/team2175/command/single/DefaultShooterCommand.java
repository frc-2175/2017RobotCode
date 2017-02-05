package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.driverstation.DriverStation;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class DefaultShooterCommand extends BaseCommand {

    // TODO noahconnors: Give this command a more descriptive name. What does it
    // actually do?

    private final ShooterSubsystem shooterSubsystem;
    private final DriverStation driverStation;

    public DefaultShooterCommand() {
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
        driverStation = ServiceLocator.get(DriverStation.class);

        requires(shooterSubsystem);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        // TODO noahconnors: Like in DefaultFuelIntakeCommand, let's make a more
        // descriptive method on DriverStation like `shouldRunShooterInReverse`.
        if (driverStation.getDownPOVIsPressed()) {
            shooterSubsystem.setShooterReverseSpeed();
        } else {
            shooterSubsystem.setShooterSpeedZero();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        shooterSubsystem.setShooterSpeedZero();
    }

    // TODO: This might be a command where we want to handle interrupts
    // differently. If another command takes over the shooter, do we really want
    // to call end() and stop the shooter wheels?

}
