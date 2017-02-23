package org.usfirst.frc.team2175;

import org.usfirst.frc.team2175.properties.WiringProperties.SolenoidInfo;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;

public class SolenoidWrapper {
    private DoubleSolenoid doubleSolenoid;
    private Solenoid solenoid;
    private boolean isDouble;

    public SolenoidWrapper(final SolenoidInfo solenoidInfo) {
        if (solenoidInfo.type.equals("single")) {
            this.solenoid = new Solenoid(solenoidInfo.ports[0]);
            isDouble = false;
        } else {
            this.doubleSolenoid = new DoubleSolenoid(solenoidInfo.ports[0],
                    solenoidInfo.ports[1]);
            isDouble = true;
        }
    }

    public void set(final boolean on) {
        if (isDouble) {
            if (on) {
                doubleSolenoid.set(Value.kForward);
            } else {
                doubleSolenoid.set(Value.kReverse);
            }
        } else {
            solenoid.set(on);
        }
    }

    public boolean get() {
        if (isDouble) {
            if (doubleSolenoid.get() == Value.kForward) {
                return true;
            } else {
                return false;
            }
        } else {
            return solenoid.get();
        }
    }
}
