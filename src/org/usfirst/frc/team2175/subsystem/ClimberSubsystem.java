package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

public class ClimberSubsystem extends BaseSubsystem {

    private final CANTalon motorOne;
    private final CANTalon motorTwo;
    private final double mainMotorDefaultSpeed;

    public ClimberSubsystem() {
        final WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        final BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        motorOne = new CANTalon(wiringProperties.getClimberMotorOneNumber());
        motorTwo = new CANTalon(wiringProperties.getClimberMotorTwoNumber());
        motorTwo.changeControlMode(TalonControlMode.Follower);
        motorTwo.set(motorOne.getDeviceID());
        mainMotorDefaultSpeed = behaviorProperties.getClimberMasterSpeed();
    }

    public void setClimberSpeed(final double speed) {
        motorOne.set(speed);
    }

    public double getMainMotorDefaultSpeed() {
        return mainMotorDefaultSpeed;
    }

}
