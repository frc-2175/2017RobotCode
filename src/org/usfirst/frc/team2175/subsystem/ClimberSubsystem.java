package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

public class ClimberSubsystem extends BaseSubsystem {
    CANTalon mainMotor;

    public ClimberSubsystem() {
        super();
        WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        mainMotor = new CANTalon(wiringProperties.getClimberMainMotorNumber());
    }

    public void setClimberSpeed(double speed) {
        mainMotor.set(speed);
    }
}
