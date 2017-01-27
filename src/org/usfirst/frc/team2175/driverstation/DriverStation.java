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
    private JoystickButton fuelIntakeInButton;
    private JoystickButton fuelIntakeOutButton;
    private JoystickButton fuelIntakeActuateInButton;
    private JoystickButton fuelIntakeActuateOutButton;
    private double deadbandSize;
    private JoystickButton shiftButton;
    private JoystickButton gearIntakeInButton;
    private JoystickButton gearIntakeOutButton;
    private JoystickButton gearIntakeActuateOutButton;
    private JoystickButton lowerHopperButton;
    private JoystickButton climberSpinButton;

    public DriverStation() {
        JoystickProperties joystickProperties =
                ServiceLocator.get(JoystickProperties.class);
        leftJoystick = new Joystick(joystickProperties.getJoystickLeftPort());
        rightJoystick = new Joystick(joystickProperties.getJoystickRightPort());
        gamepad = new Joystick(joystickProperties.getGamepadPort());

        shiftButton =
                buttonFromButtonInfo(joystickProperties.getShiftButtonInfo());
        shootOutButton =
                buttonFromButtonInfo(joystickProperties.getRunShooterOutInfo());
        feedOutButton =
                buttonFromButtonInfo(joystickProperties.getRunFeederOutInfo());
        shootInButton =
                buttonFromButtonInfo(joystickProperties.getRunShooterInInfo());
        feedInButton =
                buttonFromButtonInfo(joystickProperties.getRunFeederInInfo());
        gearIntakeInButton =
                buttonFromButtonInfo(joystickProperties.getGearIntakeInInfo());
        gearIntakeOutButton =
                buttonFromButtonInfo(joystickProperties.getGearIntakeOutInfo());
        gearIntakeActuateOutButton = buttonFromButtonInfo(
                joystickProperties.getGearIntakeActuatorInfo());
        lowerHopperButton =
                buttonFromButtonInfo(joystickProperties.getHopperInfo());
        fuelIntakeInButton =
                buttonFromButtonInfo(joystickProperties.getFuelIntakeInInfo());
        fuelIntakeOutButton =
                buttonFromButtonInfo(joystickProperties.getFuelIntakeOutInfo());
        fuelIntakeActuateInButton = buttonFromButtonInfo(
                joystickProperties.getFuelIntakeActuateInInfo());
        fuelIntakeActuateOutButton = buttonFromButtonInfo(
                joystickProperties.getFuelIntakeActuateOutInfo());
        climberSpinButton =
                buttonFromButtonInfo(joystickProperties.getClimberInfo());

        deadbandSize = joystickProperties.getDeadbandValue();
        deadbandCalculator = new DeadbandCalculator();
        ServiceLocator.register(this);
    }

    protected JoystickButton buttonFromButtonInfo(
            JoystickProperties.ButtonInfo buttonInfo) {
        return new JoystickButton(joystickForName(buttonInfo.joystickName),
                buttonInfo.buttonNumber);
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

    public JoystickButton getFuelIntakeInButton() {
        return fuelIntakeInButton;
    }

    public JoystickButton getFuelIntakeOutButton() {
        return fuelIntakeOutButton;
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

    public JoystickButton getRaiseHopper() {
        return lowerHopperButton;
    }

    public JoystickButton getClimberSpinButton() {
        return climberSpinButton;
    }

    public JoystickButton getFuelIntakeActuateInButton() {
        return fuelIntakeActuateInButton;
    }

    public JoystickButton getFuelIntakeActuateOutButton() {
        return fuelIntakeActuateOutButton;
    }

    public JoystickButton getGearIntakeActuateOutButton() {
        return gearIntakeActuateOutButton;
    }
}
