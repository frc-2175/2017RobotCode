package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.pid.GyroTurnPIDController;
import org.usfirst.frc.team2175.subsystem.drivetrain.DrivetrainSubsystem;

public class TurnDegreesWithGyroCommand extends BaseCommand {

    private DrivetrainSubsystem drivetrainSubsystem;
    private GyroTurnPIDController controller = new GyroTurnPIDController();

    private double setpoint;

    public TurnDegreesWithGyroCommand(final double setpoint,
            final boolean shouldRequireDrivetrain) {
        this.setpoint = setpoint;

        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        if (shouldRequireDrivetrain) {
            requires(drivetrainSubsystem);
        }
    }

    public TurnDegreesWithGyroCommand(final double setpoint) {
        this(setpoint, true);
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
