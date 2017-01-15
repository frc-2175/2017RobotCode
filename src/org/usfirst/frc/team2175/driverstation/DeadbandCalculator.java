package org.usfirst.frc.team2175.driverstation;

/**
 * This is a simple class for calculating a new control curve with a "deadband"
 * around zero. This is especially useful with joysticks (to eliminate
 * insignificant values near the base position), but could theoretically be used
 * with any input method.
 *
 * @author Max Haland
 *
 */

public class DeadbandCalculator {

    /**
     * This method used the other methods within DeadbandCalculator to actually
     * provide the desired output values. The values are calculated according to
     * the new control curve defined by the size of the deadband.
     *
     * @param input
     *            Input to deadband
     * @param deadbandSize
     *            Size of the deadband (between zero and one)
     *
     * @return Returns a value based off of the newly defined control curve
     *         properties.
     */
    public double calcDeadbandedOutput(double input, double deadbandSize) {
        double output;

        if (isAboveThreshold(input, deadbandSize)) {
            double slope = calcLinearOutputSlope(deadbandSize);
            output = calcLinearOutput(input, slope);
        } else {
            output = 0;
        }

        return output;
    }

    /**
     * Determine whether some value is above a given threshold.
     *
     * @param input
     *            Value to use
     * @param threshold
     *            Threshold to compare against
     * @return boolean representing the truthiness of the comparison
     */
    public boolean isAboveThreshold(double input, double threshold) {
        return Math.abs(input) >= threshold;
    }

    /**
     * Calculates the slope of the linear portion of the output.
     *
     * @param deadbandSize
     * @return
     */
    public double calcLinearOutputSlope(double deadbandSize) {
        double rise = 1;
        double run = 1 - deadbandSize;
        return rise / run;
    }

    /**
     * Uses the point-slope form of a line to calculate the adjusted joystick
     * output.
     *
     * @param input
     *            The joystick input to process.
     * @param slope
     *            The slope of the linear portion of the output
     * @return The output value, according to the appropriate line. May return
     *         negative even if the input was positive due to how the line
     *         equation works.
     */
    public double calcLinearOutput(double input, double slope) {
        double pointX;
        double pointY;
        if (input < 0) {
            pointX = -1;
            pointY = -1;
        } else {
            pointX = 1;
            pointY = 1;
        }

        return pointY + slope * (input - pointX);
    }
}
