package org.usfirst.frc.team2175;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;

public class SolenoidWrapper {
    private DoubleSolenoid doubleSolenoid;
    private Solenoid solenoid;
    private boolean isDouble;

    public SolenoidWrapper(final String[] solenoidInfo) {
        if (solenoidInfo[0].equals("single")) {
            this.solenoid = new Solenoid(Integer.parseInt(solenoidInfo[1]));
            isDouble = false;
        } else {
            this.doubleSolenoid =
                    new DoubleSolenoid(Integer.parseInt(solenoidInfo[1]),
                            Integer.parseInt(solenoidInfo[2]));
            isDouble = true;
        }
    }

    public void set(final boolean on) {
        if (isDouble && on) {
            doubleSolenoid.set(Value.kForward);
        } else if (isDouble && !on) {
            doubleSolenoid.set(Value.kReverse);
        } else {
            solenoid.set(on);
        }
    }

    public boolean get() {
        if (solenoid != null) {
            return solenoid.get();
        } else {
            if (doubleSolenoid.get() == Value.kForward) {
                return true;
            } else {
                return false;
            }
        }
    }

    // We might need to implement some other methods, like get(). But that
    // should
    // be doable in much the same way.

}
