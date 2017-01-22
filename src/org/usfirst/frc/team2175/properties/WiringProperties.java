package org.usfirst.frc.team2175.properties;

public class WiringProperties extends BaseProperties {

    private int leftMasterMotorNumber;
    private int rightMasterMotorNumber;
    private int leftSlaveMotorOneNumber;
    private int leftSlaveMotorTwoNumber;
    private int rightSlaveMotorOneNumber;
    private int rightSlaveMotorTwoNumber;

    private int driveShiftersForwardNumber;
    private int driveShiftersReverseNumber;

    private int leftGearIntakeMotorDeviceNumber;
    private int rightGearIntakeMotorDeviceNumber;

    private int fuelIntakeActuaterForwardNumber;
    private int fuelIntakeActuaterReverseNumber;
    private int fuelIntakeMainMotorDeviceNumber;

    private int shooterShooterMotorDeviceNumber;
    private int shooterFeederMotorDeviceNumber;
    private int shooterAgitatorMotorDeviceNumber;

    @Override
    protected String getPropertyFileName() {
        return "wiring.properties";
    }

    @Override
    protected void populate() {
        driveShiftersForwardNumber = getIntPropertyValue(
                "drivetrain.solenoid.driveshifters.forward");
        driveShiftersReverseNumber = getIntPropertyValue(
                "drivetrain.solenoid.driveshifters.reverse");
        leftMasterMotorNumber =
                getIntPropertyValue("drivetrain.motor.left.master");
        leftSlaveMotorOneNumber =
                getIntPropertyValue("drivetrain.motor.left.slaveone");
        leftSlaveMotorTwoNumber =
                getIntPropertyValue("drivetrain.motor.left.slavetwo");

        rightMasterMotorNumber =
                getIntPropertyValue("drivetrain.motor.right.master");
        rightSlaveMotorOneNumber =
                getIntPropertyValue("drivetrain.motor.right.slaveone");
        rightSlaveMotorTwoNumber =
                getIntPropertyValue("drivetrain.motor.right.slavetwo");

        leftGearIntakeMotorDeviceNumber =
                getIntPropertyValue("gearintake.motor.left");
        rightGearIntakeMotorDeviceNumber =
                getIntPropertyValue("gearintake.motor.right");

        fuelIntakeActuaterForwardNumber = getIntPropertyValue(
                "fuelintake.solenoid.actuatesolenoid.forward");
        fuelIntakeActuaterReverseNumber = getIntPropertyValue(
                "fuelintake.solenoid.actuatesolenoid.reverse");
        fuelIntakeMainMotorDeviceNumber =
                getIntPropertyValue("fuelintake.motor.main");

        shooterShooterMotorDeviceNumber =
                getIntPropertyValue("shooter.motor.shooter");
        shooterFeederMotorDeviceNumber =
                getIntPropertyValue("shooter.motor.feeder");
        shooterAgitatorMotorDeviceNumber =
                getIntPropertyValue("shooter.motor.agitator");

    }

    public int getShooterShooterMotorDeviceNumber() {
        return shooterShooterMotorDeviceNumber;
    }

    public int getShooterFeederMotorDeviceNumber() {
        return shooterFeederMotorDeviceNumber;
    }

    public int getShooterAgitatorMotorDeviceNumber() {
        return shooterAgitatorMotorDeviceNumber;
    }

    public int getDriveShiftersForwardNumber() {
        return driveShiftersForwardNumber;
    }

    public int getDriveShiftersReverseNumber() {
        return driveShiftersReverseNumber;
    }

    public int getLeftMasterMotorNumber() {
        return leftMasterMotorNumber;
    }

    public int getRightMasterMotorNumber() {
        return rightMasterMotorNumber;
    }

    public int getLeftSlaveMotorOneNumber() {
        return leftSlaveMotorOneNumber;
    }

    public int getLeftSlaveMotorTwoNumber() {
        return leftSlaveMotorTwoNumber;
    }

    public int getRightSlaveMotorOneNumber() {
        return rightSlaveMotorOneNumber;
    }

    public int getRightSlaveMotorTwoNumber() {
        return rightSlaveMotorTwoNumber;
    }

    public int getLeftGearIntakeDeviceNumber() {
        return leftGearIntakeMotorDeviceNumber;
    }

    public int getRightGearIntakeDeviceNumber() {
        return rightGearIntakeMotorDeviceNumber;
    }

    public int getFuelIntakeActuaterForwardNumber() {
        return fuelIntakeActuaterForwardNumber;
    }

    public int getFuelIntakeActuaterReverseNumber() {
        return fuelIntakeActuaterReverseNumber;
    }

    public int getFuelIntakeMainMotorDeviceNumber() {
        return fuelIntakeMainMotorDeviceNumber;
    }
}
