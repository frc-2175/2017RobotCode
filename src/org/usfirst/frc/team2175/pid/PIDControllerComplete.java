package org.usfirst.frc.team2175.pid;

import java.util.logging.Logger;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public abstract class PIDControllerComplete extends PIDController
        implements PIDSource, PIDOutput {

    private final Logger log = Logger.getLogger(getClass().getName());

    // This and the pidSourceType methods below exist just to make Eclipse
    // shut up.
    private PIDSourceType pidSourceType = PIDSourceType.kDisplacement;

    private static final PIDSource TEMPORARY_SOURCE = new PIDSource() {
        @Override
        public double pidGet() {
            return 0;
        }

        @Override
        public void setPIDSourceType(final PIDSourceType pidSource) {
        }

        @Override
        public PIDSourceType getPIDSourceType() {
            return PIDSourceType.kDisplacement;
        }
    };

    private static final PIDOutput TEMPORARY_OUTPUT = output -> {
    };

    /**
     * How often, in seconds, the PID controller will update when enabled.
     * Hardcoded because there's no reason to configure this in a properties
     * file.
     */
    private static final double PID_PERIOD = 0.01;

    public PIDControllerComplete() {
        this(0, 0, 0, 0);
    }

    public PIDControllerComplete(final double Kp, final double Ki,
            final double Kd, final double Kf) {
        super(Kp, Ki, Kd, Kf, TEMPORARY_SOURCE, TEMPORARY_OUTPUT, PID_PERIOD);
        this.m_pidInput = this;
        this.m_pidOutput = this;
    }

    @Override
    public void enable() {
        super.enable();
        log.info("Enabled PID Controller: " + getClass().getName());
    }

    @Override
    public void disable() {
        super.disable();
        log.info("Disabled PID Controller: " + getClass().getName());
    }

    @Override
    @SuppressWarnings("all")
    public void setPIDSourceType(final PIDSourceType pidSource) {
        this.pidSourceType = pidSource;
    }

    @Override
    @SuppressWarnings("all")
    public PIDSourceType getPIDSourceType() {
        return pidSourceType;
    }

}
