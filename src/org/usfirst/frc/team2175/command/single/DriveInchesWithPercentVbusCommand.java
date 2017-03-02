package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.drivetrain.DrivetrainSubsystem;
import org.usfirst.frc.team2175.subsystem.drivetrain.TrapezoidalMotionProfile;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveInchesWithPercentVbusCommand extends BaseCommand {
    private DrivetrainSubsystem drivetrainSubsystem;
    private TrapezoidalMotionProfile motionProfile;

    public DriveInchesWithPercentVbusCommand(final double inches) {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        motionProfile = ServiceLocator.get(TrapezoidalMotionProfile.class);
        motionProfile.setUpDrive(inches);

        drivetrainSubsystem.resetEncoders();
        drivetrainSubsystem.resetGyro();
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        drivetrainSubsystem.straightArcadeDrive(motionProfile.getCurrentSpeed(),
                0);

        SmartDashboard.putNumber("Curr Speed", motionProfile.getCurrentSpeed());
    }

    @Override
    protected boolean isFinished() {
        return motionProfile.isFinishedMoving();
    }

    @Override
    protected void end() {
    }
}
