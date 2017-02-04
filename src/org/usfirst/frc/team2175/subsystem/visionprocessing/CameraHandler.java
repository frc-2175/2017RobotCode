package org.usfirst.frc.team2175.subsystem.visionprocessing;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team2175.ServiceLocator;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class CameraHandler {
	private final static int height = 480;
	private final static int width = 640;
	private int currentCameraNumber;
	private int totalCameraCount;
	
	private CvSource outputStream;
	private UsbCamera[] camera;
	private CvSink[] cvSink;
    
    private Mat source;
    private Mat output;
    
    

    public CameraHandler() {
    	totalCameraCount = getTotalCameraCount();
    	
    	for (int c = 0; c < totalCameraCount; c++) {
    		camera[c] = new UsbCamera("Camera " + c, c);
    		camera[c].setResolution(width,  height);
    		
    		cvSink[c] = CameraServer.getInstance().getVideo(camera[c]);    		
    	}
    	
    	
    	outputStream = CameraServer.getInstance().putVideo("CameraOfChoice", width, height);

        source = new Mat();
        output = new Mat();
        ServiceLocator.register(this);
    }

    public void run() {
        while (!Thread.interrupted()) {
            cvSink[currentCameraNumber].grabFrame(source);
            Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
            outputStream.putFrame(source);
        }
    }

    public synchronized int getCurrentCameraNumber() {
        return currentCameraNumber;
    }

    public synchronized void setCurrentCameraNumber(int newCameraNumber) {
        currentCameraNumber = newCameraNumber;
    }

    public synchronized void goToNextCameraNumber() {
        setCurrentCameraNumber((determineNextCameraNumber(getCurrentCameraNumber()) + 1));
    }

    public int determineNextCameraNumber(int currentCameraNumber) {
        return currentCameraNumber++ % getTotalCameraCount();
    }
    public int getTotalCameraCount() {
    	return UsbCamera.enumerateUsbCameras().length;
    }

}
