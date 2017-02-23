package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.WiringProperties.MotorInfo;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BaseSubsystem extends Subsystem {

    public BaseSubsystem() {
        ServiceLocator.register(this);
    }

    /**
     * Empty implementation.
     *
     * DO NOT override this in subsystems. Use {@link setDefaultCommand}
     * instead.
     */
    @Override
    protected void initDefaultCommand() {
    }

    @Override
    public void setDefaultCommand(final Command command) {
        super.setDefaultCommand(command);
    }

    protected CANTalon motorFromInfo(final MotorInfo motorInfo) {
        final CANTalon motor = new CANTalon(motorInfo.deviceNumber);
        motor.setInverted(motorInfo.isInverted);
        return motor;
    }

}
