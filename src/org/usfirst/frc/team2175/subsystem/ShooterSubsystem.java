package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.SolenoidWrapper;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

public class ShooterSubsystem extends BaseSubsystem {

    private final CANTalon shooterMotor;
    private final SolenoidWrapper shooterSolenoid;
    private final double shooterSpeed;
    private final double shooterReverseSpeed;

    private final CANTalon feederMotor;
    private final double feederSpeed;
    private final double feederReverseSpeed;

    private final CANTalon agitatorMotor;
    private final CANTalon augerMotor;
    private final double augerSpeed;
    private final double augerReverseSpeed;
    private final double agitatorSpeed;
    private final double agitatorReverseSpeed;

    public ShooterSubsystem() {
        final BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        final WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);

        shooterMotor = motorFromInfo(wiringProperties.getShooterMotorInfo());

        feederMotor = motorFromInfo(wiringProperties.getFeederMotorInfo());
        agitatorMotor =
                motorFromInfo(wiringProperties.getShooterAgitatorMotorInfo());
        augerMotor = motorFromInfo(wiringProperties.getAugerMotorInfo());
        augerSpeed = behaviorProperties.getAugerSpeed();
        augerReverseSpeed = behaviorProperties.getAugerReverseSpeed();
        switchToPercentVbus();
        shooterSpeed = behaviorProperties.getLeftShooterSpeed();

        feederSpeed = behaviorProperties.getLeftFeederSpeed();
        shooterReverseSpeed = behaviorProperties.getShooterReverseSpeed();
        feederReverseSpeed = behaviorProperties.getFeederReverseSpeed();

        agitatorSpeed = -behaviorProperties.getAgitatorSpeed();
        agitatorReverseSpeed = -behaviorProperties.getAgitatorReverseSpeed();

        shooterSolenoid = new SolenoidWrapper(
                wiringProperties.getShooterActuatorSolenoidInfo());
    }

    public void setShooterDefaultSpeed() {
        shooterMotor.set(shooterSpeed);
    }

    public void setShooterDefaultSetpoint() {
        shooterMotor.set(shooterSpeed);
    }

    public void setFeederDefaultSpeed() {
        feederMotor.set(feederSpeed);
    }

    public void setAgitatorDefaultSpeed() {
        agitatorMotor.set(agitatorSpeed);
    }

    public void setAgitatorReverseSpeed() {
        agitatorMotor.set(agitatorReverseSpeed);
    }

    public void setAugerDefaultSpeed() {
        augerMotor.set(augerSpeed);
    }

    public void setAugerReverseSpeed() {
        augerMotor.set(augerReverseSpeed);
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
        feederMotor.set(feederReverseSpeed);
    }

    public double getShooterSpeed() {
        return shooterMotor.getSpeed();
    }

    public void actuateBothShootersOut() {
        shooterSolenoid.set(false);
    }

    public void actuateBothShootersIn() {
        shooterSolenoid.set(true);
    }

    public void switchToPIDMode() {
        shooterMotor.changeControlMode(TalonControlMode.Speed);
        shooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        shooterMotor.reverseSensor(true);
        shooterMotor.setProfile(0);
    }

    public void switchToPercentVbus() {
        shooterMotor.changeControlMode(TalonControlMode.PercentVbus);
    }

    public boolean isShooterRunning() {
        return shooterMotor.get() != 0;
    }

    public void setAugerSpeedZero() {
        augerMotor.set(0);
    }
}
