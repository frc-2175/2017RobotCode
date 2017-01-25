package org.usfirst.frc.team2175.properties;

public class BehaviorProperties extends BaseProperties {

    private double gearIntakeInSpeed;
    private double gearIntakeOutSpeed;

    private double fuelIntakeOutSpeed;
    private double fuelIntakeInSpeed;

    private double climberMasterSpeed;

    @Override
    protected String getPropertyFileName() {
        return "behavior.properties";
    }

    @Override
    protected void populate() {
        gearIntakeInSpeed = getDoublePropertyValue("gearintake.speed.in");
        gearIntakeOutSpeed = getDoublePropertyValue("gearintake.speed.out");

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
}
