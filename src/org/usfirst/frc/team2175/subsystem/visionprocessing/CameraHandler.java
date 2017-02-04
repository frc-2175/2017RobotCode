package org.usfirst.frc.team2175.subsystem.visionprocessing;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team2175.ServiceLocator;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class CameraHandler {
    private final static int WIDTH = 200;
    private final static int HEIGHT = 120;

    private final CvSource outputStream = CameraServer.getInstance()
            .putVideo("CameraOfChoice", WIDTH, HEIGHT);

    private Mat source = new Mat();
    private Mat output = new Mat();

    private CvSink[] cvSinkList;
    private Integer currentCameraNumber;

    public CameraHandler() {
        final int totalCamCount = getTotalCameraCount();
        cvSinkList = new CvSink[totalCamCount];

        configureCameras();

        determineInitialCameraNumber();

        ServiceLocator.register(this);
    }

    protected void determineInitialCameraNumber() {
        if (getTotalCameraCount() > 0) {
            currentCameraNumber = 1;
        }
    }

    private void configureCameras() {
        for (int c = 0; c < getTotalCameraCount(); c++) {
            createSpecificCamera(c);
        }
    }

    public void createSpecificCamera(final int camNum) {
        final UsbCamera cam = makeUsbCamera(camNum);

        makeCvSink(camNum, cam);
    }

    private UsbCamera makeUsbCamera(final int camNum) {
        final UsbCamera cam = new UsbCamera("Camera " + camNum, camNum);
        cam.setResolution(WIDTH, HEIGHT);
        cam.setFPS(10);
        return cam;
    }

    private void makeCvSink(final int camNum, final UsbCamera cam) {
        cvSinkList[camNum] = CameraServer.getInstance().getVideo(cam);
    }

    public void run() {
        while (!Thread.interrupted()) {
            if (getTotalCameraCount() != 0) {
                // configureCameras();

                cvSinkList[currentCameraNumber].grabFrame(source);
                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
                outputStream.putFrame(source);
            }
        }
    }

    public synchronized Integer getCurrentCameraNumber() {
        return currentCameraNumber;
    }

    public synchronized void setCurrentCameraNumber(
            final Integer newCameraNumber) {
        currentCameraNumber = newCameraNumber;
    }

    public synchronized void goToNextCameraNumber() {
        final Integer currCamNumber = getCurrentCameraNumber();
        final int totalCamCount = getTotalCameraCount();
        final Integer nextCamNumber =
                incrementCameraNumber(currCamNumber, totalCamCount);
        setCurrentCameraNumber(nextCamNumber);
    }

    protected Integer incrementCameraNumber(final Integer currentCameraNumber,
            final int totalCameraCount) {
        if (currentCameraNumber == null || totalCameraCount <= 0) {
            return null;
        } else {
            final Integer nextCamNum = currentCameraNumber + 1;
            return nextCamNum % totalCameraCount;
        }
    }

    public int getTotalCameraCount() {
        return UsbCamera.enumerateUsbCameras().length;
    }
}
