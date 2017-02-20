package org.usfirst.frc.team2175.properties;

public class WiringProperties extends BaseProperties {

    private int leftMasterMotorNumber;
    private int rightMasterMotorNumber;
    private int leftSlaveMotorOneNumber;
    private int leftSlaveMotorTwoNumber;
    private int rightSlaveMotorOneNumber;
    private int rightSlaveMotorTwoNumber;
    private String[] driveShiftersSolenoidInfo;

    private int leftGearIntakeMotorDeviceNumber;
    private int rightGearIntakeMotorDeviceNumber;
    private String[] gearIntakeSolenoidInfo;

    private int fuelIntakeMainMotorDeviceNumber;
    private String[] hopperSolenoidInfo;

    private int leftShooterMotorDeviceNumber;
    private int leftFeederMotorDeviceNumber;
    private int shooterAgitatorMotorDeviceNumber;
    private int rightShooterMotorDeviceNumber;
    private int rightFeederMotorDeviceNumber;
    private String[] shooterActuatorSolenoidInfo;

    private int drivetrainAnalogGyroDeviceNumber;

    private int climberMotorOneNumber;
    private int climberMotorTwoNumber;

    @Override
    protected String getPropertyFileName() {
        return "wiring.properties";
    }

    @Override
    protected void populate() {
        driveShiftersSolenoidInfo = getStringArrayPropertyValue(
                "drivetrain.solenoid.driveshifters");

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
        gearIntakeSolenoidInfo =
                getStringArrayPropertyValue("gearintake.solenoid");
        fuelIntakeMainMotorDeviceNumber =
                getIntPropertyValue("fuelintake.motor.main");

        hopperSolenoidInfo = getStringArrayPropertyValue("hopper.solenoid");

        leftShooterMotorDeviceNumber =
                getIntPropertyValue("shooter.motor.shooter");
        leftFeederMotorDeviceNumber =
                getIntPropertyValue("shooter.motor.feeder");
        shooterAgitatorMotorDeviceNumber =
                getIntPropertyValue("shooter.motor.agitator");

        drivetrainAnalogGyroDeviceNumber =
                getIntPropertyValue("drivetrain.analog.gyro");

        climberMotorOneNumber = getIntPropertyValue("climber.motor.one");
        climberMotorTwoNumber = getIntPropertyValue("climber.motor.two");

        rightShooterMotorDeviceNumber =
                getIntPropertyValue("shooter.motor.shootertwo");
        rightFeederMotorDeviceNumber =
                getIntPropertyValue("shooter.motor.feedertwo");
        shooterActuatorSolenoidInfo =
                getStringArrayPropertyValue("shooter.solenoid.actuator");
    }

    public int getClimberMotorOneNumber() {
        return climberMotorOneNumber;
    }

    public int getClimberMotorTwoNumber() {
        return climberMotorTwoNumber;
    }

    public int getLeftShooterMotorDeviceNumber() {
        return leftShooterMotorDeviceNumber;
    }

    public int getLeftFeederMotorDeviceNumber() {
        return leftFeederMotorDeviceNumber;
    }

    public int getShooterAgitatorMotorDeviceNumber() {
        return shooterAgitatorMotorDeviceNumber;
    }

    public String[] getDriveShiftersSolenoidInfo() {
        return driveShiftersSolenoidInfo;
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

    public String[] getHopperSolenoidInfo() {
        return hopperSolenoidInfo;
    }

    public String[] getGearIntakeSolenoidNumber() {
        return gearIntakeSolenoidInfo;
    }

    public int getRightShooterMotorDeviceNumber() {
        return rightShooterMotorDeviceNumber;
    }

    public int getRightFeederMotorDeviceNumber() {
        return rightFeederMotorDeviceNumber;
    }

    public String[] getShooterActuatorSolenoidInfo() {
        return shooterActuatorSolenoidInfo;
    }
}
