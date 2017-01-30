package org.usfirst.frc.team2175.properties;

public class JoystickProperties extends BaseProperties {
    private int joystickLeftPort;
    private int joystickRightPort;
    private int gamepadPort;
    
    private double deadbandSize;
    
    private ButtonInfo climberInfo;
    private ButtonInfo feederInInfo;
    private ButtonInfo feederOutInfo;
    private ButtonInfo fuelIntakeInInfo;
    private ButtonInfo fuelIntakeOutInfo;
    private ButtonInfo fuelIntakeActuateInInfo;
    private ButtonInfo fuelIntakeActuateOutInfo;
    private ButtonInfo gearIntakeInInfo;
    private ButtonInfo gearIntakeOutInfo;
    private ButtonInfo gearIntakeActuatorInfo;
    private ButtonInfo hopperInfo;
    private ButtonInfo shiftButtonInfo;
    private ButtonInfo shooterInInfo;
    private ButtonInfo shooterOutInfo;

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

        climberInfo = buttonInfoFromPropertyValue("button.climber.spin");
        feederInInfo = buttonInfoFromPropertyValue("button.feeder.in");
        feederOutInfo = buttonInfoFromPropertyValue("button.feeder.out");
        fuelIntakeInInfo = buttonInfoFromPropertyValue("button.fuelintake.in");
        fuelIntakeOutInfo = buttonInfoFromPropertyValue("button.fuelintake.out");
        fuelIntakeActuateInInfo = buttonInfoFromPropertyValue("button.fuelintake.actuatein");
        fuelIntakeActuateOutInfo = buttonInfoFromPropertyValue("button.fuelintake.actuateout");
        gearIntakeInInfo = buttonInfoFromPropertyValue("button.gearintake.in");
        gearIntakeOutInfo = buttonInfoFromPropertyValue("button.gearintake.out");
        gearIntakeActuatorInfo = buttonInfoFromPropertyValue("button.gearintake.lower");
        hopperInfo = buttonInfoFromPropertyValue("button.hopper.lower");
        shiftButtonInfo = buttonInfoFromPropertyValue("button.shift");
        shooterInInfo = buttonInfoFromPropertyValue("button.shooter.in");
        shooterOutInfo = buttonInfoFromPropertyValue("button.shooter.out");
    }

    protected ButtonInfo buttonInfoFromPropertyValue(String propertyValue) {
        return new ButtonInfo(getJoystickName(propertyValue),
                getButtonNumber(propertyValue));
    }

    private String getJoystickName(String propertyName) {
        return getStringArrayPropertyValue(propertyName)[0];
    }

    private int getButtonNumber(String propertyName) {
        return Integer.parseInt(getStringArrayPropertyValue(propertyName)[1]);
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

    public ButtonInfo getClimberInfo() {
    	return climberInfo;
    }
    
    public ButtonInfo getFeederInInfo() {
    	return feederInInfo;
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
    
    public ButtonInfo getFuelIntakeOutInfo() {
    	return fuelIntakeOutInfo;
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
    
    public ButtonInfo getShooterInInfo() {
    	return shooterInInfo;
    }
    
    public ButtonInfo getShooterOutInfo() {
    	return shooterOutInfo;
    }
}

