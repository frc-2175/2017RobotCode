package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RunShooterOutCommand extends BaseCommand {

    private final ShooterSubsystem shooterSubsystem;

    public RunShooterOutCommand() {
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);

        requires(shooterSubsystem);
    }

    @Override
    protected void initialize() {
        super.initialize();
        shooterSubsystem.switchToPercentVbus();
    }

    @Override
    protected void execute() {
        shooterSubsystem.setShooterDefaultSpeed();
        SmartDashboard.putNumber("Shooter speed",
                shooterSubsystem.getShooterSpeed());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        super.end();
        shooterSubsystem.setShooterSpeedZero();
    }

}
