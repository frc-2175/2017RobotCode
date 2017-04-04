package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.SolenoidWrapper;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

public class GearIntakeSubsystem extends BaseSubsystem {

    private CANTalon intakeMotor;
    private SolenoidWrapper gearIntakeActuator;

    private double gearIntakeInSpeed;
    private double gearIntakeOutSpeed;

    public GearIntakeSubsystem() {
        final WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        final BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        intakeMotor = motorFromInfo(wiringProperties.getGearIntakeMotorInfo());
        gearIntakeActuator = new SolenoidWrapper(
                wiringProperties.getGearIntakeSolenoidInfo());

        gearIntakeInSpeed = behaviorProperties.getGearIntakeInSpeed();
        gearIntakeOutSpeed = behaviorProperties.getGearIntakeOutSpeed();
    }

    public void runIn() {
        intakeMotor.set(-gearIntakeInSpeed);
    }

    public void runOut() {
        intakeMotor.set(gearIntakeOutSpeed);
    }

    public void raiseIntake() {
        gearIntakeActuator.set(false);
    }

    public void lowerIntake() {
        gearIntakeActuator.set(true);
    }

    public void stop() {
        intakeMotor.set(0);
    }

    public void toggleActuation() {
        gearIntakeActuator.set(!gearIntakeActuator.get());
    }

    public void lower() {
        gearIntakeActuator.set(true);
    }

    public void raise() {
        gearIntakeActuator.set(false);
    }

    public double getMotorCurrent() {
        return intakeMotor.getOutputCurrent();
    }

    public boolean getIsGearIntakeOut() {
        return gearIntakeActuator.get();
    }
}
