package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class ActuateBothShootersOutCommand extends BaseCommand {
    private final ShooterSubsystem shooterSubsystem;

    public ActuateBothShootersOutCommand() {
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
    }

    @Override
    protected void initialize() {
        super.initialize();
        shooterSubsystem.actuateBothShootersOut();
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
        shooterSubsystem.actuateBothShootersIn();
    }
}
