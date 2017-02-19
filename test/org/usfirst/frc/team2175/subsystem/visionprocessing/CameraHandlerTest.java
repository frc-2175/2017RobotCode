package org.usfirst.frc.team2175.subsystem.visionprocessing;

import org.junit.Ignore;
import org.junit.Test;
import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.TestBase;

public class CameraHandlerTest extends TestBase {
    // @Mocked
    // private UsbCamera usbCamera;
    //
    // @Mocked
    // private CameraServer cameraServer;
    //
    // @Mocked
    // private Mat mat;
    //
    // @Mocked
    // private CvSink cvSink;

    // @Tested
    // private CameraHandler sutMocked;

    @Ignore
    @Test
    public void testGoToNextCamera() {
        // sutMocked.goToNextCameraNumber();
        final Integer expectedCameraNumber = null;
        // assertEquals("Wrong camera number found.", expectedCameraNumber,
        // sutMocked.getCurrentCameraNumber());
    }

    // TODO Kevin: write more tests: total one current one, total one current
    // zero, total two current null

    // TODO Kevin: refactor these into parameterized test
    @Ignore
    @Test
    public void testCameraHandlerConstructor() {
        ServiceLocator.clear();
    }

    @Ignore
    @Test
    public void testIncrementCameraNumber_TotalTwoCurrentZero()
            throws Exception {
        final Integer totalCamCount = 2;
        final Integer currentCamNumber = 0;
        // final Integer actualValue = sutMocked
        // .incrementCameraNumber(currentCamNumber, totalCamCount);
        final Integer expectedValue = 1;
        // assertEquals("", expectedValue, actualValue);
    }

    @Ignore
    @Test
    public void testIncrementCameraNumber_TotalTwoCurrentOne()
            throws Exception {
        final Integer totalCamCount = 2;
        final Integer currentCamNumber = 1;
        // final Integer actualValue = sutMocked
        // .incrementCameraNumber(currentCamNumber, totalCamCount);
        final Integer expectedValue = 0;
        // assertEquals("", expectedValue, actualValue);
    }

    @Ignore
    @Test
    public void testIncrementCameraNumber_TotalOneCurrentNull()
            throws Exception {
        final Integer totalCamCount = 1;
        final Integer currentCamNumber = null;
        // final Integer actualValue = sutMocked
        // .incrementCameraNumber(currentCamNumber, totalCamCount);
        final Integer expectedValue = null;
        // assertEquals("", expectedValue, actualValue);
    }

    @Ignore
    @Test
    public void testIncrementCameraNumber_TotalZeroCurrentNull()
            throws Exception {
        final Integer totalCamCount = 0;
        final Integer currentCamNumber = null;
        // final Integer actualValue = sutMocked
        // .incrementCameraNumber(currentCamNumber, totalCamCount);
        final Integer expectedValue = null;
        // assertEquals("", expectedValue, actualValue);
    }

    @Ignore
    @Test
    public void testIncrementCameraNumber_TotalZeroCurrentOne()
            throws Exception {
        final Integer totalCamCount = 0;
        final Integer currentCamNumber = 1;
        // final Integer actualValue = sutMocked
        // .incrementCameraNumber(currentCamNumber, totalCamCount);
        final Integer expectedValue = null;
        // assertEquals("", expectedValue, actualValue);
    }

    @Ignore
    @Test
    public void testIncrementCameraNumber_TotalZeroCurrentZero()
            throws Exception {
        final Integer totalCamCount = 0;
        final Integer currentCamNumber = 0;
        // final Integer actualValue = sutMocked
        // .incrementCameraNumber(currentCamNumber, totalCamCount);
        final Integer expectedValue = null;
        // assertEquals("", expectedValue, actualValue);
    }
}
