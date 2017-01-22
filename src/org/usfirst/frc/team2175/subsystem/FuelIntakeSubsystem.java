package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class FuelIntakeSubsystem extends BaseSubsystem {
    private final CANTalon mainMotor;
    private final DoubleSolenoid actuateSolenoidInAndOut;

    public FuelIntakeSubsystem() {
        WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        mainMotor = new CANTalon(
                wiringProperties.getBallIntakeMainMotorDeviceNumber());
        actuateSolenoidInAndOut = new DoubleSolenoid(
                wiringProperties.getBallIntakeActuaterForwardNumber(),
                wiringProperties.getBallIntakeActuaterReverseNumber());
    }

    public void actuateOut() {
        actuateSolenoidInAndOut.set(DoubleSolenoid.Value.kForward);
    }

    public void actuateIn() {
        actuateSolenoidInAndOut.set(DoubleSolenoid.Value.kReverse);
    }

    public void setMotorSpeed(double speed) {
        mainMotor.set(speed);
    }

}
