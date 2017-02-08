package org.usfirst.frc.team2175.properties;

public class BehaviorProperties extends BaseProperties {

    private double gearIntakeInSpeed;
    private double gearIntakeOutSpeed;
    private double fuelIntakeOutSpeed;
    private double fuelIntakeInSpeed;
    private double shooterOutSpeed;
    private double shooterInSpeed;
    private double feederOutSpeed;
    private double feederInSpeed;
    private double agitatorOutSpeed;
    private double agitatorInSpeed;
    private double climberMasterSpeed;

    @Override
    protected String getPropertyFileName() {
        return "behavior.properties";
    }

    @Override
    protected void populate() {
        gearIntakeInSpeed = getDoublePropertyValue("gearintake.speed.in");
        gearIntakeOutSpeed = getDoublePropertyValue("gearintake.speed.out");
        shooterInSpeed = getDoublePropertyValue("shooter.speed.in");
        shooterOutSpeed = getDoublePropertyValue("shooter.speed.out");
        feederOutSpeed = getDoublePropertyValue("feeder.speed.out");
        feederInSpeed = getDoublePropertyValue("feeder.speed.in");
        agitatorOutSpeed = getDoublePropertyValue("agitator.speed.out");
        agitatorInSpeed = getDoublePropertyValue("agitator.speed.in");
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

    public double getLeftShooterOutSpeed() {
        return -shooterOutSpeed;
    }

    public double getRightShooterOutSpeed() {
        return shooterOutSpeed;
    }

    public double getShooterInSpeed() {
        return shooterInSpeed;
    }

    public double getLeftFeederOutSpeed() {
        return feederOutSpeed;
    }

    public double getRightFeederOutSpeed() {
        return -feederOutSpeed;
    }

    public double getFeederInSpeed() {
        return feederInSpeed;
    }

    public double getAgitatorOutSpeed() {
        return agitatorOutSpeed;
    }

    public double getAgitatorInSpeed() {
        return agitatorInSpeed;
    }

}
