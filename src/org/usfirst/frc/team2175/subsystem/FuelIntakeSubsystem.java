package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class FuelIntakeSubsystem extends BaseSubsystem {
    private final CANTalon mainMotor;
    private final DoubleSolenoid actuateSolenoidInAndOut;
    private final double mainMotorDefaultInSpeed;
    private final double mainMotorDefaultOutSpeed;

    public FuelIntakeSubsystem() {
        WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        mainMotor = new CANTalon(
                wiringProperties.getFuelIntakeMainMotorDeviceNumber());
        actuateSolenoidInAndOut = new DoubleSolenoid(
                wiringProperties.getFuelIntakeActuaterForwardNumber(),
                wiringProperties.getFuelIntakeActuaterReverseNumber());
        mainMotorDefaultInSpeed = behaviorProperties.getFuelIntakeInSpeed();
        mainMotorDefaultOutSpeed = behaviorProperties.getFuelIntakeOutSpeed();
    }

    public double getMainMotorDefaultInSpeed() {
        return mainMotorDefaultInSpeed;
    }

    public double getMainMotorDefaultOutSpeed() {
        return mainMotorDefaultOutSpeed;
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
