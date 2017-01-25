package org.usfirst.frc.team2175.properties;

public class JoystickProperties extends BaseProperties {

    private int joystickLeftPort;
    private int joystickRightPort;
    private int gamepadPort;

    private double deadbandSize;

    private String[] shiftButtonInfo;
    private String[] runShooterOutInfo;
    private String[] runFeederOutInfo;
    private String[] runShooterInInfo;
    private String[] runFeederInInfo;
    private String[] gearIntakeInInfo;
    private String[] gearIntakeOutInfo;

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

        runFeederOutInfo = getInfo("button.feeder.out");
        runShooterOutInfo = getInfo("button.shooter.out");
        shiftButtonInfo = getInfo("button.shift");
        gearIntakeInInfo = getInfo("button.gearintake.in");
        gearIntakeOutInfo = getInfo("button.gearintake.out");
        runShooterInInfo = getInfo("button.shooter.in");
        runFeederInInfo = getInfo("button.feeder.in");
    }

    public String[] getInfo(String str) {
        String[] data = getStringPropertyValue(str).split(",");
        data[1] = data[1].trim();
        return data;
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
        return Integer.parseInt(shiftButtonInfo[1]);
    }

    public int getGearIntakeInNumber() {
        return Integer.parseInt(gearIntakeInInfo[1]);
    }

    public int getGearIntakeOutNumber() {
        return Integer.parseInt(gearIntakeOutInfo[1]);
    }

    public int getRunFeederOutNumber() {
        return Integer.parseInt(runFeederOutInfo[1]);
    }

    public int getRunShooterOutNumber() {
        return Integer.parseInt(runShooterOutInfo[1]);
    }

    public int getRunShooterInNumber() {
        return Integer.parseInt(runShooterInInfo[1]);
    }

    public int getRunFeederInNumber() {
        return Integer.parseInt(runFeederInInfo[1]);
    }

    public String getShiftButtonLocation() {
        return shiftButtonInfo[0];
    }

    public String getGearIntakeInLocation() {
        return gearIntakeInInfo[0];
    }

    public String getGearIntakeOutLocation() {
        return gearIntakeOutInfo[0];
    }

    public String getRunFeederOutLocation() {
        return runFeederOutInfo[0];
    }

    public String getRunShooterOutLocation() {
        return runShooterOutInfo[0];
    }

    public String getRunShooterInLocation() {
        return runShooterInInfo[0];
    }

    public String getRunFeederInLocation() {
        return runFeederInInfo[0];
    }
}
