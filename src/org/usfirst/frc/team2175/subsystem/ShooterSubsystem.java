package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

public class ShooterSubsystem extends BaseSubsystem
{
    CANTalon shooterMotor;
    CANTalon feederMotor;
    CANTalon agitatorMotor;

    public ShooterSubsystem() {
	WiringProperties wiringProperties = ServiceLocator.get(WiringProperties.class);
	shooterMotor = new CANTalon(wiringProperties.getShooterShooterMotorDeviceNumber());
	feederMotor = new CANTalon(wiringProperties.getShooterFeederMotorDeviceNumber());
	agitatorMotor = new CANTalon(wiringProperties.getShooterAgitatorMotorDeviceNumber());

    }

}