package org.usfirst.frc.team2175.driverstation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.usfirst.frc.team2175.TestBase;

public class DriverStationTest extends TestBase {

    @Test
    public void testSquareInput_PositiveValue() {
        final double expected = 0.1;
        final double actual = DriverStation.squareRootInput(.01);
        assertEquals(expected, actual, ALLOWED_DOUBLE_DELTA);
    }

    @Test
    public void testSquareInput_NegativeValue() {
        final double expected = -0.1;
        final double actual = DriverStation.squareRootInput(-.01);
        assertEquals(expected, actual, ALLOWED_DOUBLE_DELTA);
    }

    @Test
    public void testSquareInput_Zero() {
        final double expected = 0;
        final double actual = DriverStation.squareRootInput(0);
        assertEquals(expected, actual, ALLOWED_DOUBLE_DELTA);
    }

}
