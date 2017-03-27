package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.SolenoidWrapper;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;
import org.usfirst.frc.team2175.properties.WiringProperties.EncoderInfo;

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

    private final double TURN_CORRECTION;

    public DrivetrainSubsystem() {
        final WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        final BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
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

        setSlave(leftSlaveMotorOne, leftMasterMotor);
        setSlave(leftSlaveMotorTwo, leftMasterMotor);
        setSlave(rightSlaveMotorOne, rightMasterMotor);
        setSlave(rightSlaveMotorTwo, rightMasterMotor);

        driveShifters = new SolenoidWrapper(
                wiringProperties.getDriveShiftersSolenoidInfo());

        robotDrive = new RobotDrive(leftMasterMotor, rightMasterMotor);
        switchToPercentVbus();

        navXGyro = new AHRS(SPI.Port.kMXP);
        leftEncoder = encoderFromInfo(wiringProperties.getLeftEncoderInfo());
        rightEncoder = encoderFromInfo(wiringProperties.getRightEncoderInfo());
        TURN_CORRECTION = behaviorProperties.getDrivetrainGyroTurnCorrection();
    }

    protected void setSlave(final CANTalon slave, final CANTalon master) {
        slave.changeControlMode(CANTalon.TalonControlMode.Follower);
        slave.set(master.getDeviceID());
    }

    protected Encoder encoderFromInfo(final EncoderInfo encoderInfo) {
        final Encoder encoder = new Encoder(encoderInfo.sourceA,
                encoderInfo.sourceB, encoderInfo.isInverted);
        encoder.setDistancePerPulse(1);
        return encoder;
    }

    public void arcadeDrive(final double moveValue, final double rotateValue) {
        robotDrive.arcadeDrive(-moveValue, rotateValue);
    }

    public void straightArcadeDrive(final double moveValue) {
        if (Math.abs(getGyroAngle()) <= .25) {
            arcadeDrive(moveValue, 0);
        } else {
            arcadeDrive(moveValue, -(getGyroAngle() / TURN_CORRECTION));
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

    public double convertFromInchesToClicks(final double inches) {
        return inches * 54.518;
    }

    public void resetEncoders() {
        rightEncoder.reset();
        leftEncoder.reset();
    }

    public void resetSensors() {
        resetEncoders();
        resetGyro();
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
