package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.pid.GyroTurnPIDController;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class TurnDegreesWithGyroCommand extends Command {

    private DrivetrainSubsystem drivetrainSubsystem;
    private GyroTurnPIDController controller = new GyroTurnPIDController();

    private double setpoint;

    public TurnDegreesWithGyroCommand(final double setpoint) {
        this.setpoint = setpoint;

        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        requires(drivetrainSubsystem);
    }

    @Override
    protected void initialize() {
        super.initialize();

        drivetrainSubsystem.resetGyro();
        controller.setSetpoint(setpoint);
        controller.enable();
    }

    @Override
    protected void execute() {
        // TODO Make as a instance
        if (Math.abs(controller.getError()) > 10) {
            controller.clearTotalIntegral();
        }
    }

    @Override
    protected boolean isFinished() {
        return controller.onTarget();
    }

    @Override
    protected void end() {
        super.end();

        controller.disable();
    }

}