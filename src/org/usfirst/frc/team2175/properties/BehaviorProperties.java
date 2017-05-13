package org.usfirst.frc.team2175.properties;

public class BehaviorProperties extends BaseProperties {

    private double gearIntakeInSpeed;
    private double gearIntakeOutSpeed;
    private double fuelIntakeOutSpeed;
    private double fuelIntakeInSpeed;
    private double agitatorSpeed;
    private double agitatorReverseSpeed;
    private double maxClimberSpeed;

    private double shooterSpeed;
    private double feederSpeed;
    private double shooterReverseSpeed;
    private double feederReverseSpeed;
    private double augerSpeed;
    private double augerReverseSpeed;

    private double drivetrainConversionFactor;

    private double currentThreshold;

    private double drivetrainGyroTurnCorrection;

    private double gyroP;
    private double gyroI;
    private double gyroD;
    private double gyroF;

    @Override
    protected String getPropertyFileName() {
        return "behavior.properties";
    }

    @Override
    protected void populate() {
        gearIntakeInSpeed = getDoublePropertyValue("gearintake.speed.in");
        gearIntakeOutSpeed = getDoublePropertyValue("gearintake.speed.out");
        shooterSpeed = getDoublePropertyValue("shooter.speed.left");
        shooterReverseSpeed = getDoublePropertyValue("shooter.speed.reverse");
        feederSpeed = getDoublePropertyValue("feeder.speed.left");
        feederReverseSpeed = getDoublePropertyValue("feeder.speed.reverse");
        augerSpeed = getDoublePropertyValue("auger.speed");
        augerReverseSpeed = getDoublePropertyValue("auger.speed.reverse");
        agitatorSpeed = getDoublePropertyValue("agitator.speed");
        agitatorReverseSpeed = getDoublePropertyValue("agitator.speed.reverse");
        fuelIntakeOutSpeed = getDoublePropertyValue("fuelintake.speed.out");
        fuelIntakeInSpeed = getDoublePropertyValue("fuelintake.speed.in");
        maxClimberSpeed = getDoublePropertyValue("climber.speed.max");
        currentThreshold =
                getDoublePropertyValue("drivetrain.threshold.current");
        drivetrainConversionFactor =
                getDoublePropertyValue("drivetrain.conversion");

        drivetrainGyroTurnCorrection =
                getDoublePropertyValue("drivetrain.gyro.turncorrection");

        gyroP = getDoublePropertyValue("gyro.p");
        gyroI = getDoublePropertyValue("gyro.i");
        gyroD = getDoublePropertyValue("gyro.d");
        gyroF = getDoublePropertyValue("gyro.f");
    }

    public double getFuelIntakeOutSpeed() {
        return fuelIntakeOutSpeed;
    }

    public double getFuelIntakeInSpeed() {
        return fuelIntakeInSpeed;
    }

    public double getGearIntakeInSpeed() {
        return gearIntakeInSpeed;
    }

    public double getGearIntakeOutSpeed() {
        return gearIntakeOutSpeed;
    }

    public double getLeftShooterSpeed() {
        return shooterSpeed;
    }

    public double getShooterReverseSpeed() {
        return shooterReverseSpeed;
    }

    public double getLeftFeederSpeed() {
        return feederSpeed;
    }

    public double getFeederReverseSpeed() {
        return feederReverseSpeed;
    }

    public double getAgitatorSpeed() {
        return agitatorSpeed;
    }

    public double getAgitatorReverseSpeed() {
        return agitatorReverseSpeed;
    }

    public double getMaxClimberSpeed() {
        return maxClimberSpeed;
    }

    public double getGyroP() {
        return gyroP;
    }

    public double getGyroI() {
        return gyroI;
    }

    public double getGyroD() {
        return gyroD;
    }

    public double getGyroF() {
        return gyroF;
    }

    public double getDrivetrainGyroTurnCorrection() {
        return drivetrainGyroTurnCorrection;
    }

    public double getCurrentThreshold() {
        return currentThreshold;
    }

    public double getAugerSpeed() {
        return augerSpeed;
    }

    public double getAugerReverseSpeed() {
        return augerReverseSpeed;
    }

    public double getConversionFactor() {
        return drivetrainConversionFactor;
    }

}
