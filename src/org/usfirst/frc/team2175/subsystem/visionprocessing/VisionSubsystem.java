package org.usfirst.frc.team2175.subsystem.visionprocessing;

import org.usfirst.frc.team2175.subsystem.BaseSubsystem;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionSubsystem extends BaseSubsystem {

    private NetworkTable table;
    private double[] contourArea;
    private double[] contourCenterY;
    private double[] contourHeight;
    private double[] contourWidth;
    private double[] contourSolidity;
    UsbCamera camera;

    public VisionSubsystem() {
        camera = new UsbCamera("GearCam", 0);
        CameraServer.getInstance().startAutomaticCapture(camera);
        table = NetworkTable.getTable("GRIP/myContourReport");
    }

    public double[] getContourArea() {
        return contourArea;
    }

    public double[] getContourCenterX() {
        final double[] defaultValue = { 175, 175 };
        return table.getNumberArray("centerX", defaultValue);
    }

    public double[] getContourCenterY() {
        return contourCenterY;
    }

    public double[] getContourHeight() {
        return contourHeight;
    }

    public double[] getContourWidth() {
        return contourWidth;
    }

    public double[] getContourSolidity() {
        return contourSolidity;
    }

    public double getDegreeFromPixel(final double pixel) {
        return -67.25407 + 0.39355 * pixel;
    }

    public double[] getFirstTwoCenterX() {
        final double[] contourX = getContourCenterX();
        final double[] valueToReturn = { 175, 175 };
        if (getContourCenterX().length == 2) {
            valueToReturn[0] = contourX[0];
            valueToReturn[1] = contourX[1];
        }
        return valueToReturn;
    }

    public double getCenterPegInPixels() {
        final double[] firstTwoCenterX = getFirstTwoCenterX();
        return (firstTwoCenterX[0] + firstTwoCenterX[1]) / 2;
    }

    public double getDegreesToTurnToPeg() {
        return getDegreeFromPixel(getCenterPegInPixels());
    }

    public int getNumberOfContors() {
        return getContourCenterX().length;
    }

    public void setExposureManual() {
        camera.setExposureManual(1);

    }

    public void setExposureAuto() {
        camera.setExposureAuto();
    }
}
