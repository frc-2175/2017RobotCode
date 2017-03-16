package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.drivetrain.DrivetrainSubsystem;
import org.usfirst.frc.team2175.subsystem.drivetrain.TrapezoidalMotionProfile;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// TODO: Determine what to do with this class. We may want to rename it to
// reflect the use of TrapezoidalMotionProfile.
public class DriveInchesWithTrapezoidalMotionCommand extends BaseCommand {
    private DrivetrainSubsystem drivetrainSubsystem;
    private TrapezoidalMotionProfile motionProfile;

    public DriveInchesWithTrapezoidalMotionCommand(final double inches) {
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
        drivetrainSubsystem
                .straightArcadeDrive(motionProfile.getCurrentSpeed());

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
