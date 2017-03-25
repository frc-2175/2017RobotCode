package org.usfirst.frc.team2175.properties;

public class JoystickProperties extends BaseProperties {

    private int weaponsGamepadPort;
    private int leftJoystickPort;
    private int rightJoystickPort;

    private double deadbandSize;

    private ButtonInfo feederOutInfo;
    private ButtonInfo fuelIntakeInInfo;
    private ButtonInfo gearIntakeInInfo;
    private ButtonInfo gearIntakeOutInfo;
    private ButtonInfo gearIntakeActuatorInfo;
    private ButtonInfo hopperInfo;
    private ButtonInfo shiftButtonInfo;
    private ButtonInfo shooterOutInfo;
    private ButtonInfo cameraSwitchInfo;
    private ButtonInfo gearIntakeOutAndSpinInfo;
    private ButtonInfo gearIntakeInDriverInfo;
    private ButtonInfo gearIntakeOutDriverInfo;
    private ButtonInfo gearIntakeActuatorDriverInfo;
    private ButtonInfo gearIntakeOutAndSpinDriverInfo;
    private int precisionModeButtonNumber;

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
        leftJoystickPort = getIntPropertyValue("joystick.left.port");
        rightJoystickPort = getIntPropertyValue("joystick.right.port");
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
        shooterActuatorInInfo =
                buttonInfoFromPropertyValue("button.shooter.actuator.in");
        shooterActuatorOutInfo =
                buttonInfoFromPropertyValue("button.shooter.actuator.out");
        gearIntakeOutAndSpinDriverInfo = buttonInfoFromPropertyValue(
                "button.gearintake.outandspin.driver");

        precisionModeButtonNumber = getButtonNumber("button.drive.precision");

        shooterInPOVAngle = getIntPropertyValue("pov.shooter.angle");
        fuelOutPOVAngle = getIntPropertyValue("pov.fuel.angle");
        gearIntakeInDriverInfo =
                buttonInfoFromPropertyValue("button.gearintake.in.driver");
        gearIntakeOutDriverInfo =
                buttonInfoFromPropertyValue("button.gearintake.out.driver");
        gearIntakeActuatorDriverInfo =
                buttonInfoFromPropertyValue("button.gearintake.lower.driver");
    }

    public ButtonInfo getGearIntakeOutAndSpinDriverInfo() {
        return gearIntakeOutAndSpinDriverInfo;
    }

    public ButtonInfo getGearIntakeInDriverInfo() {
        return gearIntakeInDriverInfo;
    }

    public ButtonInfo getGearIntakeOutDriverInfo() {
        return gearIntakeOutDriverInfo;
    }

    public ButtonInfo getGearIntakeActuatorDriverInfo() {
        return gearIntakeActuatorDriverInfo;
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

    public int getWeaponsGamepadPort() {
        return weaponsGamepadPort;
    }

    public double getDeadbandValue() {
        return deadbandSize;
    }

    public ButtonInfo getFeederOutInfo() {
        return feederOutInfo;
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

    public int getShooterInPOV() {
        return shooterInPOVAngle;
    }

    public int getFuelIntakeOutPOV() {
        return fuelOutPOVAngle;
    }

    public int getPrecisionButtonNumber() {
        return precisionModeButtonNumber;
    }

    public int getRightJoytickPort() {
        return rightJoystickPort;
    }

    public int getLeftJoystickPort() {
        return leftJoystickPort;
    }
}
