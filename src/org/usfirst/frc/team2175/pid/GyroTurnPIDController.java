package org.usfirst.frc.team2175.pid;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;

import edu.wpi.first.wpilibj.PIDSourceType;

public class GyroTurnPIDController extends PIDControllerComplete {
    private DrivetrainSubsystem drivetrainSubsystem;

    public GyroTurnPIDController() {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        final BehaviorProperties behaviorProperties =
                ServiceLocator.get(BehaviorProperties.class);
        final double p = behaviorProperties.getGyroP();
        final double i = behaviorProperties.getGyroI();
        final double d = behaviorProperties.getGyroD();
        final double f = behaviorProperties.getGyroF();
        // Get PID values from a properties file and set them here.
        setPID(p, i, d, f);

        // Set the minimum and maximum outputs here.
        setOutputRange(-1, 1);

        // Set the "close enough" value here. If our sensor reading is less than
        // that, we'll consider ourselves done with this PID.
        // TODO Make absolute tolerance a property
        setAbsoluteTolerance(2);

        // Set the type of PID controller here - either kDisplacement or kRate.
        setPIDSourceType(PIDSourceType.kDisplacement);
    }

    @Override
    public double pidGet() {
        // Return the gyro angle from this method. The PIDController class will
        // use this as the sensor value.
        return drivetrainSubsystem.getGyroAngle();
    }

    @Override
    public void pidWrite(final double output) {
        drivetrainSubsystem.arcadeDrive(0, output);
    }

}
