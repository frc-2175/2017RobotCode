package org.usfirst.frc.team2175.autonrecorder;

import java.util.ArrayList;

import org.usfirst.frc.team2175.ServiceLocator;

public class AutonRecorder {
    private ArrayList<Object> recorderList;

    public AutonRecorder() {
        recorderList = new ArrayList();
        ServiceLocator.register(this);
    }

    public void record(Object c) {
        recorderList.add(c);
    }

    public void record(String s) {
        recorderList.add(s);
    }

    public void printRecord() {
        for (Object c : recorderList) {
            System.out.println(c.toString());
        }
    }
}
