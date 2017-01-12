package org.usfirst.frc.team2175.command;

import java.util.logging.Logger;

import edu.wpi.first.wpilibj.command.Command;

public abstract class BaseCommand extends Command {

    protected final Logger log = Logger.getLogger(getClass().getName());

    @Override
    protected void initialize() {
        log.info("Starting command '" + getClass().getName() + "'");
    }

    @Override
    protected void end() {
        log.info("Ending command '" + getClass().getName() + "'");
    }

    @Override
    protected void interrupted() {
        end();
    }

}
