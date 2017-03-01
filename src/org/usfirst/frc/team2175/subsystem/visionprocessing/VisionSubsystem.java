package org.usfirst.frc.team2175.subsystem.visionprocessing;

import java.util.ArrayList;

import org.opencv.core.MatOfPoint;
import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.subsystem.BaseSubsystem;

import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionRunner;
import edu.wpi.first.wpilibj.vision.VisionThread;

public class VisionSubsystem extends BaseSubsystem
        implements VisionRunner.Listener<GripPipeline> {

    private CvSource processOutput;
    private NetworkTable table;
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
        table = NetworkTable.getTable("gearReport");
        ServiceLocator.register(this);
    }

    private void startAutomaticCapture() {
        CameraServer.getInstance().startAutomaticCapture();
    }

    private void startGripPipelineCapture() {
        final UsbCamera camera = new UsbCamera("GearCam", 0);
        camera.setExposureManual(1);
        final GripPipeline gripPipeline = new GripPipeline();

        final VisionThread visionThread =
                new VisionThread(camera, gripPipeline, this);
        visionThread.start();

        processOutput =
                CameraServer.getInstance().putVideo("Process Output", 320, 240);
    }

    @Override
    public void copyPipelineOutputs(final GripPipeline pipeline) {
        processOutput.putFrame(pipeline.hsvThresholdOutput());

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

    public double getDegreesToTurnToGear() {
        return table.getNumber("degreesToTurn", 0);
    }
}
