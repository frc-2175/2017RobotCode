package org.usfirst.frc.team2175.subsystem.visionprocessing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.opencv.core.Mat;
import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.TestBase;

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
    private CameraHandler sutMocked;

    @Test
    public void testGoToNextCamera() {
        sutMocked.goToNextCameraNumber();
        final Integer expectedCameraNumber = null;
        assertEquals("Wrong camera number found.", expectedCameraNumber,
                sutMocked.getCurrentCameraNumber());
    }

    // total one current one, total one current zero, total two current null
    // TODO jeffjensen: refactor these into parameterized test

    @Test
    public void testCameraHandlerConstructor() {
        ServiceLocator.clear();
        new CameraHandler();
    }

    @Test
    public void testIncrementCameraNumber_TotalTwoCurrentZero()
            throws Exception {
        final Integer totalCamCount = 2;
        final Integer currentCamNumber = 0;
        final Integer actualValue = sutMocked
                .incrementCameraNumber(currentCamNumber, totalCamCount);
        final Integer expectedValue = 1;
        assertEquals("", expectedValue, actualValue);
    }

    @Test
    public void testIncrementCameraNumber_TotalTwoCurrentOne()
            throws Exception {
        final Integer totalCamCount = 2;
        final Integer currentCamNumber = 1;
        final Integer actualValue = sutMocked
                .incrementCameraNumber(currentCamNumber, totalCamCount);
        final Integer expectedValue = 0;
        assertEquals("", expectedValue, actualValue);
    }

    @Test
    public void testIncrementCameraNumber_TotalOneCurrentNull()
            throws Exception {
        final Integer totalCamCount = 1;
        final Integer currentCamNumber = null;
        final Integer actualValue = sutMocked
                .incrementCameraNumber(currentCamNumber, totalCamCount);
        final Integer expectedValue = null;
        assertEquals("", expectedValue, actualValue);
    }

    @Test
    public void testIncrementCameraNumber_TotalZeroCurrentNull()
            throws Exception {
        final Integer totalCamCount = 0;
        final Integer currentCamNumber = null;
        final Integer actualValue = sutMocked
                .incrementCameraNumber(currentCamNumber, totalCamCount);
        final Integer expectedValue = null;
        assertEquals("", expectedValue, actualValue);
    }

    @Test
    public void testIncrementCameraNumber_TotalZeroCurrentOne()
            throws Exception {
        final Integer totalCamCount = 0;
        final Integer currentCamNumber = 1;
        final Integer actualValue = sutMocked
                .incrementCameraNumber(currentCamNumber, totalCamCount);
        final Integer expectedValue = null;
        assertEquals("", expectedValue, actualValue);
    }

    @Test
    public void testIncrementCameraNumber_TotalZeroCurrentZero()
            throws Exception {
        final Integer totalCamCount = 0;
        final Integer currentCamNumber = 0;
        final Integer actualValue = sutMocked
                .incrementCameraNumber(currentCamNumber, totalCamCount);
        final Integer expectedValue = null;
        assertEquals("", expectedValue, actualValue);
    }
}
