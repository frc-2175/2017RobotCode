package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.visionprocessing.CameraHandler;

public class CameraSwitchCommand extends BaseCommand {

    // TODO 4thwind: The logic of this class weirdly seems to assume a
    // two-camera robot. Switching to the next camera on both start and release
    // makes sense when you only have two cameras, but what if we had three?
    //
    // I realize, though, that we probably won't have three cameras on our
    // robot. But it's worth considering that maybe we should add some better
    // methods in CameraHandler like 'switchToFrontCamera' and
    // 'switchToRearCamera'.

    private CameraHandler cameraHandler;

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
        return false;
    }

    @Override
    protected void end() {
        cameraHandler.goToNextCameraNumber();
    }

}
