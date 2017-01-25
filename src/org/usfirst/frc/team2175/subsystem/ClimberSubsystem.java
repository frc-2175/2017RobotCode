package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

public class ClimberSubsystem extends BaseSubsystem {
    private final CANTalon mainMotor;
    private final double mainMotorDefaultSpeed;

    public ClimberSubsystem() {
        super();
        WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        mainMotor = new CANTalon(wiringProperties.getClimberMainMotorNumber());
        mainMotorDefaultSpeed = behaviorProperties.getClimberMasterSpeed();
    }

    public void setClimberSpeed(double speed) {
        mainMotor.set(speed);
    }

    public double getMainMotorDefaultSpeed() {
        return mainMotorDefaultSpeed;
    }

}
