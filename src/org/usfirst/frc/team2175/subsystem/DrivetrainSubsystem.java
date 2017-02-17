package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

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

    // TODO (later): Switch to using the NavX MXP
    private AnalogGyro analogGyro;

    public DrivetrainSubsystem() {
        final WiringProperties wiringProperties =
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
        switchToPercentVbus();
    }

    public void arcadeDrive(final double moveValue, final double rotateValue) {
        robotDrive.arcadeDrive(-moveValue, rotateValue);
    }

    private void setGear(final DoubleSolenoid.Value value) {
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

    public void switchToPID() {
        leftMasterMotor.changeControlMode(TalonControlMode.Position);
        leftMasterMotor.setProfile(0);
        leftMasterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        rightMasterMotor.changeControlMode(TalonControlMode.Position);
        rightMasterMotor.setProfile(0);
        rightMasterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    }

    public void switchToPercentVbus() {
        leftMasterMotor.changeControlMode(TalonControlMode.PercentVbus);
        rightMasterMotor.changeControlMode(TalonControlMode.PercentVbus);
    }

    public double getCurrentEncPosition() {
        return leftMasterMotor.getEncPosition();
    }

    public void setSetpoints(final double leftSetpoint,
            final double rightSetpoint) {
        leftMasterMotor.setSetpoint(convertFromInchesToClicks(leftSetpoint));
        rightMasterMotor.setSetpoint(convertFromInchesToClicks(rightSetpoint));
    }

    // TODO make this method actually return the number of clicks per inches
    // given. Right now, we cannot see how many clicks there are per inch
    // driven.
    public double convertFromInchesToClicks(final double inches) {
        return inches * 1;
    }
}
