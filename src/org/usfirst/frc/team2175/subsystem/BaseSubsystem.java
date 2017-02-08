package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BaseSubsystem extends Subsystem {

    public BaseSubsystem() {
        ServiceLocator.register(this);
    }

    /**
     * Empty implementation.
     *
     * DO NOT override this in subsystems. Use {@link setDefaultCommand}
     * instead.
     */
    @Override
    protected void initDefaultCommand() {
    }

    @Override
    public void setDefaultCommand(final Command command) {
        super.setDefaultCommand(command);
    }

}
