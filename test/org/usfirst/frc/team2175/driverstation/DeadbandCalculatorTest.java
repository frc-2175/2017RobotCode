package org.usfirst.frc.team2175.driverstation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.usfirst.frc.team2175.TestBase;

public class DeadbandCalculatorTest extends TestBase {

    @Test
    public void testCalcLinearOutputSlope() {
        final DeadbandCalculator sut = new DeadbandCalculator();
        final double EXPECTED_OUTPUT_VALUE = 2;
        final double INPUT_DEADBAND_SIZE = 0.5;
        final double realValue = sut.calcLinearOutputSlope(INPUT_DEADBAND_SIZE);
        final String msg = "";
        assertEquals(EXPECTED_OUTPUT_VALUE, realValue, 0);
    }

    @Test
    public void testCalcLinearOutput() {
        /* Write this */
    }

    @Test
    public void testCalcDeadbandedOutput() {
        /* Write this */
    }
}
