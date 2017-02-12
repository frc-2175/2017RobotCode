package org.usfirst.frc.team2175.properties;

public class BehaviorProperties extends BaseProperties {

    private double gearIntakeInSpeed;
    private double gearIntakeOutSpeed;
    private double fuelIntakeOutSpeed;
    private double fuelIntakeInSpeed;
    private double agitatorSpeed;
    private double maxClimberSpeed;

    private double shooterSpeed;
    private double feederSpeed;
    private double shooterReverseSpeed;
    private double feederReverseSpeed;

    @Override
    protected String getPropertyFileName() {
        return "behavior.properties";
    }

    @Override
    protected void populate() {
        gearIntakeInSpeed = getDoublePropertyValue("gearintake.speed.in");
        gearIntakeOutSpeed = getDoublePropertyValue("gearintake.speed.out");
        shooterSpeed = getDoublePropertyValue("shooter.speed");
        shooterReverseSpeed = getDoublePropertyValue("shooter.speed.reverse");
        feederSpeed = getDoublePropertyValue("feeder.speed");
        feederReverseSpeed = getDoublePropertyValue("feeder.speed.reverse");
        agitatorSpeed = getDoublePropertyValue("agitator.speed");
        fuelIntakeOutSpeed = getDoublePropertyValue("fuelintake.speed.out");
        fuelIntakeInSpeed = getDoublePropertyValue("fuelintake.speed.in");
        maxClimberSpeed = getDoublePropertyValue("climber.speed.max");
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

    public double getShooterSpeed() {
        return shooterSpeed;
    }

    public double getShooterReverseSpeed() {
        return shooterReverseSpeed;
    }

    public double getFeederSpeed() {
        return feederSpeed;
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
}
