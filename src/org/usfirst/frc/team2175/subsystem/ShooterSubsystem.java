package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

public class ShooterSubsystem extends BaseSubsystem {

    private final CANTalon shooterMotor;
    private final CANTalon feederMotor;
    private final CANTalon feederMotorTwo;
    private final CANTalon shooterMotorTwo;
    private final CANTalon agitatorMotor;
    private final double shooterSpeed;
    private final double feederSpeed;
    private final double agitatorSpeed;
    private final double shooterReverseSpeed;
    private final double feederReverseSpeed;
    private final double agitatorReverseSpeed;

    public ShooterSubsystem() {
        final BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        final WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);

        shooterMotor = new CANTalon(
                wiringProperties.getShooterShooterMotorDeviceNumber());
        shooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        shooterMotor.reverseSensor(true);

        feederMotor = new CANTalon(
                wiringProperties.getShooterFeederMotorDeviceNumber());
        agitatorMotor = new CANTalon(
                wiringProperties.getShooterAgitatorMotorDeviceNumber());

        shooterMotorTwo = new CANTalon(
                wiringProperties.getShooterShooterMotorTwoDeviceNumber());
        feederMotorTwo = new CANTalon(
                wiringProperties.getShooterFeederMotorTwoDeviceNumber());
        shooterMotorTwo.changeControlMode(TalonControlMode.Follower);
        shooterMotorTwo.set(shooterMotor.getDeviceID());
        feederMotorTwo.changeControlMode(TalonControlMode.Follower);
        feederMotorTwo.set(feederMotor.getDeviceID());

        shooterSpeed = behaviorProperties.getShooterOutSpeed();
        feederSpeed = behaviorProperties.getFeederOutSpeed();
        agitatorSpeed = behaviorProperties.getAgitatorOutSpeed();
        shooterReverseSpeed = behaviorProperties.getShooterInSpeed();
        feederReverseSpeed = behaviorProperties.getFeederInSpeed();
        agitatorReverseSpeed = behaviorProperties.getAgitatorInSpeed();
    }

    // TODO: Rename this method. Calling it 'setShooterSpeed' makes me think I
    // can set it to any arbitrary speed, when in fact it just uses a default.
    // Maybe just 'setShooterDefaultSpeed' would be better.
    public void setShooterSpeed() {
        shooterMotor.set(shooterSpeed);
    }

    // TODO: Ditto the above comment.
    public void setFeederSpeed() {
        feederMotor.set(feederSpeed);
    }

    // TODO: Ditto the above two comments.
    public void setAgitatorSpeed() {
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

}
