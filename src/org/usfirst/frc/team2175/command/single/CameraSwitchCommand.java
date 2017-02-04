package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.visionprocessing.CameraHandler;

public class CameraSwitchCommand extends BaseCommand {
    CameraHandler cameraHandler;

    public CameraSwitchCommand() {
        cameraHandler = ServiceLocator.get(CameraHandler.class);
    }

    @Override
    protected void initialize() {
        cameraHandler.goToNextCameraNumber();
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        cameraHandler.goToNextCameraNumber();
    }
}
