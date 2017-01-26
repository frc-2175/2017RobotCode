package org.usfirst.frc.team2175.properties;

public class BehaviorProperties extends BaseProperties {

    private double gearIntakeInSpeed;
    private double gearIntakeOutSpeed;

    private double fuelIntakeOutSpeed;
    private double fuelIntakeInSpeed;
    private double shooterSpeed;
    private double shooterInSpeed;
    private double feederSpeed;
    private double feederInSpeed;
    private double agitatorSpeed;
    private double agitatorInSpeeed;
    private double climberMasterSpeed;

    @Override
    protected String getPropertyFileName() {
        return "behavior.properties";
    }

    @Override
    protected void populate() {
        gearIntakeInSpeed = getDoublePropertyValue("gearintake.speed.in");
        gearIntakeOutSpeed = getDoublePropertyValue("gearintake.speed.out");
        shooterSpeed = getDoublePropertyValue("shooter.speed.");
        shooterSpeed = getDoublePropertyValue("shooter.speed.in");
        feederSpeed = getDoublePropertyValue("feeder.speed");
        feederInSpeed = getDoublePropertyValue("feeder.speed.in");
        agitatorSpeed = getDoublePropertyValue("agitator.speed");
        agitatorInSpeeed = getDoublePropertyValue("agitator.speed.in");
        fuelIntakeOutSpeed = getDoublePropertyValue("fuelintake.speed.out");
        fuelIntakeInSpeed = getDoublePropertyValue("fuelintake.speed.in");

        climberMasterSpeed = getDoublePropertyValue("climber.speed.master");
    }

    public double getFuelIntakeOutSpeed() {
        return fuelIntakeOutSpeed;
    }

    public double getFuelIntakeInSpeed() {
        return fuelIntakeInSpeed;
    }

    public double getClimberMasterSpeed() {
        return climberMasterSpeed;
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

    public double getShooterInSpeed() {
        return shooterInSpeed;
    }

    public double getFeederSpeed() {
        return feederSpeed;
    }

    public double getFeederInSpeed() {
        return feederInSpeed;
    }

    public double getAgitatorSpeed() {
        return agitatorSpeed;
    }

    public double getAgitatorInSpeeed() {
        return agitatorInSpeeed;
    }

}
