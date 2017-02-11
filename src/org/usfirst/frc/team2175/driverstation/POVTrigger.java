package org.usfirst.frc.team2175.driverstation;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class POVTrigger extends Trigger {

    private Joystick gamepad;
    private int anglePosition;

    public POVTrigger(final Joystick gamepad, final int anglePosition) {
        this.gamepad = gamepad;
        this.anglePosition = anglePosition;
    }

    @Override
    public boolean get() {
        return gamepad.getPOV() == anglePosition;
    }

}
