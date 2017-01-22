package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class RunShooterCommand extends BaseCommand
{
    private final ShooterSubsystem shooterSubsystem;
    double initialShooterSpeed = 1.0;
    double initialFeederSpeed = 0.8;
    double initialAgitatorSpeed = 0.5;

    public RunShooterCommand() {
	shooterSubsystem = new ShooterSubsystem();
    }

    @Override
    protected void initialize()
    {

	shooterSubsystem.setMotorSpeed(initialShooterSpeed, initialFeederSpeed, initialAgitatorSpeed);

    }

    @Override
    protected void execute()
    {
    }

    @Override
    protected boolean isFinished()
    {
	return true;
    }

    @Override
    protected void end()
    {
    }

    @Override
    protected void interrupted()
    {
    }

}
