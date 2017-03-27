package org.usfirst.frc.team2175.properties;

import org.usfirst.frc.team2175.ServiceLocator;

public class Properties {
    private String feedOut;
    private String fuelIn;
    private String actuateGear;
    private String gearIn;
    private String gearOut;
    private String hopper;
    private String shiftGears;
    private String gearOutAndSpin;
    private String shootOut;
    private String cameraSwitch;
    private String precisionMode;

    private String actuateGearDriver;
    private String gearInDriver;
    private String gearOutDriver;
    private String gearOutAndSpinDriver;

    public Properties() {
        feedOut = "button.feeder.out";
        fuelIn = "button.fuel.in";
        actuateGear = "button.gear.lower";
        gearIn = "button.gear.in";
        gearOut = "button.gear.out";
        hopper = "button.gamepad.lower";
        shiftGears = "button.shift";
        gearOutAndSpin = "button.gear.outandspin";
        shootOut = "button.shoot.out";
        cameraSwitch = "buton.camera.switch";
        precisionMode = "button.drive.precision";

        actuateGear = "button.gear.lower.driver";
        gearIn = "button.gear.in.driver";
        gearOut = "button.gear.out.driver";
        gearOutAndSpin = "button.gear.outandspin.driver";

        ServiceLocator.register(this);
    }

    public String getFeedOut() {
        return feedOut;
    }

    public String getFuelIn() {
        return fuelIn;
    }

    public String getActuateGear() {
        return actuateGear;
    }

    public String getGearIn() {
        return gearIn;
    }

    public String getGearOut() {
        return gearOut;
    }

    public String getHopper() {
        return hopper;
    }

    public String getShiftGears() {
        return shiftGears;
    }

    public String getGearOutAndSpin() {
        return gearOutAndSpin;
    }

    public String getShootOut() {
        return shootOut;
    }

    public String getCameraSwitch() {
        return cameraSwitch;
    }

    public String getPrecisionMode() {
        return precisionMode;
    }

    public String getActuateGearDriver() {
        return actuateGearDriver;
    }

    public String getGearInDriver() {
        return gearInDriver;
    }

    public String getGearOutDriver() {
        return gearOutDriver;
    }

    public String getGearOutAndSpinDriver() {
        return gearOutAndSpinDriver;
    }
}
