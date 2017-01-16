package org.usfirst.frc.team2175.autonrecorder;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;

public class AutonRecorder {
    Encoder rightEncoder;
    Encoder leftEncoder;
    Encoder hoodedShooterEncoder;
    AnalogGyro mainGyro;

    double startTime;
    double wheelStartTime;
    double wheelSpinTime;

    public AutonRecorder(Encoder rightEncoder, Encoder leftEncoder,
            Encoder hoodedShooterEncoder, AnalogGyro mainGyro) {
        this.rightEncoder = rightEncoder;
        this.leftEncoder = leftEncoder;
        this.mainGyro = mainGyro;
        this.hoodedShooterEncoder = hoodedShooterEncoder;
        startTime = convertFromNanosecondsToSeconds(System.nanoTime());
    }

    public double determineInchesDriven() {
        double inchesDriven;
        inchesDriven = rightEncoder.getDistance();
        return inchesDriven;
    }

    public double determineDegreesTurned() {
        double degreesTurned;
        degreesTurned = mainGyro.getAngle();
        return degreesTurned;
    }

    public void resetAll() {
        rightEncoder.reset();
        leftEncoder.reset();
        mainGyro.reset();
    }

    public double determineTimeSinceInit() {
        double timeSinceInit;
        timeSinceInit = (convertFromNanosecondsToSeconds(System.nanoTime()))
                - startTime;
        return timeSinceInit;
    }

    public void setWheelStartSpinningTime() {
        wheelStartTime = convertFromNanosecondsToSeconds(System.nanoTime());
    }

    public int finishSpinningAndReturnSpinTime() {
        wheelSpinTime = convertFromNanosecondsToSeconds(System.nanoTime())
                - wheelStartTime;
        return (int) Math.ceil(wheelSpinTime);
    }

    public static double convertFromNanosecondsToSeconds(
            double nanosecondsToConvert) {
        double secondsToReturn;
        secondsToReturn = nanosecondsToConvert / 1000000000.0;
        return secondsToReturn;
    }
}
