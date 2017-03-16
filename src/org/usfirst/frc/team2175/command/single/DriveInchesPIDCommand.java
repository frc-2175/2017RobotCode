package org.usfirst.frc.team2175.command.single;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.drivetrain.DrivetrainSubsystem;

/**
 *
 */
public class DriveInchesCommand extends BaseCommand {
    private final Logger log = Logger.getLogger(getClass().getName());

    private final DrivetrainSubsystem drivetrainSubsystem;
    private final double distance;

    public DriveInchesCommand(final double distance) {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        requires(drivetrainSubsystem);
        drivetrainSubsystem.switchToPID();

        this.distance = distance;

        log.finer("DriveInchesCommand distance=" + distance);
    }

    @Override
    protected void initialize() {
        super.initialize();
        drivetrainSubsystem.setSetpoints(distance, distance);
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        super.end();
        log.info("DriveInches: end");
        drivetrainSubsystem.switchToPercentVbus();
    }
}
