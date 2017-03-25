package org.usfirst.frc.team2175.properties;

import java.util.HashMap;

import org.usfirst.frc.team2175.ServiceLocator;

public class JoystickProperties extends BaseProperties {

    private HashMap<String, ButtonInfo> buttonInfoMap;

    private int leftJoystickPort;
    private int rightJoystickPort;
    private int weaponsGamepadPort;

    private double deadbandSize;

    private int shooterInPOVAngle;
    private int fuelOutPOVAngle;

    @Override
    protected String getPropertyFileName() {
        return "joysticks.properties";
    }

    public static class ButtonInfo {
        public final String joystickName;
        public final int buttonNumber;

        private ButtonInfo(final String joystickName, final int buttonNumber) {
            this.joystickName = joystickName;
            this.buttonNumber = buttonNumber;
        }
    }

    @Override
    protected void populate() {
        buttonInfoMap = new HashMap<>();

        Properties props = ServiceLocator.get(Properties.class);

        leftJoystickPort = getIntPropertyValue("joystick.left.port");
        rightJoystickPort = getIntPropertyValue("joystick.right.port");
        weaponsGamepadPort = getIntPropertyValue("joystick.weapons.port");

        deadbandSize = getDoublePropertyValue("deadband.value");

        createInfoFromProps(props.getFeedOut());
        createInfoFromProps(props.getFuelIn());
        createInfoFromProps(props.getGearIn());
        createInfoFromProps(props.getGearOut());
        createInfoFromProps(props.getActuateGear());
        createInfoFromProps(props.getHopper());
        createInfoFromProps(props.getShiftGears());
        createInfoFromProps(props.getShootOut());
        createInfoFromProps(props.getCameraSwitch());
        createInfoFromProps(props.getGearOutAndSpin());
        createInfoFromProps(props.getPrecisionMode());

        createInfoFromProps(props.getGearOutAndSpinDriver());
        createInfoFromProps(props.getGearInDriver());
        createInfoFromProps(props.getGearOutDriver());
        createInfoFromProps(props.getActuateGearDriver());

        shooterInPOVAngle = getIntPropertyValue("pov.shooter.angle");
        fuelOutPOVAngle = getIntPropertyValue("pov.fuel.angle");
    }

    protected void createInfoFromProps(final String propertyValue) {
        ButtonInfo info = new ButtonInfo(getJoystickName(propertyValue),
                getButtonNumber(propertyValue));
        buttonInfoMap.put(propertyValue, info);
    }

    public String getJoystickName(final String propertyName) {
        return getStringArrayPropertyValue(propertyName)[0];
    }

    public int getButtonNumber(final String propertyName) {
        return Integer.parseInt(getStringArrayPropertyValue(propertyName)[1]);
    }

    public HashMap<String, ButtonInfo> getButtonInfo() {
        return buttonInfoMap;
    }

    public int getLeftJoystickPort() {
        return leftJoystickPort;
    }

    public int getRightJoytickPort() {
        return rightJoystickPort;
    }

    public int getWeaponsGamepadPort() {
        return weaponsGamepadPort;
    }

    public double getDeadbandValue() {
        return deadbandSize;
    }

    public int getShooterInPOV() {
        return shooterInPOVAngle;
    }

    public int getFuelIntakeOutPOV() {
        return fuelOutPOVAngle;
    }
}
