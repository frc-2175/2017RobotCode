package org.usfirst.frc.team2175.command.single;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;

import edu.wpi.first.wpilibj.PIDController;

/**
 *
 */
public class DriveInchesCommand extends BaseCommand {
    private final Logger log = Logger.getLogger(getClass().getName());

    private final DrivetrainSubsystem drivetrainSubsystem;
    private final PIDController pidController;
    private final double distance;

    public DriveInchesCommand(double distance, PIDController pidController) {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        requires(drivetrainSubsystem);

        this.distance = distance;

        this.pidController = pidController;

        log.finer("DriveInchesCommand distance=" + distance);
    }

    @Override
    protected void initialize() {
        super.initialize();
        pidController.setSetpoint(distance);
        pidController.enable();
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {

        log.info("PID controller error=" + pidController.getError());
        log.info("PID controller avg error=" + pidController.getAvgError());

        return pidController.onTarget();
    }

    @Override
    protected void end() {
        super.end();

        log.info("DriveInches: end");

        log.info("PID controller error=" + pidController.getError());
        log.info("PID controller avg error=" + pidController.getAvgError());

        pidController.disable();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
