package org.usfirst.frc.team2175.driverstation;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.JoystickProperties;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DriverStation {
    private Joystick leftJoystick;
    private Joystick rightJoystick;
    private Joystick gamepad;

    private double deadbandSize;
    private DeadbandCalculator deadbandCalculator;

    private JoystickButton climbButton;
    private JoystickButton feedInButton;
    private JoystickButton feedOutButton;
    private JoystickButton fuelIntakeActuateInButton;
    private JoystickButton fuelIntakeActuateOutButton;
    private JoystickButton fuelIntakeInButton;
    private JoystickButton fuelIntakeOutButton;
    private JoystickButton gearIntakeActuateOutButton;
    private JoystickButton gearIntakeInButton;
    private JoystickButton gearIntakeOutButton;
    private JoystickButton hopperButton;
    private JoystickButton shiftButton;
    private JoystickButton shootInButton;
    private JoystickButton shootOutButton;
    private JoystickButton cameraSwitchButton;

    public DriverStation() {
        JoystickProperties joystickProperties =
                ServiceLocator.get(JoystickProperties.class);
        leftJoystick = new Joystick(joystickProperties.getJoystickLeftPort());
        rightJoystick = new Joystick(joystickProperties.getJoystickRightPort());
        gamepad = new Joystick(joystickProperties.getGamepadPort());

        climbButton = buttonFromButtonInfo(joystickProperties.getClimberInfo());
        feedInButton =
                buttonFromButtonInfo(joystickProperties.getFeederInInfo());
        feedOutButton =
                buttonFromButtonInfo(joystickProperties.getFeederOutInfo());
        fuelIntakeActuateInButton = buttonFromButtonInfo(
                joystickProperties.getFuelIntakeActuateInInfo());
        fuelIntakeActuateOutButton = buttonFromButtonInfo(
                joystickProperties.getFuelIntakeActuateOutInfo());
        fuelIntakeInButton =
                buttonFromButtonInfo(joystickProperties.getFuelIntakeInInfo());
        fuelIntakeOutButton =
                buttonFromButtonInfo(joystickProperties.getFuelIntakeOutInfo());
        gearIntakeActuateOutButton = buttonFromButtonInfo(
                joystickProperties.getGearIntakeActuatorInfo());
        gearIntakeInButton =
                buttonFromButtonInfo(joystickProperties.getGearIntakeInInfo());
        gearIntakeOutButton =
                buttonFromButtonInfo(joystickProperties.getGearIntakeOutInfo());
        hopperButton = buttonFromButtonInfo(joystickProperties.getHopperInfo());
        shiftButton =
                buttonFromButtonInfo(joystickProperties.getShiftGearsInfo());
        shootInButton =
                buttonFromButtonInfo(joystickProperties.getShooterInInfo());
        shootOutButton =
                buttonFromButtonInfo(joystickProperties.getShooterOutInfo());
        cameraSwitchButton =
                buttonFromButtonInfo(joystickProperties.getCameraSwitchInfo());

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
        Joystick joystickOfChoice = gamepad;
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

    public double getClimberSpinSpeed() {
        return gamepad.getRawAxis(1) / 2;
    }

    public JoystickButton getFeederInButton() {
        return feedInButton;
    }

    public JoystickButton getFeederOutButton() {
        return feedOutButton;
    }

    public JoystickButton getFuelIntakeActuateInButton() {
        return fuelIntakeActuateInButton;
    }

    public JoystickButton getFuelIntakeActuateOutButton() {
        return fuelIntakeActuateOutButton;
    }

    public JoystickButton getFuelIntakeInButton() {
        return fuelIntakeInButton;
    }

    public JoystickButton getFuelIntakeOutButton() {
        return fuelIntakeOutButton;
    }

    public JoystickButton getGearIntakeActuateOutButton() {
        return gearIntakeActuateOutButton;
    }

    public JoystickButton getGearIntakeInButton() {
        return gearIntakeInButton;
    }

    public JoystickButton getGearIntakeOutButton() {
        return gearIntakeOutButton;
    }

    public JoystickButton getHopperButton() {
        return hopperButton;
    }

    public JoystickButton getShiftButton() {
        return shiftButton;
    }

    public JoystickButton getShooterInButton() {
        return shootInButton;
    }

    public JoystickButton getShooterOutButton() {
        return shootOutButton;
    }

    public JoystickButton getCameraSwitchButton() {
        return cameraSwitchButton;
    }
}
