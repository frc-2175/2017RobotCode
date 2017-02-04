package org.usfirst.frc.team2175.subsystem.visionprocessing;

import org.usfirst.frc.team2175.subsystem.BaseSubsystem;

public class VisionSubsystem extends BaseSubsystem {
    // private final NetworkTable table;
    private double[] contourArea;
    private double[] contourCenterX;
    private double[] contourCenterY;
    private double[] contourHeight;
    private double[] contourWidth;
    private double[] contourSolidity;
    private double[] defaultValue;

    // public VisionSubsystem() {
    // table = NetworkTable.getTable("Grip/myCountoursReport");
    // }
    //
    // public void updateAllValues() {
    // synchronized (table) {
    // contourArea = table.getNumberArray("area", defaultValue);
    // contourCenterX = table.getNumberArray("centerX", defaultValue);
    // contourCenterY = table.getNumberArray("centerY", defaultValue);
    // contourHeight = table.getNumberArray("height", defaultValue);
    // contourWidth = table.getNumberArray("width", defaultValue);
    // contourSolidity = table.getNumberArray("solidity", defaultValue);
    // }
    // }

    public double[] getContourArea() {
        return contourArea;
    }

    public double[] getContourCenterX() {
        return contourCenterX;
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

    public double calculateDistanceFromRetroTape() {
        double distanceFromTape;
        // updateAllValues();
        distanceFromTape = 0;
        return distanceFromTape;
    }

}
