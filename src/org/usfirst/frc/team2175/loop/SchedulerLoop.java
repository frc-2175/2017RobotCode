package org.usfirst.frc.team2175.loop;

import edu.wpi.first.wpilibj.command.Scheduler;

public class SchedulerLoop extends ControlLoop {

    @Override
    protected long getPeriodMs() {
        return 10;
    }

    @Override
    protected void runTask() {
        Scheduler.getInstance().run();
    }

}
