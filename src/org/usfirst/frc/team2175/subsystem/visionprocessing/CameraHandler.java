package org.usfirst.frc.team2175.subsystem.visionprocessing;

import org.opencv.core.Mat;
import org.usfirst.frc.team2175.ServiceLocator;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class CameraHandler {
    private UsbCamera camera1;
    private UsbCamera camera2;
    private CvSink cvSink1;
    private CvSink cvSink2;
    private CvSource outputStream;
    private Mat source;
    private Mat output;
    private int currentCameraNumber;

    public CameraHandler() {
        camera1 = new UsbCamera("Camera 1", 0);
        camera2 = new UsbCamera("Camera 2", 1);

        camera1.setResolution(640, 480);
        camera2.setResolution(640, 480);

        cvSink1 = CameraServer.getInstance().getVideo(camera1);
        cvSink2 = CameraServer.getInstance().getVideo(camera2);
        outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);

        source = new Mat();
        output = new Mat();
        ServiceLocator.register(this);
    }

    public void run() {
        while (!Thread.interrupted()) {
            if (currentCameraNumber == 0) {
                cvSink2.grabFrame(source);
            } else {
                cvSink1.grabFrame(source);
            }
            outputStream.putFrame(source);
        }
    }

    public int getCurrentCameraNumber() {
        return currentCameraNumber;
    }

    public void setCurrentCameraNumber(int newCameraNumber) {
        currentCameraNumber = newCameraNumber;
    }

    public void goToNextCameraNumber() {
        currentCameraNumber++;
    }

    public int determineNextCameraNumber() {
        return 0;
    }

}
