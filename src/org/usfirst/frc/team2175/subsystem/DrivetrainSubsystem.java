package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;

public class DrivetrainSubsystem extends BaseSubsystem {

    private CANTalon leftMotor;
    private CANTalon rightMotor;

    private RobotDrive robotDrive;

    public DrivetrainSubsystem() {
    	super();
    	
        WiringProperties wiringProperties = ServiceLocator.get(WiringProperties.class);

        leftMotor = new CANTalon(wiringProperties.getDriveLeftMotorDeviceNumber());
        rightMotor = new CANTalon(wiringProperties.getDriveRightMotorDeviceNumber());

        robotDrive = new RobotDrive(leftMotor, rightMotor);
    }

    public void arcadeDrive(double moveValue, double rotateValue) {
        robotDrive.arcadeDrive(moveValue, rotateValue);
    }

}
