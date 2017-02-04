package visionprocessing;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.usfirst.frc.team2175.TestBase;
import org.usfirst.frc.team2175.subsystem.visionprocessing.CameraHandler;

public class CameraHandlerTest extends TestBase {
    @Ignore("needs cscore lib, fix this")
    @Test
    public void testDetermineNextCameraNumber() {
        CameraHandler sut = new CameraHandler();
        int cameraNumber = sut.determineNextCameraNumber();
        int expectedCameraNumber = 0;
        assertEquals("Wrong camera number found.", expectedCameraNumber,
                cameraNumber);
    }
}
