package org.usfirst.frc.team2175.subsystem.visionprocessing;

import java.util.ArrayList;

import org.opencv.core.MatOfPoint;
import org.usfirst.frc.team2175.subsystem.BaseSubsystem;

import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionRunner;
import edu.wpi.first.wpilibj.vision.VisionThread;

public class VisionSubsystem extends BaseSubsystem
        implements VisionRunner.Listener<GripPipeline> {

    private CvSource output;

    private double[] contourArea;
    private double[] contourCenterX;
    private double[] contourCenterY;
    private double[] contourHeight;
    private double[] contourWidth;
    private double[] contourSolidity;
    private double[] defaultValue;

    public VisionSubsystem() {
        // CameraServer.getInstance().startAutomaticCapture();
        final UsbCamera camera = new UsbCamera("GearCam", 0);
        camera.setExposureManual(10);
        final GripPipeline gripPipeline = new GripPipeline();

        final VisionThread visionThread =
                new VisionThread(camera, gripPipeline, this);
        visionThread.start();

        output = CameraServer.getInstance().putVideo("Pipeline Output", 640,
                480);
    }

    @Override
    public void copyPipelineOutputs(final GripPipeline pipeline) {
        output.putFrame(pipeline.hsvThresholdOutput());

        final ArrayList<MatOfPoint> contours = pipeline.filterContoursOutput();
        SmartDashboard.putNumber("Contour Count", contours.size());
    }

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
        distanceFromTape = 0;
        return distanceFromTape;
    }

}
