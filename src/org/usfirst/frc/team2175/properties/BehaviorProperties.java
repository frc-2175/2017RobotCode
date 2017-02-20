package org.usfirst.frc.team2175.properties;

public class BehaviorProperties extends BaseProperties {

    private double gearIntakeInSpeed;
    private double gearIntakeOutSpeed;
    private double fuelIntakeOutSpeed;
    private double fuelIntakeInSpeed;
    private double agitatorSpeed;
    private double maxClimberSpeed;

    private double leftShooterSpeed;
    private double rightShooterSpeed;
    private double leftFeederSpeed;
    private double rightFeederSpeed;
    private double shooterReverseSpeed;
    private double feederReverseSpeed;

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
        leftShooterSpeed = getDoublePropertyValue("shooter.speed.left");
        rightShooterSpeed = getDoublePropertyValue("shooter.speed.right");
        shooterReverseSpeed = getDoublePropertyValue("shooter.speed.reverse");
        leftFeederSpeed = getDoublePropertyValue("feeder.speed.left");
        rightFeederSpeed = getDoublePropertyValue("feeder.speed.right");
        feederReverseSpeed = getDoublePropertyValue("feeder.speed.reverse");
        agitatorSpeed = getDoublePropertyValue("agitator.speed");
        fuelIntakeOutSpeed = getDoublePropertyValue("fuelintake.speed.out");
        fuelIntakeInSpeed = getDoublePropertyValue("fuelintake.speed.in");
        maxClimberSpeed = getDoublePropertyValue("climber.speed.max");

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
        return leftShooterSpeed;
    }

    public double getRightShooterSpeed() {
        return rightShooterSpeed;
    }

    public double getShooterReverseSpeed() {
        return shooterReverseSpeed;
    }

    public double getLeftFeederSpeed() {
        return leftFeederSpeed;
    }

    public double getRightFeederSpeed() {
        return rightFeederSpeed;
    }

    public double getFeederReverseSpeed() {
        return feederReverseSpeed;
    }

    public double getAgitatorSpeed() {
        return agitatorSpeed;
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

}
