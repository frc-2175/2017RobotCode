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
    private int gearIntakeSolenoidNumber;

    private int fuelIntakeMainMotorDeviceNumber;

    private int hopperForwardNumber;
    private int hopperReverseNumber;

    private int shooterShooterMotorDeviceNumber;
    private int shooterFeederMotorDeviceNumber;
    private int shooterAgitatorMotorDeviceNumber;
    private int shooterShooterMotorTwoDeviceNumber;
    private int shooterFeederMotorTwoDeviceNumber;
    private int shooterActuatorLeftDeviceNumber;
    private int shooterActuatorRightDeviceNumber;

    private int drivetrainAnalogGyroDeviceNumber;

    private int climberMotorOneNumber;
    private int climberMotorTwoNumber;

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
        gearIntakeSolenoidNumber = getIntPropertyValue("gearintake.solenoid");
        fuelIntakeMainMotorDeviceNumber =
                getIntPropertyValue("fuelintake.motor.main");

        hopperForwardNumber = getIntPropertyValue("hopper.solenoid.forward");
        hopperReverseNumber = getIntPropertyValue("hopper.solenoid.reverse");

        shooterShooterMotorDeviceNumber =
                getIntPropertyValue("shooter.motor.shooter");
        shooterFeederMotorDeviceNumber =
                getIntPropertyValue("shooter.motor.feeder");
        shooterAgitatorMotorDeviceNumber =
                getIntPropertyValue("shooter.motor.agitator");

        drivetrainAnalogGyroDeviceNumber =
                getIntPropertyValue("drivetrain.analog.gyro");

        climberMotorOneNumber = getIntPropertyValue("climber.motor.one");
        climberMotorTwoNumber = getIntPropertyValue("climber.motor.two");

        shooterShooterMotorTwoDeviceNumber =
                getIntPropertyValue("shooter.motor.shootertwo");
        shooterFeederMotorTwoDeviceNumber =
                getIntPropertyValue("shooter.motor.feedertwo");
        shooterActuatorLeftDeviceNumber =
                getIntPropertyValue("shooter.solenoid.actuator.left");
        shooterActuatorRightDeviceNumber =
                getIntPropertyValue("shooter.solenoid.actuator.right");
    }

    public int getClimberMotorOneNumber() {
        return climberMotorOneNumber;
    }

    public int getClimberMotorTwoNumber() {
        return climberMotorTwoNumber;
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

    public int getFuelIntakeMainMotorDeviceNumber() {
        return fuelIntakeMainMotorDeviceNumber;
    }

    public int getDrivetrainAnalogGyroDeviceNumber() {
        return drivetrainAnalogGyroDeviceNumber;
    }

    public int getHopperForwardNumber() {
        return hopperForwardNumber;
    }

    public int getHopperReverseNumber() {
        return hopperReverseNumber;
    }

    public int getGearIntakeSolenoidNumber() {
        return gearIntakeSolenoidNumber;
    }

    public int getShooterShooterMotorTwoDeviceNumber() {
        return shooterShooterMotorTwoDeviceNumber;
    }

    public int getShooterFeederMotorTwoDeviceNumber() {
        return shooterFeederMotorTwoDeviceNumber;
    }

    public int getShooterActuatorLeftDeviceNumber() {
        return shooterActuatorLeftDeviceNumber;
    }

    public int getShooterActuatorRightDeviceNumber() {
        return shooterActuatorRightDeviceNumber;
    }
}
