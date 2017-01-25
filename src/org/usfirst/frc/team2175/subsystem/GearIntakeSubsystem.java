package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

/**
 *
 */
public class GearIntakeSubsystem extends BaseSubsystem {

    private CANTalon leftIntakeMotor;
    private CANTalon rightIntakeMotor;

    private double gearIntakeInSpeed;
    private double gearIntakeOutSpeed;

    public GearIntakeSubsystem() {
        WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        leftIntakeMotor =
                new CANTalon(wiringProperties.getLeftGearIntakeDeviceNumber());
        rightIntakeMotor =
                new CANTalon(wiringProperties.getRightGearIntakeDeviceNumber());

        gearIntakeInSpeed = behaviorProperties.getGearIntakeInSpeed();
        gearIntakeOutSpeed = behaviorProperties.getGearIntakeOutSpeed();
    }

    public void runIn() {
        leftIntakeMotor.set(gearIntakeInSpeed);
        rightIntakeMotor.set(-gearIntakeInSpeed);
    }

    public void runOut() {
        leftIntakeMotor.set(-gearIntakeOutSpeed);
        rightIntakeMotor.set(gearIntakeOutSpeed);
    }

    public void stop() {
        leftIntakeMotor.set(0);
        rightIntakeMotor.set(0);
    }
}
