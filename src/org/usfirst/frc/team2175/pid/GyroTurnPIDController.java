package org.usfirst.frc.team2175.pid;

import edu.wpi.first.wpilibj.PIDSourceType;

public class GyroTurnPIDController extends PIDControllerComplete {

    public GyroTurnPIDController() {
        // Get PID values from a properties file and set them here.
        setPID(0, 0, 0, 0);

        // Set the minimum and maximum outputs here.
        setOutputRange(-1, 1);

        // Set the "close enough" value here. If our sensor reading is less than
        // that, we'll consider ourselves done with this PID.
        setAbsoluteTolerance(0.01);

        // Set the type of PID controller here - either kDisplacement or kRate.
        setPIDSourceType(PIDSourceType.kDisplacement);
    }

    @Override
    public double pidGet() {
        // Return the gyro angle from this method. The PIDController class will
        // use this as the sensor value.
        return 0;
    }

    @Override
    public void pidWrite(final double output) {
        // Actually make stuff happen here! For example, turning by "output".
    }

}
