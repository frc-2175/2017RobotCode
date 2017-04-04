package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class RunFeedingMechanismsCommand extends BaseCommand {

    private final ShooterSubsystem shooterSubsystem;

    public RunFeedingMechanismsCommand() {
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected void execute() {
        if (shooterSubsystem.isShooterRunning()) {
            shooterSubsystem.setFeederDefaultSpeed();
            shooterSubsystem.setAgitatorDefaultSpeed();
            shooterSubsystem.setAugerDefaultSpeed();
        } else {
            shooterSubsystem.setFeederSpeedZero();
            shooterSubsystem.setAgitatorSpeedZero();
            shooterSubsystem.setAugerSpeedZero();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        super.end();
        shooterSubsystem.setFeederSpeedZero();
        shooterSubsystem.setAgitatorSpeedZero();
    }

}
