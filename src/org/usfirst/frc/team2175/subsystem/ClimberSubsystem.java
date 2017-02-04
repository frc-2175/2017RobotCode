package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

public class ClimberSubsystem extends BaseSubsystem {
    private final CANTalon motorOne;
    private final CANTalon motorTwo;
    private final double mainMotorDefaultSpeed;

    public ClimberSubsystem() {
        super();
        WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        motorOne = new CANTalon(wiringProperties.getClimberMotorOneNumber());
        motorTwo = new CANTalon(wiringProperties.getClimberMotorTwoNumber());
        mainMotorDefaultSpeed = behaviorProperties.getClimberMasterSpeed();
    }

    public void setClimberSpeed(double speed) {
        motorOne.set(speed);
        motorTwo.set(speed);
    }

    public double getMainMotorDefaultSpeed() {
        return mainMotorDefaultSpeed;
    }

}
