package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.drivetrain.DrivetrainSubsystem;
import org.usfirst.frc.team2175.subsystem.drivetrain.TrapezoidalMotionProfile;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveInchesWithPercentVbusCommand extends BaseCommand {
    private DrivetrainSubsystem drivetrainSubsystem;
    private TrapezoidalMotionProfile trapezoidalMotionProfile;
    private final double inches;

    public DriveInchesWithPercentVbusCommand(final double inches) {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        // trapezoidalMotionProfile =
        ServiceLocator.get(TrapezoidalMotionProfile.class).setupDrive(inches);
        // trapezoidalMotionProfile.setupDrive(inches, .9, .15);
        this.inches = inches;
        drivetrainSubsystem.resetEncoders();
        drivetrainSubsystem.resetGyro();
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        drivetrainSubsystem.straightArcadeDrive(ServiceLocator
                .get(TrapezoidalMotionProfile.class).getCurrentSpeed(), 0);

        SmartDashboard.putNumber("Curr Speed", ServiceLocator
                .get(TrapezoidalMotionProfile.class).getCurrentSpeed());
    }

    @Override
    protected boolean isFinished() {
        return trapezoidalMotionProfile.getIsFinishedMoving();
    }

    @Override
    protected void end() {
    }
}
