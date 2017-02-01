package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.driverstation.DriverStation;
import org.usfirst.frc.team2175.subsystem.ClimberSubsystem;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;

public class ArcadeDriveWithJoysticksCommand extends BaseCommand {

    private final DrivetrainSubsystem drivetrainSubsystem;
    private final DriverStation driverStation;
    private final ClimberSubsystem climberSubsystem;

    public ArcadeDriveWithJoysticksCommand() {
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        driverStation = ServiceLocator.get(DriverStation.class);
        climberSubsystem = ServiceLocator.get(ClimberSubsystem.class);

        requires(drivetrainSubsystem);
        requires(climberSubsystem);
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected void execute() {
        double moveValue = driverStation.getMoveValue();
        double turnValue = driverStation.getTurnValue();
        drivetrainSubsystem.arcadeDrive(moveValue, turnValue);
        double climberSpeed = driverStation.getClimberSpinSpeed();
        climberSubsystem.setClimberSpeed(climberSpeed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        super.end();
        drivetrainSubsystem.arcadeDrive(0, 0);
    }

    @Override
    protected void interrupted() {
        end();
    }

}
