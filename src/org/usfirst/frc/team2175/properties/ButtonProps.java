package org.usfirst.frc.team2175.properties;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ButtonProps {
    public static final String FEED_OUT = "button.feeder.out";
    public static final String FUEL_IN = "button.fuel.in";
    public static final String GEAR_IN = "button.gear.in";
    public static final String GEAR_OUT = "button.gear.out";
    public static final String ACTUATE_HOPPER = "buton.hopper.toggle";
    public static final String SHIFT_GEARS = "button.shift";
    public static final String GEAR_OUT_SPIN = "button.gear.outandspin";
    public static final String SHOOT_OUT = "button.shoot.out";
    public static final String CAMERA_SWITCH = "button.camera.switch";
    public static final String ACTUATE_GEAR = "button.gear.toggle";
    public static final String RAISE_GEAR_DRIVER = "button.gear.raise.driver";
    public static final String GEAR_OUT_DRIVER = "button.gear.out.driver";
    public static final String GEAR_IN_DRIVER = "button.gear.in.driver";
    public static final String GEAR_OUT_SPIN_DRIVER =
            "button.gear.outandspin.driver";

    public boolean areFieldRequirementsMet(String string) {
        Pattern var = Pattern.compile("[^A-Za-z.]");
        Matcher m = var.matcher(string);
        return !m.find();
    }
}
