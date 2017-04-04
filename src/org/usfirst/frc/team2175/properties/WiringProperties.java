package org.usfirst.frc.team2175.properties;

public class WiringProperties extends BaseProperties {

    private MotorInfo leftMasterMotorInfo;
    private MotorInfo rightMasterMotorInfo;
    private MotorInfo leftSlaveMotorOneInfo;
    private MotorInfo leftSlaveMotorTwoInfo;
    private MotorInfo rightSlaveMotorOneInfo;
    private MotorInfo rightSlaveMotorTwoInfo;
    private SolenoidInfo driveShiftersSolenoidInfo;

    private MotorInfo gearIntakeMotorInfo;
    private SolenoidInfo gearIntakeSolenoidInfo;

    private MotorInfo fuelIntakeMainMotorInfo;
    private SolenoidInfo hopperSolenoidInfo;

    private MotorInfo shooterMotorInfo;
    private MotorInfo feederMotorInfo;
    private MotorInfo augerMotorInfo;
    private MotorInfo shooterAgitatorMotorInfo;
    private SolenoidInfo shooterActuatorSolenoidInfo;

    private int drivetrainAnalogGyroDeviceNumber;
    private EncoderInfo leftEncoderInfo;
    private EncoderInfo rightEncoderInfo;

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

    public static class EncoderInfo {
        public final int sourceA;
        public final int sourceB;
        public final boolean isInverted;

        private EncoderInfo(final int sourceA, final int sourceB,
                final boolean isInverted) {
            this.sourceA = sourceA;
            this.sourceB = sourceB;
            this.isInverted = isInverted;
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

        gearIntakeMotorInfo = motorInfoFromPropertyValue("gearintake.motor");
        gearIntakeSolenoidInfo =
                solenoidInfoFromPropertyValue("gearintake.solenoid");

        fuelIntakeMainMotorInfo =
                motorInfoFromPropertyValue("fuelintake.motor.main");

        hopperSolenoidInfo = solenoidInfoFromPropertyValue("hopper.solenoid");

        shooterMotorInfo = motorInfoFromPropertyValue("shooter.motor");
        feederMotorInfo = motorInfoFromPropertyValue("feeder.motor");
        shooterAgitatorMotorInfo = motorInfoFromPropertyValue("agitator.motor");
        augerMotorInfo = motorInfoFromPropertyValue("auger.motor");

        drivetrainAnalogGyroDeviceNumber =
                getIntPropertyValue("drivetrain.analog.gyro");
        leftEncoderInfo =
                encoderInfoFromPropertyValue("drivetrain.digital.encoder.left");
        rightEncoderInfo = encoderInfoFromPropertyValue(
                "drivetrain.digital.encoder.right");

        climberMotorOneInfo = motorInfoFromPropertyValue("climber.motor.one");
        climberMotorTwoInfo = motorInfoFromPropertyValue("climber.motor.two");

        shooterActuatorSolenoidInfo =
                solenoidInfoFromPropertyValue("shooter.solenoid.actuator");
    }

    protected MotorInfo motorInfoFromPropertyValue(final String propertyName) {
        final String[] info = getStringArrayPropertyValue(propertyName);
        return new MotorInfo(getInteger(info, 0), getBoolean(info, 1));
    }

    protected SolenoidInfo solenoidInfoFromPropertyValue(
            final String propertyName) {
        final String[] info = getStringArrayPropertyValue(propertyName);

        return new SolenoidInfo(info[0], getPorts(info));
    }

    protected EncoderInfo encoderInfoFromPropertyValue(
            final String propertyName) {
        final String[] info = getStringArrayPropertyValue(propertyName);

        return new EncoderInfo(getInteger(info, 0), getInteger(info, 1),
                getBoolean(info, 2));
    }

    public int[] getPorts(final String[] info) {
        final int[] returnedPorts = new int[2];
        returnedPorts[0] = Integer.parseInt(info[1]);
        if (info.length > 2) {
            returnedPorts[1] = Integer.parseInt(info[2]);
        }
        return returnedPorts;
    }

    public int getInteger(final String[] info, final int arrayPos) {
        return Integer.parseInt(info[arrayPos]);
    }

    public boolean getBoolean(final String[] info, final int arrayPos) {
        return Boolean.parseBoolean(info[arrayPos]);
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

    public SolenoidInfo getDriveShiftersSolenoidInfo() {
        return driveShiftersSolenoidInfo;
    }

    public MotorInfo getGearIntakeMotorInfo() {
        return gearIntakeMotorInfo;
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

    public MotorInfo getShooterMotorInfo() {
        return shooterMotorInfo;
    }

    public MotorInfo getFeederMotorInfo() {
        return feederMotorInfo;
    }

    public MotorInfo getAugerMotorInfo() {
        return augerMotorInfo;
    }

    public MotorInfo getShooterAgitatorMotorInfo() {
        return shooterAgitatorMotorInfo;
    }

    public SolenoidInfo getShooterActuatorSolenoidInfo() {
        return shooterActuatorSolenoidInfo;
    }

    public int getDrivetrainAnalogGyroDeviceNumber() {
        return drivetrainAnalogGyroDeviceNumber;
    }

    public EncoderInfo getLeftEncoderInfo() {
        return leftEncoderInfo;
    }

    public EncoderInfo getRightEncoderInfo() {
        return rightEncoderInfo;
    }

    public MotorInfo getClimberMotorOneInfo() {
        return climberMotorOneInfo;
    }

    public MotorInfo getClimberMotorTwoInfo() {
        return climberMotorTwoInfo;
    }
}
