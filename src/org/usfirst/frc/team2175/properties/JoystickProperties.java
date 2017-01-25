package org.usfirst.frc.team2175.properties;

public class JoystickProperties extends BaseProperties {

    private int joystickLeftPort;
    private int joystickRightPort;
    private int gamepadPort;

    private double deadbandSize;

    private int shiftButtonNumber;
    private int gearIntakeInNumber;
    private int gearIntakeOutNumber;

    @Override
    protected String getPropertyFileName() {
        return "joysticks.properties";
    }

    @Override
    protected void populate() {
        joystickLeftPort = getIntPropertyValue("joystick.left.port");
        joystickRightPort = getIntPropertyValue("joystick.right.port");
        gamepadPort = getIntPropertyValue("joystick.gamepad.port");

        deadbandSize = getDoublePropertyValue("deadband.value");

        shiftButtonNumber = getIntPropertyValue("button.shift");
        gearIntakeInNumber = getIntPropertyValue("button.gearintake.in");
        gearIntakeOutNumber = getIntPropertyValue("button.gearintake.out");
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

    public double getDeadbandValue() {
        return deadbandSize;
    }

    public int getShiftButtonNumber() {
        return shiftButtonNumber;
    }

    public int getGearIntakeInNumber() {
        return gearIntakeInNumber;
    }

    public int getGearIntakeOutNumber() {
        return gearIntakeOutNumber;
    }
}
