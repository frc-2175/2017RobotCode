package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.SolenoidWrapper;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

public class FuelIntakeSubsystem extends BaseSubsystem {

    // private final CANTalon mainMotor;
    private SolenoidWrapper hopperSolenoid;
    private final double mainMotorDefaultInSpeed;
    private final double mainMotorDefaultOutSpeed;

    public FuelIntakeSubsystem() {
        final WiringProperties wiringProperties =
                ServiceLocator.get(WiringProperties.class);
        final BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        // mainMotor =
        // motorFromInfo(wiringProperties.getFuelIntakeMainMotorInfo());
        hopperSolenoid =
                new SolenoidWrapper(wiringProperties.getHopperSolenoidInfo());
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
        hopperSolenoid.set(true);
    }

    public void lowerHopper() {
        hopperSolenoid.set(false);
    }

    public void setMotorSpeed(final double speed) {
        // mainMotor.set(speed);
    }

    public boolean isHopperUp() {
        return hopperSolenoid.get();
    }

}
