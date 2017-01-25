package org.usfirst.frc.team2175.driverstation;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.JoystickProperties;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DriverStation {

    private Joystick leftJoystick;
    private Joystick rightJoystick;
    private Joystick gamepad;

    private DeadbandCalculator deadbandCalculator;
    private double deadbandSize;

    private JoystickButton shiftButton;
    private JoystickButton gearIntakeInButton;
    private JoystickButton gearIntakeOutButton;

    public DriverStation() {
        JoystickProperties joystickProperties =
                ServiceLocator.get(JoystickProperties.class);

        leftJoystick = new Joystick(joystickProperties.getJoystickLeftPort());
        rightJoystick = new Joystick(joystickProperties.getJoystickRightPort());
        gamepad = new Joystick(joystickProperties.getGamepadPort());

        shiftButton = new JoystickButton(leftJoystick,
                joystickProperties.getShiftButtonNumber());

        gearIntakeInButton = new JoystickButton(gamepad,
                joystickProperties.getGearIntakeInNumber());
        gearIntakeOutButton = new JoystickButton(gamepad,
                joystickProperties.getGearIntakeOutNumber());

        deadbandSize = joystickProperties.getDeadbandValue();
        deadbandCalculator = new DeadbandCalculator();
        ServiceLocator.register(this);
    }

    public double getMoveValue() {
        double input = leftJoystick.getY();
        double deadbandedOutput =
                deadbandCalculator.calcDeadbandedOutput(input, deadbandSize);
        return deadbandedOutput;
    }

    public double getTurnValue() {
        double input = rightJoystick.getX();
        double deadbandedOutput =
                deadbandCalculator.calcDeadbandedOutput(input, deadbandSize);
        return deadbandedOutput;
    }

    public JoystickButton getShiftButton() {
        return shiftButton;
    }

    public JoystickButton getGearIntakeInButton() {
        return gearIntakeInButton;
    }

    public JoystickButton getGearIntakeOutButton() {
        return gearIntakeOutButton;
    }

}
