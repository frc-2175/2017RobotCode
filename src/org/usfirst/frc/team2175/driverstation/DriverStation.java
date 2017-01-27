package org.usfirst.frc.team2175.driverstation;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.JoystickProperties;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DriverStation {
    private Joystick leftJoystick;
    private Joystick rightJoystick;
    private Joystick gamepad;
    private JoystickButton shootOutButton;
    private JoystickButton feedOutButton;
    private JoystickButton shootInButton;
    private JoystickButton feedInButton;
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

        JoystickProperties.ButtonInfo shiftButtonInfo =
                joystickProperties.getShiftButtonInfo();
        JoystickProperties.ButtonInfo runShooterOutInfo =
                joystickProperties.getRunShooterOutInfo();
        JoystickProperties.ButtonInfo runFeederOutInfo =
                joystickProperties.getRunFeederOutInfo();
        JoystickProperties.ButtonInfo runShooterInInfo =
                joystickProperties.getRunShooterInInfo();
        JoystickProperties.ButtonInfo runFeederInInfo =
                joystickProperties.getRunFeederInInfo();
        JoystickProperties.ButtonInfo gearIntakeInInfo =
                joystickProperties.getGearIntakeInInfo();
        JoystickProperties.ButtonInfo gearIntakeOutInfo =
                joystickProperties.getGearIntakeOutInfo();

        shiftButton = new JoystickButton(
                joystickForName(shiftButtonInfo.joystickName),
                shiftButtonInfo.buttonNumber);
        shootOutButton = new JoystickButton(
                joystickForName(runShooterOutInfo.joystickName),
                runShooterOutInfo.buttonNumber);
        feedOutButton = new JoystickButton(
                joystickForName(runFeederOutInfo.joystickName),
                runFeederOutInfo.buttonNumber);
        shootInButton = new JoystickButton(
                joystickForName(runShooterInInfo.joystickName),
                runShooterInInfo.buttonNumber);
        feedInButton = new JoystickButton(
                joystickForName(runFeederInInfo.joystickName),
                runFeederInInfo.buttonNumber);
        gearIntakeInButton = new JoystickButton(
                joystickForName(gearIntakeInInfo.joystickName),
                gearIntakeInInfo.buttonNumber);
        gearIntakeOutButton = new JoystickButton(
                joystickForName(gearIntakeOutInfo.joystickName),
                gearIntakeOutInfo.buttonNumber);

        deadbandSize = joystickProperties.getDeadbandValue();
        deadbandCalculator = new DeadbandCalculator();
        ServiceLocator.register(this);
    }

    private Joystick joystickForName(String name) {
        Joystick joystickOfChoice = leftJoystick;
        switch (name) {
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
        return shootOutButton;
    }

    public JoystickButton getRunFeederOut() {
        return feedOutButton;
    }

    public JoystickButton getFeederIn() {
        return feedInButton;
    }

    public JoystickButton getRunShooterIn() {
        return shootInButton;
    }
}
