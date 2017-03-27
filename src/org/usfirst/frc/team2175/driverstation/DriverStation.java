package org.usfirst.frc.team2175.driverstation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.logging.Logger;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.JoystickProperties;
import org.usfirst.frc.team2175.properties.JoystickProperties.ButtonInfo;
import org.usfirst.frc.team2175.properties.Properties;
import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.subsystem.ClimberSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DriverStation {
    private final static Logger log = Logger.getLogger(Robot.class.getName());

    private HashMap<String, JoystickButton> buttonMap;

    private Joystick leftJoystick;
    private Joystick rightJoystick;
    private Joystick weaponsGamepad;

    private double deadbandSize;
    private DeadbandCalculator deadbandCalculator;
    private JoystickProperties joystickProperties;

    private POVTrigger shooterInPOV;
    private POVTrigger fuelOutPOV;

    private double maxClimberSpeed;

    public DriverStation() {
        joystickProperties = ServiceLocator.get(JoystickProperties.class);
        Properties props = ServiceLocator.get(Properties.class);
        buttonMap = new HashMap<>();

        leftJoystick = new Joystick(joystickProperties.getLeftJoystickPort());
        rightJoystick = new Joystick(joystickProperties.getRightJoytickPort());
        weaponsGamepad =
                new Joystick(joystickProperties.getWeaponsGamepadPort());

        for (Field field : props.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                createButtonFromInfo(field.get(props));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        shooterInPOV = new POVTrigger(weaponsGamepad,
                joystickProperties.getShooterInPOV());
        fuelOutPOV = new POVTrigger(weaponsGamepad,
                joystickProperties.getFuelIntakeOutPOV());

        deadbandSize = joystickProperties.getDeadbandValue();
        deadbandCalculator = new DeadbandCalculator();

        maxClimberSpeed =
                ServiceLocator.get(ClimberSubsystem.class).getMaxClimberSpeed();
        ServiceLocator.register(this);
    }

    protected void createButtonFromInfo(Object object) {
        String s = String.valueOf(object);
        ButtonInfo info = joystickProperties.getButtonInfo().get(s);
        JoystickButton button = new JoystickButton(
                joystickForName(info.joystickName), info.buttonNumber);
        buttonMap.put(s, button);
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
            joystickOfChoice = weaponsGamepad;
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

    public HashMap<String, JoystickButton> getButtonMap() {
        return buttonMap;
    }

    public double getMoveValue() {
        return -calcOutputFromCalculator(leftJoystick.getY());
    }

    public double getTurnValue() {
        return calcOutputFromCalculator(rightJoystick.getX());
    }

    protected double calcOutputFromCalculator(double input) {
        return deadbandCalculator.calcDeadbandedOutput(squareRootInput(input),
                deadbandSize);
    }

    protected static double squareRootInput(final double input) {
        final double sign = Math.signum(input);
        return sign * Math.sqrt(Math.abs(input));
    }

    public double getClimberSpinSpeed() {
        return -(weaponsGamepad.getRawAxis(1) * maxClimberSpeed);
    }

    public POVTrigger getFuelOutPOV() {
        return fuelOutPOV;
    }

    public POVTrigger getShooterInPOV() {
        return shooterInPOV;
    }
}
