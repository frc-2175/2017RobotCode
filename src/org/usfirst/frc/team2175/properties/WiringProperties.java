package org.usfirst.frc.team2175.properties;

public class WiringProperties extends BaseProperties {

    private int driveLeftMotorDeviceNumber;
    private int driveRightMotorDeviceNumber;
    private int driveShiftersSolenoidNumber;
    private int leftGearIntakeMotorDeviceNumber;
    private int rightGearIntakeMotorDeviceNumber;

    @Override
    protected String getPropertyFileName() {
        return "wiring.properties";
    }

    @Override
    protected void populate() {
        driveLeftMotorDeviceNumber = getIntPropertyValue("drivetrain.can.left");
        driveRightMotorDeviceNumber =
                getIntPropertyValue("drivetrain.can.right");
        driveShiftersSolenoidNumber =
                getIntPropertyValue("drivetrain.solenoid.driveshifters");
        leftGearIntakeMotorDeviceNumber =
                getIntPropertyValue("gearintake.can.left");
        rightGearIntakeMotorDeviceNumber =
                getIntPropertyValue("gearintake.can.right");

    }

    public int getDriveLeftMotorDeviceNumber() {
        return driveLeftMotorDeviceNumber;
    }

    public int getDriveRightMotorDeviceNumber() {
        return driveRightMotorDeviceNumber;
    }

    public int getDriveShiftersSolenoidNumber() {
        return driveShiftersSolenoidNumber;
    }

    public int getLeftGearIntakeDeviceNumber() {
        return leftGearIntakeMotorDeviceNumber;
    }

    public int getRightGearIntakeDeviceNumber() {
        return rightGearIntakeMotorDeviceNumber;
    }
}
