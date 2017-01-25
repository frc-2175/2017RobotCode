package org.usfirst.frc.team2175.driverstation;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.JoystickProperties;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DriverStation {

    private Joystick leftJoystick;
    private Joystick rightJoystick;
    private Joystick gamepad;
    private JoystickButton shootButton;
    private JoystickButton feedButton;
    private JoystickButton shootInButton;
    private JoystickButton feederInButton;
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
        shootButton = new JoystickButton(
                location(joystickProperties.getRunShooterOutLocation()),
                joystickProperties.getRunShooterOutNumber());
        feedButton = new JoystickButton(
                location(joystickProperties.getRunFeederOutLocation()),
                joystickProperties.getRunFeederOutNumber());
        shiftButton = new JoystickButton(
                location(joystickProperties.getShiftButtonLocation()),
                joystickProperties.getShiftButtonNumber());
        feederInButton = new JoystickButton(
                location(joystickProperties.getRunFeederInLocation()),
                joystickProperties.getRunFeederInNumber());
        shootInButton = new JoystickButton(
                location(joystickProperties.getRunShooterInLocation()),
                joystickProperties.getRunShooterInNumber());
        gearIntakeInButton = new JoystickButton(
                location(joystickProperties.getGearIntakeInLocation()),
                joystickProperties.getGearIntakeInNumber());
        gearIntakeOutButton = new JoystickButton(
                location(joystickProperties.getGearIntakeOutLocation()),
                joystickProperties.getGearIntakeOutNumber());

        deadbandSize = joystickProperties.getDeadbandValue();
        deadbandCalculator = new DeadbandCalculator();
        ServiceLocator.register(this);
    }

    private Joystick location(String str) {
        Joystick joystickOfChoice = leftJoystick;
        switch (str) {
        case "left":
            joystickOfChoice = leftJoystick;
            break;
        case "right":
            joystickOfChoice = rightJoystick;
            break;
        case "gamepad":
            joystickOfChoice = gamepad;
            break;
        }
        return joystickOfChoice;

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

    public JoystickButton getRunShooterOut() {
        return shootButton;
    }

    public JoystickButton getRunFeederOut() {
        return feedButton;
    }

    public JoystickButton getFeederIn() {
        return feederInButton;
    }

    public JoystickButton getRunShooterIn() {
        return shootInButton;
    }
}
