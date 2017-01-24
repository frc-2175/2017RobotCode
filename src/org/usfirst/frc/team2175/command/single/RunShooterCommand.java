package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

import edu.wpi.first.wpilibj.Joystick;

public class RunShooterCommand extends BaseCommand {
    private final ShooterSubsystem shooterSubsystem;
    final double initialShooterSpeed = 1.0;
    final double initialFeederSpeed = 0.8;
    final double initialAgitatorSpeed = 0.5;
    Joystick gamepad;

    public RunShooterCommand() {
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
    }

    @Override
    protected void initialize() {

        if (gamepad.getRawButton(7)) {
            shooterSubsystem.setMotorSpeed(initialShooterSpeed);
        } else if (gamepad.getRawButton(8)) {
            shooterSubsystem.setMotorSpeedFeeder(initialFeederSpeed);
            shooterSubsystem.setMotorSpeedAgitator(initialAgitatorSpeed);
        }

        else {
            shooterSubsystem.setMotorSpeedFeeder(0);
            shooterSubsystem.setMotorSpeedAgitator(0);
        }
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
        shooterSubsystem.setMotorSpeed(0);
        shooterSubsystem.setMotorSpeedFeeder(0);
        shooterSubsystem.setMotorSpeedAgitator(0);
    }

    @Override
    protected void interrupted() {
    }

}
