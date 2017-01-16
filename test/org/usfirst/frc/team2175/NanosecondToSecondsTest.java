package org.usfirst.frc.team2175;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.usfirst.frc.team2175.autonrecorder.AutonRecorder;

public class NanosecondToSecondsTest {

    @Test
    public void nanosecondToSecondTest() {
        double secondsValue =
                AutonRecorder.convertFromNanosecondsToSeconds(4000000000.0);
        assertEquals(4, secondsValue, 0.00001);

    }
}
