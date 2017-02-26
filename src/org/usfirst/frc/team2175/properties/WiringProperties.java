package org.usfirst.frc.team2175.properties;

public class WiringProperties extends BaseProperties {

    private MotorInfo leftMasterMotorInfo;
    private MotorInfo rightMasterMotorInfo;
    private MotorInfo leftSlaveMotorOneInfo;
    private MotorInfo leftSlaveMotorTwoInfo;
    private MotorInfo rightSlaveMotorOneInfo;
    private MotorInfo rightSlaveMotorTwoInfo;
    private SolenoidInfo driveShiftersSolenoidInfo;

    private MotorInfo leftGearIntakeMotorInfo;
    private MotorInfo rightGearIntakeMotorInfo;
    private SolenoidInfo gearIntakeSolenoidInfo;

    private MotorInfo fuelIntakeMainMotorInfo;
    private SolenoidInfo hopperSolenoidInfo;

    private MotorInfo leftShooterMotorInfo;
    private MotorInfo leftFeederMotorInfo;
    private MotorInfo shooterAgitatorMotorInfo;
    private MotorInfo rightShooterMotorInfo;
    private MotorInfo rightFeederMotorInfo;
    private SolenoidInfo shooterActuatorSolenoidInfo;

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

    public static class SolenoidInfo {
        public final String type;
        public int[] ports = new int[2];

        private SolenoidInfo(final String type, final int[] ports) {
            this.type = type;
            this.ports = ports;
        }

    }

    @Override
    protected void populate() {
        driveShiftersSolenoidInfo = solenoidInfoFromPropertyValue(
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
                solenoidInfoFromPropertyValue("gearintake.solenoid");

        fuelIntakeMainMotorInfo =
                motorInfoFromPropertyValue("fuelintake.motor.main");

        hopperSolenoidInfo = solenoidInfoFromPropertyValue("hopper.solenoid");

        leftShooterMotorInfo = motorInfoFromPropertyValue("shooter.motor.left");
        leftFeederMotorInfo = motorInfoFromPropertyValue("shooter.motor.left");
        shooterAgitatorMotorInfo =
                motorInfoFromPropertyValue("shooter.motor.agitator");

        drivetrainAnalogGyroDeviceNumber =
                getIntPropertyValue("drivetrain.analog.gyro");

        climberMotorOneInfo = motorInfoFromPropertyValue("climber.motor.one");
        climberMotorTwoInfo = motorInfoFromPropertyValue("climber.motor.two");

        rightShooterMotorInfo =
                motorInfoFromPropertyValue("shooter.motor.right");
        rightFeederMotorInfo =
                motorInfoFromPropertyValue("shooter.motor.right");
        shooterActuatorSolenoidInfo =
                solenoidInfoFromPropertyValue("shooter.solenoid.actuator");
    }

    protected MotorInfo motorInfoFromPropertyValue(final String propertyName) {
        final String[] info = getStringArrayPropertyValue(propertyName);
        return new MotorInfo(getDeviceNumber(info), getIsInverted(info));
    }

    protected SolenoidInfo solenoidInfoFromPropertyValue(
            final String propertyName) {
        final String[] info = getStringArrayPropertyValue(propertyName);

        return new SolenoidInfo(info[0], getPorts(info));
    }

    public int[] getPorts(final String[] info) {
        final int[] returnedPorts = new int[2];
        returnedPorts[0] = Integer.parseInt(info[1]);
        if (info.length > 2) {
            returnedPorts[1] = Integer.parseInt(info[2]);
        }
        return returnedPorts;
    }

    public int getDeviceNumber(final String[] info) {
        return Integer.parseInt(info[0]);
    }

    public boolean getIsInverted(final String[] info) {
        return Boolean.parseBoolean(info[1]);
    }

    public SolenoidInfo getDriveShiftersSolenoidInfo() {
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

    public SolenoidInfo getGearIntakeSolenoidInfo() {
        return gearIntakeSolenoidInfo;
    }

    public MotorInfo getFuelIntakeMainMotorInfo() {
        return fuelIntakeMainMotorInfo;
    }

    public SolenoidInfo getHopperSolenoidInfo() {
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

    public SolenoidInfo getShooterActuatorSolenoidInfo() {
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
