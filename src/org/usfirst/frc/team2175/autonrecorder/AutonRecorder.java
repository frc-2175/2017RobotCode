package org.usfirst.frc.team2175.autonrecorder;

import java.util.ArrayList;

import org.usfirst.frc.team2175.ServiceLocator;

// TODO Kevin: Let's just remove this...
public class AutonRecorder {
    private ArrayList<Object> recorderList;

    public AutonRecorder() {
        recorderList = new ArrayList();
        ServiceLocator.register(this);
    }

    public void record(final Object c) {
        recorderList.add(c);
    }

    public void record(final String s) {
        recorderList.add(s);
    }

    public void printRecord() {
        for (final Object c : recorderList) {
            System.out.println(c.toString());
        }
    }
}
