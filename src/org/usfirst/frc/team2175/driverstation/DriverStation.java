package org.usfirst.frc.team2175.driverstation;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.JoystickProperties;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DriverStation {

    private Joystick leftJoystick;
    private Joystick rightJoystick;
    private Joystick gamepad;

    private JoystickButton shiftButton;

    public DriverStation() {
        JoystickProperties joystickProperties =
                ServiceLocator.get(JoystickProperties.class);

        leftJoystick = new Joystick(joystickProperties.getJoystickLeftPort());
        rightJoystick = new Joystick(joystickProperties.getJoystickRightPort());
        gamepad = new Joystick(joystickProperties.getGamepadPort());

        shiftButton =
                new JoystickButton(leftJoystick,
                        joystickProperties.getShiftButtonNumber());

        ServiceLocator.register(this);
    }

    public double getMoveValue() {
        return leftJoystick.getY();
    }

    public double getTurnValue() {
        return rightJoystick.getX();
    }

    public JoystickButton getShiftButton() {
        return shiftButton;
    }

}
