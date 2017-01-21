package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

/**
 *
 */
public class GearIntakeSubsystem extends BaseSubsystem {

    private CANTalon leftIntakeMotor;
    private CANTalon rightIntakeMotor;

    public GearIntakeSubsystem() {
        WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        leftIntakeMotor =
                new CANTalon(wiringProperties.getLeftGearIntakeDeviceNumber());
        rightIntakeMotor =
                new CANTalon(wiringProperties.getRightGearIntakeDeviceNumber());
    }

    public void setIntakeSpeed(double speed) {
        leftIntakeMotor.set(speed);
        rightIntakeMotor.set(speed);
    }
}
