package org.usfirst.frc.team2175.properties;

public class WiringProperties extends BaseProperties {

    private MotorInfo leftMasterMotorInfo;
    private MotorInfo rightMasterMotorInfo;
    private MotorInfo leftSlaveMotorOneInfo;
    private MotorInfo leftSlaveMotorTwoInfo;
    private MotorInfo rightSlaveMotorOneInfo;
    private MotorInfo rightSlaveMotorTwoInfo;
    private String[] driveShiftersSolenoidInfo;

    private MotorInfo leftGearIntakeMotorInfo;
    private MotorInfo rightGearIntakeMotorInfo;
    private String[] gearIntakeSolenoidInfo;

    private MotorInfo fuelIntakeMainMotorInfo;
    private String[] hopperSolenoidInfo;

    private MotorInfo leftShooterMotorInfo;
    private MotorInfo leftFeederMotorInfo;
    private MotorInfo shooterAgitatorMotorInfo;
    private MotorInfo rightShooterMotorInfo;
    private MotorInfo rightFeederMotorInfo;
    private String[] shooterActuatorSolenoidInfo;

    private int drivetrainAnalogGyroDeviceNumber;

    private MotorInfo climberMotorOneInfo;
    private MotorInfo climberMotorTwoInfo;

    @Override
    protected String getPropertyFileName() {
        return "wiring.properties";
    }

    public static class MotorInfo {
        public final int deviceNumber;
        public final boolean isInverted;

        private MotorInfo(final int deviceNumber, final boolean isInverted) {
            this.deviceNumber = deviceNumber;
            this.isInverted = isInverted;
        }
    }

    @Override
    protected void populate() {
        driveShiftersSolenoidInfo = getStringArrayPropertyValue(
                "drivetrain.solenoid.driveshifters");

        leftMasterMotorInfo =
                motorInfoFromPropertyValue("drivetrain.motor.left.master");
        leftSlaveMotorOneInfo =
                motorInfoFromPropertyValue("drivetrain.motor.left.slaveone");
        leftSlaveMotorTwoInfo =
                motorInfoFromPropertyValue("drivetrain.motor.left.slavetwo");

        rightMasterMotorInfo =
                motorInfoFromPropertyValue("drivetrain.motor.right.master");
        rightSlaveMotorOneInfo =
                motorInfoFromPropertyValue("drivetrain.motor.right.slaveone");
        rightSlaveMotorTwoInfo =
                motorInfoFromPropertyValue("drivetrain.motor.right.slavetwo");

        leftGearIntakeMotorInfo =
                motorInfoFromPropertyValue("gearintake.motor.left");
        rightGearIntakeMotorInfo =
                motorInfoFromPropertyValue("gearintake.motor.right");
        gearIntakeSolenoidInfo =
                getStringArrayPropertyValue("gearintake.solenoid");
        fuelIntakeMainMotorInfo =
                motorInfoFromPropertyValue("fuelintake.motor.main");

        hopperSolenoidInfo = getStringArrayPropertyValue("hopper.solenoid");

        leftShooterMotorInfo =
                motorInfoFromPropertyValue("shooter.motor.shooter");
        leftFeederMotorInfo =
                motorInfoFromPropertyValue("shooter.motor.feeder");
        shooterAgitatorMotorInfo =
                motorInfoFromPropertyValue("shooter.motor.agitator");

        drivetrainAnalogGyroDeviceNumber =
                getIntPropertyValue("drivetrain.analog.gyro");

        climberMotorOneInfo = motorInfoFromPropertyValue("climber.motor.one");
        climberMotorTwoInfo = motorInfoFromPropertyValue("climber.motor.two");

        rightShooterMotorInfo =
                motorInfoFromPropertyValue("shooter.motor.shootertwo");
        rightFeederMotorInfo =
                motorInfoFromPropertyValue("shooter.motor.feedertwo");
        shooterActuatorSolenoidInfo =
                getStringArrayPropertyValue("shooter.solenoid.actuator");
    }

    protected MotorInfo motorInfoFromPropertyValue(final String propertyName) {
        final String[] info = getStringArrayPropertyValue(propertyName);
        return new MotorInfo(getDeviceNumber(info), getIsInverted(info));
    }

    public int getDeviceNumber(final String[] info) {
        return Integer.parseInt(info[0]);
    }

    public boolean getIsInverted(final String[] info) {
        return Boolean.parseBoolean(info[1]);
    }

    public String[] getDriveShiftersSolenoidInfo() {
        return driveShiftersSolenoidInfo;
    }

    public MotorInfo getLeftMasterMotorInfo() {
        return leftMasterMotorInfo;
    }

    public MotorInfo getRightMasterMotorInfo() {
        return rightMasterMotorInfo;
    }

    public MotorInfo getLeftSlaveMotorOneInfo() {
        return leftSlaveMotorOneInfo;
    }

    public MotorInfo getLeftSlaveMotorTwoInfo() {
        return leftSlaveMotorTwoInfo;
    }

    public MotorInfo getRightSlaveMotorOneInfo() {
        return rightSlaveMotorOneInfo;
    }

    public MotorInfo getRightSlaveMotorTwoInfo() {
        return rightSlaveMotorTwoInfo;
    }

    public MotorInfo getLeftGearIntakeMotorInfo() {
        return leftGearIntakeMotorInfo;
    }

    public MotorInfo getRightGearIntakeMotorInfo() {
        return rightGearIntakeMotorInfo;
    }

    public String[] getGearIntakeSolenoidInfo() {
        return gearIntakeSolenoidInfo;
    }

    public MotorInfo getFuelIntakeMainMotorInfo() {
        return fuelIntakeMainMotorInfo;
    }

    public String[] getHopperSolenoidInfo() {
        return hopperSolenoidInfo;
    }

    public MotorInfo getLeftShooterMotorInfo() {
        return leftShooterMotorInfo;
    }

    public MotorInfo getLeftFeederMotorInfo() {
        return leftFeederMotorInfo;
    }

    public MotorInfo getShooterAgitatorMotorInfo() {
        return shooterAgitatorMotorInfo;
    }

    public MotorInfo getRightShooterMotorInfo() {
        return rightShooterMotorInfo;
    }

    public MotorInfo getRightFeederMotorInfo() {
        return rightFeederMotorInfo;
    }

    public String[] getShooterActuatorSolenoidInfo() {
        return shooterActuatorSolenoidInfo;
    }

    public int getDrivetrainAnalogGyroDeviceNumber() {
        return drivetrainAnalogGyroDeviceNumber;
    }

    public MotorInfo getClimberMotorOneInfo() {
        return climberMotorOneInfo;
    }

    public MotorInfo getClimberMotorTwoInfo() {
        return climberMotorTwoInfo;
    }

}
