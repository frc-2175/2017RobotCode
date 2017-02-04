package visionprocessing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.opencv.core.Mat;
import org.usfirst.frc.team2175.TestBase;
import org.usfirst.frc.team2175.subsystem.visionprocessing.CameraHandler;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import mockit.Mocked;
import mockit.Tested;

public class CameraHandlerTest extends TestBase {
    @Mocked
    private UsbCamera usbCamera;

    @Mocked
    private CameraServer cameraServer;

    @Mocked
    private Mat mat;

    @Mocked
    private CvSink cvSink;

    @Tested
    private CameraHandler sut;

    @Test
    public void testDetermineNextCameraNumber() {
        final int cameraNumber = sut.determineNextCameraNumber(0);
        final int expectedCameraNumber = 1;
        assertEquals("Wrong camera number found.", expectedCameraNumber,
                cameraNumber);
    }

    @Test
    public void testGoToNextCamera() {
        sut.goToNextCameraNumber();
        final int expectedCameraNumber = 1;
        assertEquals("Wrong camera number found.", expectedCameraNumber,
                sut.getCurrentCameraNumber());
    }
}
