package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;

public class DrivetrainSubsystem extends BaseSubsystem {

    private CANTalon leftMasterMotor;
    private CANTalon rightMasterMotor;
    private CANTalon leftSlaveMotorOne;
    private CANTalon leftSlaveMotorTwo;
    private CANTalon rightSlaveMotorOne;
    private CANTalon rightSlaveMotorTwo;

    private RobotDrive robotDrive;

    private DoubleSolenoid driveShifters;

    private AnalogGyro analogGyro;

    public DrivetrainSubsystem() {
        super();

        WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);

        leftMasterMotor =
                new CANTalon(wiringProperties.getLeftMasterMotorNumber());
        leftSlaveMotorOne =
                new CANTalon(wiringProperties.getLeftSlaveMotorOneNumber());
        leftSlaveMotorTwo =
                new CANTalon(wiringProperties.getLeftSlaveMotorTwoNumber());
        rightMasterMotor =
                new CANTalon(wiringProperties.getRightMasterMotorNumber());
        rightSlaveMotorOne =
                new CANTalon(wiringProperties.getRightSlaveMotorOneNumber());
        rightSlaveMotorTwo =
                new CANTalon(wiringProperties.getRightSlaveMotorTwoNumber());

        leftSlaveMotorOne.changeControlMode(CANTalon.TalonControlMode.Follower);
        leftSlaveMotorOne.set(leftMasterMotor.getDeviceID());

        leftSlaveMotorTwo.changeControlMode(CANTalon.TalonControlMode.Follower);
        leftSlaveMotorTwo.set(leftMasterMotor.getDeviceID());

        rightSlaveMotorOne
                .changeControlMode(CANTalon.TalonControlMode.Follower);
        rightSlaveMotorOne.set(rightMasterMotor.getDeviceID());

        rightSlaveMotorTwo
                .changeControlMode(CANTalon.TalonControlMode.Follower);
        rightSlaveMotorTwo.set(rightMasterMotor.getDeviceID());

        driveShifters = new DoubleSolenoid(
                wiringProperties.getDriveShiftersForwardNumber(),
                wiringProperties.getDriveShiftersReverseNumber());

        robotDrive = new RobotDrive(leftMasterMotor, rightMasterMotor);

        analogGyro = new AnalogGyro(
                wiringProperties.getDrivetrainAnalogGyroDeviceNumber());
    }

    public void arcadeDrive(double moveValue, double rotateValue) {
        robotDrive.arcadeDrive(moveValue, rotateValue);
    }

    private void setGear(DoubleSolenoid.Value value) {
        driveShifters.set(value);
    }

    public void shiftToHighGear() {
        setGear(DoubleSolenoid.Value.kForward);
    }

    public void shiftToLowGear() {
        setGear(DoubleSolenoid.Value.kReverse);
    }

    public void stopAllMotors() {
        leftMasterMotor.set(0);
        rightMasterMotor.set(0);
    }

    public double getGyroAngle() {
        return analogGyro.getAngle();
    }

    public void resetGyro() {
        analogGyro.reset();
    }
}
