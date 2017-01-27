package org.usfirst.frc.team2175.properties;

public class JoystickProperties extends BaseProperties {
    private int joystickLeftPort;
    private int joystickRightPort;
    private int gamepadPort;
    private double deadbandSize;
    private ButtonInfo shiftButtonInfo;
    private ButtonInfo runShooterOutInfo;
    private ButtonInfo runFeederOutInfo;
    private ButtonInfo runShooterInInfo;
    private ButtonInfo runFeederInInfo;
    private ButtonInfo gearIntakeInInfo;
    private ButtonInfo gearIntakeOutInfo;

    @Override
    protected String getPropertyFileName() {
        return "joysticks.properties";
    }

    public static class ButtonInfo {
        public final String joystickName;
        public final int buttonNumber;

        private ButtonInfo(String joystickName, int buttonNumber) {
            this.joystickName = joystickName;
            this.buttonNumber = buttonNumber;
        }
    }

    @Override
    protected void populate() {
        joystickLeftPort = getIntPropertyValue("joystick.left.port");
        joystickRightPort = getIntPropertyValue("joystick.right.port");
        gamepadPort = getIntPropertyValue("joystick.gamepad.port");
        deadbandSize = getDoublePropertyValue("deadband.value");

        runFeederOutInfo = buttonInfoFromPropertyValue("button.feeder.out");

        runShooterOutInfo = buttonInfoFromPropertyValue("button.shooter.out");
        shiftButtonInfo = buttonInfoFromPropertyValue("button.shift");
        gearIntakeInInfo = buttonInfoFromPropertyValue("button.gearintake.in");
        gearIntakeOutInfo =
                buttonInfoFromPropertyValue("button.gearintake.out");
        runFeederInInfo = buttonInfoFromPropertyValue("button.feeder.in");
        runShooterInInfo = buttonInfoFromPropertyValue("button.shooter.in");
    }

    protected ButtonInfo buttonInfoFromPropertyValue(String propertyValue) {
        return new ButtonInfo(getJoystickName(propertyValue),
                getButtonNumber(propertyValue));
    }

    private String getJoystickName(String propertyName) {
        String joystickName = getStringArrayPropertyValue(propertyName)[0];
        return joystickName;
    }

    private int getButtonNumber(String propertyName) {
        int buttonNumber =
                Integer.parseInt(getStringArrayPropertyValue(propertyName)[1]);
        return buttonNumber;
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

    public String getJoystickName() {
        return null;

    }

    public ButtonInfo getShiftButtonInfo() {
        return shiftButtonInfo;
    }

    public ButtonInfo getRunShooterOutInfo() {
        return runShooterOutInfo;
    }

    public ButtonInfo getRunFeederOutInfo() {
        return runFeederOutInfo;
    }

    public ButtonInfo getRunShooterInInfo() {
        return runShooterInInfo;
    }

    public ButtonInfo getRunFeederInInfo() {
        return runFeederInInfo;
    }

    public ButtonInfo getGearIntakeInInfo() {
        return gearIntakeInInfo;
    }

    public ButtonInfo getGearIntakeOutInfo() {
        return gearIntakeOutInfo;
    }
}
