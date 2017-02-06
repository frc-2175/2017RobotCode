package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Solenoid;

public class ShooterSubsystem extends BaseSubsystem {

    private final CANTalon shooterMotor;
    private final CANTalon shooterMotorTwo;
    private final double shooterSpeed;
    private final double shooterReverseSpeed;
    private final CANTalon feederMotorTwo;
    private final CANTalon feederMotor;

    private final CANTalon agitatorMotor;
    private final Solenoid leftShooterSolenoid;
    private final Solenoid rightShooterSolenoid;

    private final double feederSpeed;
    private final double agitatorSpeed;

    private final double feederReverseSpeed;
    private final double agitatorReverseSpeed;

    public ShooterSubsystem() {
        final BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        final WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);

        shooterMotor = new CANTalon(
                wiringProperties.getShooterShooterMotorDeviceNumber());
        // shooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        // shooterMotor.reverseSensor(true);
        // shooterMotor.changeControlMode(TalonControlMode.Speed);
        // shooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        // shooterMotor.setProfile(0);
        shooterMotorTwo = new CANTalon(
                wiringProperties.getShooterShooterMotorTwoDeviceNumber());
        // shooterMotorTwo.changeControlMode(TalonControlMode.Follower);
        // shooterMotorTwo.set(shooterMotor.getDeviceID());
        agitatorMotor = new CANTalon(
                wiringProperties.getShooterAgitatorMotorDeviceNumber());

        feederMotor = new CANTalon(
                wiringProperties.getShooterFeederMotorDeviceNumber());
        feederMotorTwo = new CANTalon(
                wiringProperties.getShooterFeederMotorTwoDeviceNumber());

        feederMotorTwo.changeControlMode(TalonControlMode.Follower);
        feederMotorTwo.set(feederMotor.getDeviceID());

        shooterSpeed = behaviorProperties.getShooterOutSpeed();
        feederSpeed = behaviorProperties.getFeederOutSpeed();
        agitatorSpeed = behaviorProperties.getAgitatorOutSpeed();
        shooterReverseSpeed = behaviorProperties.getShooterInSpeed();
        feederReverseSpeed = behaviorProperties.getFeederInSpeed();
        agitatorReverseSpeed = behaviorProperties.getAgitatorInSpeed();
        leftShooterSolenoid = new Solenoid(
                wiringProperties.getShooterActuatorLeftDeviceNumber());
        rightShooterSolenoid = new Solenoid(
                wiringProperties.getShooterActuatorRightDeviceNumber());

    }

    public void setShooterDefaultSpeed() {
        shooterMotor.set(shooterSpeed);
    }

    public void setFeederDefaultSpeed() {
        feederMotor.set(feederSpeed);
    }

    public void setAgitatorDefaultSpeed() {
        agitatorMotor.set(agitatorSpeed);
    }

    public void setShooterSpeedZero() {
        shooterMotor.set(0);
    }

    public void setFeederSpeedZero() {
        feederMotor.set(0);
    }

    public void setAgitatorSpeedZero() {
        agitatorMotor.set(0);
    }

    public void setShooterReverseSpeed() {
        shooterMotor.set(shooterReverseSpeed);
    }

    public void setFeederReverseSpeed() {
        shooterMotor.set(feederReverseSpeed);
    }

    public void setAgitatorReverseSpeed() {
        shooterMotor.set(agitatorReverseSpeed);
    }

    public double getShooterSpeed() {
        return shooterMotor.getSpeed();
    }

    public void actuateBothShootersOut() {
        leftShooterSolenoid.set(true);
        rightShooterSolenoid.set(true);
    }

    public void actuateBothShootersIn() {
        leftShooterSolenoid.set(false);
        rightShooterSolenoid.set(false);
    }
}
