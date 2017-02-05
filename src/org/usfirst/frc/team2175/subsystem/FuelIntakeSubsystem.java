package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class FuelIntakeSubsystem extends BaseSubsystem {
    private final CANTalon mainMotor;
    private DoubleSolenoid hopperSolenoid;
    private final double mainMotorDefaultInSpeed;
    private final double mainMotorDefaultOutSpeed;

    public FuelIntakeSubsystem() {
        WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        mainMotor = new CANTalon(
                wiringProperties.getFuelIntakeMainMotorDeviceNumber());
        hopperSolenoid =
                new DoubleSolenoid(wiringProperties.getHopperForwardNumber(),
                        wiringProperties.getHopperReverseNumber());
        mainMotorDefaultInSpeed = behaviorProperties.getFuelIntakeInSpeed();
        mainMotorDefaultOutSpeed = behaviorProperties.getFuelIntakeOutSpeed();
    }

    public double getMainMotorDefaultInSpeed() {
        return mainMotorDefaultInSpeed;
    }

    public double getMainMotorDefaultOutSpeed() {
        return mainMotorDefaultOutSpeed;
    }

    public void raiseHopper() {
        hopperSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void lowerHopper() {
        hopperSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void setMotorSpeed(double speed) {
        mainMotor.set(speed);
    }

}
