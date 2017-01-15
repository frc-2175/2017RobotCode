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

	public AutonRecorder(Encoder rightEncoder, Encoder leftEncoder, Encoder hoodedShooterEncoder, AnalogGyro mainGyro) {
		this.rightEncoder = rightEncoder;
		this.leftEncoder = leftEncoder;
		this.mainGyro = mainGyro;
		this.hoodedShooterEncoder = hoodedShooterEncoder;
		startTime = System.nanoTime() / 1000000000.0;
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
		timeSinceInit = (System.nanoTime() / 1000000000.0) - startTime;
		return timeSinceInit;
	}

	public void setWheelStartSpinningTime() {
		wheelStartTime = System.nanoTime() / 1000000000.0;
	}

	public int finishSpinningAndReturnSpinTime() {
		wheelSpinTime = (System.nanoTime() / 1000000000.0) - wheelStartTime;
		return (int)Math.ceil(wheelSpinTime);
	}
}
