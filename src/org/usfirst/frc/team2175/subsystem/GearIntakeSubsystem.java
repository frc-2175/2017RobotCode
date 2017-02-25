package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.SolenoidWrapper;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

public class GearIntakeSubsystem extends BaseSubsystem {

    private CANTalon leftIntakeMotor;
    private CANTalon rightIntakeMotor;
    private SolenoidWrapper gearIntakeActuator;

    private double gearIntakeInSpeed;
    private double gearIntakeOutSpeed;

    public GearIntakeSubsystem() {
        final WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        final BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        leftIntakeMotor =
                motorFromInfo(wiringProperties.getLeftGearIntakeMotorInfo());
        rightIntakeMotor =
                motorFromInfo(wiringProperties.getRightGearIntakeMotorInfo());
        gearIntakeActuator = new SolenoidWrapper(
                wiringProperties.getGearIntakeSolenoidInfo());

        gearIntakeInSpeed = behaviorProperties.getGearIntakeInSpeed();
        gearIntakeOutSpeed = behaviorProperties.getGearIntakeOutSpeed();
    }

    public void runIn() {
        leftIntakeMotor.set(gearIntakeInSpeed);
        rightIntakeMotor.set(gearIntakeInSpeed);
    }

    public void runOut() {
        leftIntakeMotor.set(gearIntakeOutSpeed);
        rightIntakeMotor.set(gearIntakeOutSpeed);
    }

    public void raiseIntake() {
        gearIntakeActuator.set(false);
    }

    public void lowerIntake() {
        gearIntakeActuator.set(true);
    }

    public void stop() {
        leftIntakeMotor.set(0);
        rightIntakeMotor.set(0);
    }

    public void toggleActuation() {
        gearIntakeActuator.set(!gearIntakeActuator.get());
    }

    public double getLeftMotorCurrent() {
        return leftIntakeMotor.getOutputCurrent();
    }

}
