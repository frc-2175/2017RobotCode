package org.usfirst.frc.team2175.driverstation;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.JoystickProperties;
import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.subsystem.ClimberSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DriverStation {
    private final static Logger log = Logger.getLogger(Robot.class.getName());

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
    private JoystickButton gearIntakeOutAndSpinButton;

    private double maxClimberSpeed;

    public DriverStation() {
        final JoystickProperties joystickProperties =
                ServiceLocator.get(JoystickProperties.class);
        final ClimberSubsystem climberSubsystem =
                ServiceLocator.get(ClimberSubsystem.class);

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
        gearIntakeOutAndSpinButton = buttonFromButtonInfo(
                joystickProperties.getGearIntakeOutAndSpinInfo());

        deadbandSize = joystickProperties.getDeadbandValue();
        deadbandCalculator = new DeadbandCalculator();

        maxClimberSpeed = climberSubsystem.getMaxClimberSpeed();

        ServiceLocator.register(this);
    }

    protected JoystickButton buttonFromButtonInfo(
            final JoystickProperties.ButtonInfo buttonInfo) {
        return new JoystickButton(joystickForName(buttonInfo.joystickName),
                buttonInfo.buttonNumber);
    }

    private Joystick joystickForName(final String name) {
        Joystick joystickOfChoice = null;
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
        default:
            final String msg =
                    "Joystick name parameter is not valid. Joystick name is="
                            + name;
            log.severe(msg);
            throw new IllegalArgumentException(msg);
        }
        return joystickOfChoice;
    }

    public double getMoveValue() {
        final double input = leftJoystick.getY();
        final double deadbandedOutput =
                deadbandCalculator.calcDeadbandedOutput(input, deadbandSize);
        return deadbandedOutput;
    }

    public double getTurnValue() {
        final double input = rightJoystick.getX();
        final double deadbandedOutput =
                deadbandCalculator.calcDeadbandedOutput(input, deadbandSize);
        return deadbandedOutput;
    }

    public double getClimberSpinSpeed() {
        return gamepad.getRawAxis(1) * maxClimberSpeed;
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

    public JoystickButton getClimbButton() {
        return climbButton;
    }

    public boolean getShouldExecuteFuelIntakeFailsafe() {
        return gamepad.getPOV() == 90;
    }

    public boolean getShouldExecuteShooterFailsafe() {
        return gamepad.getPOV() == 270;
    }

    public JoystickButton getGearIntakeOutAndSpinButton() {
        return gearIntakeOutAndSpinButton;
    }
}
