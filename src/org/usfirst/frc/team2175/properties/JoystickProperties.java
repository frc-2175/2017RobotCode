package org.usfirst.frc.team2175.properties;

public class JoystickProperties extends BaseProperties {

    private int driverGamepadPort;
    private int weaponsGamepadPort;

    private double deadbandSize;

    private ButtonInfo feederOutInfo;
    private ButtonInfo fuelIntakeInInfo;
    private ButtonInfo fuelIntakeActuateInInfo;
    private ButtonInfo fuelIntakeActuateOutInfo;
    private ButtonInfo gearIntakeInInfo;
    private ButtonInfo gearIntakeOutInfo;
    private ButtonInfo gearIntakeActuatorInfo;
    private ButtonInfo hopperInfo;
    private ButtonInfo shiftButtonInfo;
    private ButtonInfo shooterOutInfo;
    private ButtonInfo cameraSwitchInfo;
    private ButtonInfo gearIntakeOutAndSpinInfo;
    private ButtonInfo shooterActuatorInfo;

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
        driverGamepadPort = getIntPropertyValue("joystick.driver.port");
        weaponsGamepadPort = getIntPropertyValue("joystick.weapons.port");

        deadbandSize = getDoublePropertyValue("deadband.value");

        feederOutInfo = buttonInfoFromPropertyValue("button.feeder.out");
        fuelIntakeInInfo = buttonInfoFromPropertyValue("button.fuelintake.in");
        fuelIntakeActuateInInfo =
                buttonInfoFromPropertyValue("button.fuelintake.actuatein");
        fuelIntakeActuateOutInfo =
                buttonInfoFromPropertyValue("button.fuelintake.actuateout");
        gearIntakeInInfo = buttonInfoFromPropertyValue("button.gearintake.in");
        gearIntakeOutInfo =
                buttonInfoFromPropertyValue("button.gearintake.out");
        gearIntakeActuatorInfo =
                buttonInfoFromPropertyValue("button.gearintake.lower");
        hopperInfo = buttonInfoFromPropertyValue("button.hopper.lower");
        shiftButtonInfo = buttonInfoFromPropertyValue("button.shift");
        shooterOutInfo = buttonInfoFromPropertyValue("button.shooter.out");
        cameraSwitchInfo = buttonInfoFromPropertyValue("button.camera.switch");
        gearIntakeOutAndSpinInfo =
                buttonInfoFromPropertyValue("button.gearintake.outandspin");
        shooterActuatorInfo =
                buttonInfoFromPropertyValue("button.shooter.actuator");

        shooterInPOVAngle = getIntPropertyValue("pov.shooter.angle");
        fuelOutPOVAngle = getIntPropertyValue("pov.fuel.angle");
    }

    protected ButtonInfo buttonInfoFromPropertyValue(
            final String propertyValue) {
        return new ButtonInfo(getJoystickName(propertyValue),
                getButtonNumber(propertyValue));
    }

    public String getJoystickName(final String propertyName) {
        return getStringArrayPropertyValue(propertyName)[0];
    }

    public int getButtonNumber(final String propertyName) {
        return Integer.parseInt(getStringArrayPropertyValue(propertyName)[1]);
    }

    public int getDriverGamepadPort() {
        return driverGamepadPort;
    }

    public int getWeaponsGamepadPort() {
        return weaponsGamepadPort;
    }

    public double getDeadbandValue() {
        return deadbandSize;
    }

    public ButtonInfo getFeederOutInfo() {
        return feederOutInfo;
    }

    public ButtonInfo getFuelIntakeActuateInInfo() {
        return fuelIntakeActuateInInfo;
    }

    public ButtonInfo getFuelIntakeActuateOutInfo() {
        return fuelIntakeActuateOutInfo;
    }

    public ButtonInfo getFuelIntakeInInfo() {
        return fuelIntakeInInfo;
    }

    public ButtonInfo getGearIntakeActuatorInfo() {
        return gearIntakeActuatorInfo;
    }

    public ButtonInfo getGearIntakeInInfo() {
        return gearIntakeInInfo;
    }

    public ButtonInfo getGearIntakeOutInfo() {
        return gearIntakeOutInfo;
    }

    public ButtonInfo getHopperInfo() {
        return hopperInfo;
    }

    public ButtonInfo getShiftGearsInfo() {
        return shiftButtonInfo;
    }

    public ButtonInfo getShooterOutInfo() {
        return shooterOutInfo;
    }

    public ButtonInfo getCameraSwitchInfo() {
        return cameraSwitchInfo;
    }

    public ButtonInfo getGearIntakeOutAndSpinInfo() {
        return gearIntakeOutAndSpinInfo;
    }

    public ButtonInfo getShooterActuatorInfo() {
        return shooterActuatorInfo;
    }

    public int getShooterInPOV() {
        return shooterInPOVAngle;
    }

    public int getFuelIntakeOutPOV() {
        return fuelOutPOVAngle;
    }
}
