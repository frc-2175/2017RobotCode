package org.usfirst.frc.team2175.command;

import java.util.logging.Logger;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BaseCommandGroup extends CommandGroup {

    protected final Logger log = Logger.getLogger(getClass().getName());

    @Override
    protected void initialize() {
        log.info("Starting command group '" + getClass().getName() + "'");
        super.initialize();
    }

    @Override
    protected void end() {
        log.info("Ending command group '" + getClass().getName() + "'");
        super.end();
    }

}
