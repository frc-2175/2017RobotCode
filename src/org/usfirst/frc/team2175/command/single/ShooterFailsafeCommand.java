package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.driverstation.DriverStation;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class ShooterFailsafeCommand extends BaseCommand {

    private final ShooterSubsystem shooterSubsystem;
    private final DriverStation driverStation;

    public ShooterFailsafeCommand() {
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
        driverStation = ServiceLocator.get(DriverStation.class);

        requires(shooterSubsystem);
    }

    @Override
    protected void initialize() {
        super.initialize();
        shooterSubsystem.setShooterReverseSpeed();
        shooterSubsystem.setFeederReverseSpeed();
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
        shooterSubsystem.setShooterSpeedZero();
        shooterSubsystem.setFeederSpeedZero();
    }
}
