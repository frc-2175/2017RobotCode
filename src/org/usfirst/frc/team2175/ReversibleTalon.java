package org.usfirst.frc.team2175;

import com.ctre.CANTalon;

public class ReversibleTalon extends CANTalon {
    private boolean isReversed;

    public ReversibleTalon(final int deviceNumber) {
        super(deviceNumber);
    }

    @Override
    public void reverseOutput(final boolean flip) {
        isReversed = flip;
    }

    @Override
    public void set(double setValue) {
        if (this.getControlMode() == TalonControlMode.PercentVbus) {
            if (isReversed) {
                setValue = -setValue;
            }
        }
        super.set(setValue);
    }
}
