package org.usfirst.frc.team2175.command.single;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;

public class ShiftToHighGearCommand extends BaseCommand {

    private final DrivetrainSubsystem drivetrainSubsystem;
    private final Logger log = Logger.getLogger(getClass().getName());

    public ShiftToHighGearCommand() {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        super.initialize();
        log.log(Level.FINE, "Shifting to low gear");
        drivetrainSubsystem.shiftToHighGear();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        super.end();
        drivetrainSubsystem.shiftToLowGear();
        log.log(Level.FINE, "Shifting to high gear");
    }

}
