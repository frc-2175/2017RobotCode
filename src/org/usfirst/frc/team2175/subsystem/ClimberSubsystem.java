package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ReversibleTalon;
import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

public class ClimberSubsystem extends BaseSubsystem {

    private final CANTalon motorOne;
    private final CANTalon motorTwo;
    private final double maxClimberSpeed;

    public ClimberSubsystem() {
        final WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        final BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        motorOne = new ReversibleTalon(
                wiringProperties.getClimberMotorOneNumber());
        motorTwo = new ReversibleTalon(
                wiringProperties.getClimberMotorTwoNumber());
        motorTwo.changeControlMode(TalonControlMode.Follower);
        motorTwo.set(motorOne.getDeviceID());
        maxClimberSpeed = behaviorProperties.getMaxClimberSpeed();
        motorOne.reverseOutput(true);
    }

    public double getMaxClimberSpeed() {
        return maxClimberSpeed;
    }

    public void setClimberSpeed(final double speed) {
        if (speed > 0) {
            motorOne.set(speed);
        } else {
            motorOne.set(0);
        }
    }
}
