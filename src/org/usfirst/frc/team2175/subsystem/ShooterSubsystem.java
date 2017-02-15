package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ReversibleTalon;
import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Solenoid;

public class ShooterSubsystem extends BaseSubsystem {

    private final CANTalon leftShooterMotor;
    private final CANTalon rightShooterMotor;
    private final double leftShooterSpeed;
    private final double rightShooterSpeed;
    private final double leftShooterReverseSpeed;
    private final double rightShooterReverseSpeed;

    private final CANTalon rightFeederMotor;
    private final CANTalon leftFeederMotor;
    private final double leftFeederSpeed;
    private final double rightFeederSpeed;
    private final double leftFeederReverseSpeed;
    private final double rightFeederReverseSpeed;

    private final CANTalon agitatorMotor;
    private final Solenoid leftShooterSolenoid;
    private final Solenoid rightShooterSolenoid;
    private final double agitatorSpeed;

    public ShooterSubsystem() {
        final BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        final WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);

        // TODO: Provide a way of configuring both our shooter motor controllers
        // the same way without duplicate code.

        leftShooterMotor = new ReversibleTalon(
                wiringProperties.getLeftShooterMotorDeviceNumber());
        rightShooterMotor = new ReversibleTalon(
                wiringProperties.getRightShooterMotorDeviceNumber());

        leftFeederMotor = new ReversibleTalon(
                wiringProperties.getLeftFeederMotorDeviceNumber());
        rightFeederMotor = new ReversibleTalon(
                wiringProperties.getRightFeederMotorDeviceNumber());

        agitatorMotor = new CANTalon(
                wiringProperties.getShooterAgitatorMotorDeviceNumber());

        switchToPercentVbus();
        leftShooterSpeed = behaviorProperties.getShooterSpeed();
        leftShooterMotor.reverseOutput(true);
        rightShooterSpeed = behaviorProperties.getShooterSpeed();
        leftFeederSpeed = behaviorProperties.getFeederSpeed();
        rightFeederSpeed = behaviorProperties.getFeederSpeed();
        rightFeederMotor.reverseOutput(true);

        leftShooterReverseSpeed = behaviorProperties.getShooterReverseSpeed();
        rightShooterReverseSpeed = behaviorProperties.getShooterReverseSpeed();
        leftFeederReverseSpeed = behaviorProperties.getFeederReverseSpeed();
        rightFeederReverseSpeed = behaviorProperties.getFeederReverseSpeed();

        agitatorSpeed = behaviorProperties.getAgitatorSpeed();

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
        leftShooterMotor.set(leftShooterReverseSpeed);
        rightShooterMotor.set(rightShooterReverseSpeed);
    }

    public void setFeederReverseSpeed() {
        leftFeederMotor.set(leftFeederReverseSpeed);
        rightFeederMotor.set(rightFeederReverseSpeed);
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

    public void switchToPIDMode() {
        leftShooterMotor.changeControlMode(TalonControlMode.Speed);
        leftShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        leftShooterMotor.reverseSensor(true);
        leftShooterMotor.setProfile(0);
        rightShooterMotor.changeControlMode(TalonControlMode.Speed);
        rightShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        rightShooterMotor.reverseSensor(true);
        rightShooterMotor.setProfile(0);
    }

    public void switchToPercentVbus() {
        leftShooterMotor.changeControlMode(TalonControlMode.PercentVbus);
        rightShooterMotor.changeControlMode(TalonControlMode.PercentVbus);
    }

    public boolean isShooterRunning() {
        // If we need to run one shooter and not the other, we need to change
        // this to check the shooter being used
        return leftShooterMotor.get() != 0;
    }
}
