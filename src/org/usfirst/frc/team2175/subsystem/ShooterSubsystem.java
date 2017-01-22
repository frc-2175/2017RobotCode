package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

public class ShooterSubsystem extends BaseSubsystem {
    private final CANTalon shooterMotor;
    private final CANTalon feederMotor;
    private final CANTalon agitatorMotor;

    public ShooterSubsystem() {
        super();
        WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        shooterMotor = new CANTalon(
                wiringProperties.getShooterShooterMotorDeviceNumber());
        feederMotor = new CANTalon(
                wiringProperties.getShooterFeederMotorDeviceNumber());
        agitatorMotor = new CANTalon(
                wiringProperties.getShooterAgitatorMotorDeviceNumber());
    }

    public void setMotorSpeed(double shooterSpeed, double feederSpeed,
            double agitatorSpeed) {
        shooterMotor.set(shooterSpeed);
        feederMotor.set(feederSpeed);
        agitatorMotor.set(agitatorSpeed);
    }
}