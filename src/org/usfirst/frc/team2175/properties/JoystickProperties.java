package org.usfirst.frc.team2175.properties;

public class JoystickProperties extends BaseProperties {

    private int joystickLeftPort;
    private int joystickRightPort;
    private int gamepadPort;

    @Override
    protected String getPropertyFileName() {
        return "joysticks.properties";
    }

    @Override
    protected void populate() {
        joystickLeftPort = getIntPropertyValue("joystick.left.port");
        joystickRightPort = getIntPropertyValue("joystick.right.port");
        gamepadPort = getIntPropertyValue("joystick.gamepad.port");
    }

    public int getJoystickLeftPort() {
        return joystickLeftPort;
    }

    public int getJoystickRightPort() {
        return joystickRightPort;
    }

    public int getGamepadPort() {
        return gamepadPort;
    }

}
