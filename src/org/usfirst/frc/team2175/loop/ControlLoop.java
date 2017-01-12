package org.usfirst.frc.team2175.loop;

import java.util.Timer;
import java.util.TimerTask;

public abstract class ControlLoop {

    private final Timer loopTimer;

    public ControlLoop() {
        this.loopTimer = new Timer();
    }

    /**
     * @return The period, in milliseconds, of the control loop.
     */
    protected abstract long getPeriodMs();

    /**
     * Performs the action of the control loop.
     */
    protected abstract void runTask();

    public void start() {
        loopTimer.schedule(new ControlLoopTask(), 0, getPeriodMs());
    }

    private class ControlLoopTask extends TimerTask {
        @Override
        public void run() {
            runTask();
        }
    }

}
