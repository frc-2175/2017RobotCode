package org.usfirst.frc.team2175.subsystem.visionprocessing;

import org.usfirst.frc.team2175.subsystem.BaseSubsystem;

import edu.wpi.cscore.CvSource;
import edu.wpi.first.wpilibj.CameraServer;

public class VisionSubsystem extends BaseSubsystem {

    private CvSource processOutput;
    // private NetworkTable table;
    private double[] contourArea;
    private double[] contourCenterX;
    private double[] contourCenterY;
    private double[] contourHeight;
    private double[] contourWidth;
    private double[] contourSolidity;
    private double[] defaultValue;
    private double degrees;

    public VisionSubsystem() {
        startAutomaticCapture();
        // startGripPipelineCapture();
    }

    private void startAutomaticCapture() {
        CameraServer.getInstance().startAutomaticCapture(0);
    }

    // private void startGripPipelineCapture() {
    // final UsbCamera camera = new UsbCamera("GearCam", 0);
    // camera.setExposureManual(1);
    // final GripPipeline gripPipeline = new GripPipeline();
    //
    // final VisionThread visionThread =
    // new VisionThread(camera, gripPipeline, this);
    // visionThread.start();
    //
    // processOutput =
    // CameraServer.getInstance().putVideo("Process Output", 320, 240);
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
}
