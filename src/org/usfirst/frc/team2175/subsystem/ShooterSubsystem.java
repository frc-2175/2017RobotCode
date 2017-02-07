package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;

public class ShooterSubsystem extends BaseSubsystem {

    private final CANTalon leftShooterMotor;
    private final CANTalon rightShooterMotor;
    private final double leftShooterSpeed;
    private final double rightShooterSpeed;
    private final double shooterReverseSpeed;
    private final CANTalon rightFeederMotor;
    private final CANTalon leftFeederMotor;

    private final CANTalon agitatorMotor;
    private final Solenoid leftShooterSolenoid;
    private final Solenoid rightShooterSolenoid;

    private final double leftFeederSpeed;
    private final double rightFeederSpeed;
    private final double agitatorSpeed;

    private final double feederReverseSpeed;
    private final double agitatorReverseSpeed;

    public ShooterSubsystem() {
        final BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        final WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);

        leftShooterMotor = new CANTalon(
                wiringProperties.getLeftShooterMotorDeviceNumber());
        // shooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        // shooterMotor.reverseSensor(true);
        // shooterMotor.changeControlMode(TalonControlMode.Speed);
        // shooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        // shooterMotor.setProfile(0);
        rightShooterMotor = new CANTalon(
                wiringProperties.getRightShooterMotorDeviceNumber());
        agitatorMotor = new CANTalon(
                wiringProperties.getShooterAgitatorMotorDeviceNumber());

        leftFeederMotor =
                new CANTalon(wiringProperties.getLeftFeederMotorDeviceNumber());
        rightFeederMotor = new CANTalon(
                wiringProperties.getRightFeederMotorDeviceNumber());

        // rightFeederMotor.changeControlMode(TalonControlMode.Follower);
        // rightFeederMotor.set(leftFeederMotor.getDeviceID());

        leftShooterSpeed = behaviorProperties.getLeftShooterOutSpeed();
        rightShooterSpeed = behaviorProperties.getRightShooterOutSpeed();
        leftFeederSpeed = behaviorProperties.getLeftFeederOutSpeed();
        rightFeederSpeed = behaviorProperties.getRightFeederOutSpeed();
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
        leftShooterMotor.set(leftShooterSpeed);
        rightShooterMotor.set(rightShooterSpeed);
    }

    public void setFeederDefaultSpeed() {
        leftFeederMotor.set(leftFeederSpeed);
        rightFeederMotor.set(rightFeederSpeed);
    }

    public void setAgitatorDefaultSpeed() {
        agitatorMotor.set(agitatorSpeed);
    }

    public void setShooterSpeedZero() {
        leftShooterMotor.set(0);
        rightShooterMotor.set(0);
    }

    public void setFeederSpeedZero() {
        leftFeederMotor.set(0);
        rightFeederMotor.set(0);
    }

    public void setAgitatorSpeedZero() {
        agitatorMotor.set(0);
    }

    public void setShooterReverseSpeed() {
        leftShooterMotor.set(shooterReverseSpeed);
    }

    public void setFeederReverseSpeed() {
        leftShooterMotor.set(feederReverseSpeed);
    }

    public void setAgitatorReverseSpeed() {
        leftShooterMotor.set(agitatorReverseSpeed);
    }

    public double getShooterSpeed() {
        return leftShooterMotor.getSpeed();
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
