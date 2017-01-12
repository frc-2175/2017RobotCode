package org.usfirst.frc.team2175.properties;

public class WiringProperties extends BaseProperties {

    private int driveLeftMotorDeviceNumber;
    private int driveRightMotorDeviceNumber;

    @Override
    protected String getPropertyFileName() {
        return "wiring.properties";
    }

    @Override
    protected void populate() {
        driveLeftMotorDeviceNumber = getIntPropertyValue("drivetrain.can.left");
        driveRightMotorDeviceNumber =
                getIntPropertyValue("drivetrain.can.right");
    }

    public int getDriveLeftMotorDeviceNumber() {
        return driveLeftMotorDeviceNumber;
    }

    public int getDriveRightMotorDeviceNumber() {
        return driveRightMotorDeviceNumber;
    }

}
