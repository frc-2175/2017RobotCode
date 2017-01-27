package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class GearIntakeSubsystem extends BaseSubsystem {

    private CANTalon leftIntakeMotor;
    private CANTalon rightIntakeMotor;
    private DoubleSolenoid gearIntakeActuator;

    private double gearIntakeInSpeed;
    private double gearIntakeOutSpeed;

    public GearIntakeSubsystem() {
        WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        leftIntakeMotor =
                new CANTalon(wiringProperties.getLeftGearIntakeDeviceNumber());
        rightIntakeMotor =
                new CANTalon(wiringProperties.getRightGearIntakeDeviceNumber());
        gearIntakeActuator = new DoubleSolenoid(
                wiringProperties.getGearIntakeSolenoidForwardNumber(),
                wiringProperties.getGearIntakeSolenoidReverseNumber());

        gearIntakeInSpeed = behaviorProperties.getGearIntakeInSpeed();
        gearIntakeOutSpeed = behaviorProperties.getGearIntakeOutSpeed();
    }

    public void runIn() {
        leftIntakeMotor.set(gearIntakeInSpeed);
        rightIntakeMotor.set(-gearIntakeInSpeed);
    }

    public void runOut() {
        leftIntakeMotor.set(-gearIntakeOutSpeed);
        rightIntakeMotor.set(gearIntakeOutSpeed);
    }

    public void raiseIntake() {
        gearIntakeActuator.set(DoubleSolenoid.Value.kForward);
    }

    public void lowerIntake() {
        gearIntakeActuator.set(DoubleSolenoid.Value.kReverse);
    }

    public void stop() {
        leftIntakeMotor.set(0);
        rightIntakeMotor.set(0);
    }
}
