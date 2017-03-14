package org.usfirst.frc.team2175.subsystem.drivetrain;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.SolenoidWrapper;
import org.usfirst.frc.team2175.properties.WiringProperties;
import org.usfirst.frc.team2175.subsystem.BaseSubsystem;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;

public class DrivetrainSubsystem extends BaseSubsystem {

    public static final double RADIUSOFTURN = 29.2371 / 2;

    private CANTalon leftMasterMotor;
    private CANTalon rightMasterMotor;
    private CANTalon leftSlaveMotorOne;
    private CANTalon leftSlaveMotorTwo;
    private CANTalon rightSlaveMotorOne;
    private CANTalon rightSlaveMotorTwo;

    private Encoder leftEncoder;
    private Encoder rightEncoder;
    private RobotDrive robotDrive;

    private SolenoidWrapper driveShifters;

    private AHRS navXGyro;

    public DrivetrainSubsystem() {
        final WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);

        leftMasterMotor =
                motorFromInfo(wiringProperties.getLeftMasterMotorInfo());
        leftSlaveMotorOne =
                motorFromInfo(wiringProperties.getLeftSlaveMotorOneInfo());
        leftSlaveMotorTwo =
                motorFromInfo(wiringProperties.getLeftSlaveMotorTwoInfo());
        rightMasterMotor =
                motorFromInfo(wiringProperties.getRightMasterMotorInfo());
        rightSlaveMotorOne =
                motorFromInfo(wiringProperties.getRightSlaveMotorOneInfo());
        rightSlaveMotorTwo =
                motorFromInfo(wiringProperties.getRightSlaveMotorTwoInfo());

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

        driveShifters = new SolenoidWrapper(
                wiringProperties.getDriveShiftersSolenoidInfo());

        robotDrive = new RobotDrive(leftMasterMotor, rightMasterMotor);

        navXGyro = new AHRS(SPI.Port.kMXP);
        switchToPercentVbus();
        // TODO Propertize
        leftEncoder = new Encoder(2, 3, true);
        leftEncoder.setDistancePerPulse(1);
        rightEncoder = new Encoder(0, 1, false);
        rightEncoder.setDistancePerPulse(1);

    }

    public void arcadeDrive(final double moveValue, final double rotateValue) {
        robotDrive.arcadeDrive(-moveValue, rotateValue);
    }

    public void straightArcadeDrive(final double moveValue) {
        if (Math.abs(getGyroAngle()) <= .25) {
            arcadeDrive(moveValue, 0);
        } else {
            arcadeDrive(moveValue, -(getGyroAngle() / 45));
        }

    }

    private void setGear(final boolean forward) {
        driveShifters.set(forward);
    }

    public void shiftToHighGear() {
        setGear(false);
    }

    public void shiftToLowGear() {
        setGear(true);
    }

    public void stopAllMotors() {
        leftMasterMotor.set(0);
        rightMasterMotor.set(0);
    }

    public double getGyroAngle() {
        return navXGyro.getAngle();
    }

    public void resetGyro() {
        navXGyro.reset();
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

    public void setSetpoints(final double leftSetpoint,
            final double rightSetpoint) {
        leftMasterMotor.setSetpoint(convertFromInchesToClicks(leftSetpoint));
        rightMasterMotor.setSetpoint(convertFromInchesToClicks(rightSetpoint));
    }

    // TODO make this method actually return the number of clicks per inches
    // given. Right now, we cannot see how many clicks there are per inch
    // driven.
    public double convertFromInchesToClicks(final double inches) {
        return inches * 54.518;
    }

    public void resetEncoders() {
        rightEncoder.reset();
        leftEncoder.reset();
    }

    public double getLeftEncoderDistance() {
        return leftEncoder.getDistance();
    }

    public double getLeftEncoderSpeed() {
        return leftEncoder.getRate();
    }

    public double getOutputCurrent() {
        return leftMasterMotor.getOutputCurrent();
    }

    public double getRightEncoderDistance() {
        return rightEncoder.getDistance();
    }

    public double getRightEncoderSpeed() {
        return rightEncoder.getRate();
    }

    public double getEncoderDistance() {
        return getRightEncoderDistance();
    }
}
