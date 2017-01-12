package org.usfirst.frc.team2175.commandmapper;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.EmptyCommand;
import org.usfirst.frc.team2175.driverstation.DriverStation;

public class JoystickEventMapper {

    public JoystickEventMapper() {
        DriverStation driverStation = ServiceLocator.get(DriverStation.class);

        driverStation.getShiftButton().whenPressed(new EmptyCommand());
        driverStation.getShiftButton().whenReleased(new EmptyCommand());
    }

}
