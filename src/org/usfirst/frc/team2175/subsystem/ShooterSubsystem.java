package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

public class ShooterSubsystem extends BaseSubsystem {
    private final CANTalon shooterMotor;
    private final CANTalon feederMotor;
    private final CANTalon agitatorMotor;
    private final double shooterSpeed;
    private final double feederSpeed;
    private final double agitatorSpeed;
    private final double shooterReverseSpeed;
    private final double feederReverseSpeed;
    private final double agitatorReverseSpeed;

    public ShooterSubsystem() {
        super();
        BehaviorProperties behaviorproperties =
                ServiceLocator.get(BehaviorProperties.class);
        WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        shooterMotor = new CANTalon(
                wiringProperties.getShooterShooterMotorDeviceNumber());
        shooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        shooterMotor.reverseSensor(true);
        feederMotor = new CANTalon(
                wiringProperties.getShooterFeederMotorDeviceNumber());
        agitatorMotor = new CANTalon(
                wiringProperties.getShooterAgitatorMotorDeviceNumber());
        shooterSpeed = behaviorproperties.getShooterSpeed();
        feederSpeed = behaviorproperties.getFeederSpeed();
        agitatorSpeed = behaviorproperties.getAgitatorSpeed();
        shooterReverseSpeed = behaviorproperties.getShooterInSpeed();
        feederReverseSpeed = behaviorproperties.getFeederInSpeed();
        agitatorReverseSpeed = behaviorproperties.getAgitatorInSpeeed();
    }

    public void setMotorSpeed() {
        shooterMotor.set(shooterSpeed);

    }

    public void setMotorSpeedFeeder() {
        feederMotor.set(feederSpeed);
    }

    public void setMotorSpeedAgitator() {
        agitatorMotor.set(agitatorSpeed);
    }

    public void setShooterMotorSpeedZero() {
        shooterMotor.set(0);
    }

    public void setFeederMotorSpeedZero() {
        feederMotor.set(0);

    }

    public void setAgitatorMotorSpeedZero() {
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