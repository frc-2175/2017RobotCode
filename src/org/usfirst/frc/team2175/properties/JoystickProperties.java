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
        populateButtonInfo();
    }

    public void populateButtonInfo() {
        runFeederOutInfo = new ButtonInfo(getJoystickName("button.feeder.out"),
                getButtonNumber("button.feeder.out"));
        runShooterOutInfo =
                new ButtonInfo(getJoystickName("button.shooter.out"),
                        getButtonNumber("button.shooter.out"));
        shiftButtonInfo = new ButtonInfo(getJoystickName("button.shift"),
                getButtonNumber("button.shift"));
        gearIntakeInInfo =
                new ButtonInfo(getJoystickName("button.gearintake.in"),
                        getButtonNumber("button.gearintake.in"));
        gearIntakeOutInfo =
                new ButtonInfo(getJoystickName("button.gearintake.out"),
                        getButtonNumber("button.gearintake.out"));
        runFeederInInfo = new ButtonInfo(getJoystickName("button.shooter.in"),
                getButtonNumber("button.shooter.in"));
        runShooterInInfo = new ButtonInfo(getJoystickName("button.feeder.in"),
                getButtonNumber("button.feeder.in"));
        // System.out.println(myButton.joystickName);
        // System.out.println(myButton.buttonNumber);
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
