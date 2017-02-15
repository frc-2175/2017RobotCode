package org.usfirst.frc.team2175.subsystem.visionprocessing;

import edu.wpi.first.wpilibj.CameraServer;

public class CameraHandler {
    public CameraHandler() {
        CameraServer.getInstance().startAutomaticCapture();
    }
}