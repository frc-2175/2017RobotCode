package org.usfirst.frc.team2175.command;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.single.ArcadeDriveWithJoysticksCommand;
import org.usfirst.frc.team2175.command.single.FuelIntakeFailsafeCommand;
import org.usfirst.frc.team2175.command.single.RunClimberCommand;
import org.usfirst.frc.team2175.command.single.ShooterFailsafeCommand;
import org.usfirst.frc.team2175.subsystem.ClimberSubsystem;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;
import org.usfirst.frc.team2175.subsystem.FuelIntakeSubsystem;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

public class DefaultCommandFactory {

    public static void makeAll() {
        final DrivetrainSubsystem drivetrainSubsystem =
                ServiceLocator.get(DrivetrainSubsystem.class);
        final ClimberSubsystem climberSubsystem =
                ServiceLocator.get(ClimberSubsystem.class);
        final ShooterSubsystem shooterSubsystem =
                ServiceLocator.get(ShooterSubsystem.class);
        final FuelIntakeSubsystem fuelIntakeSubsystem =
                ServiceLocator.get(FuelIntakeSubsystem.class);

        drivetrainSubsystem
                .setDefaultCommand(new ArcadeDriveWithJoysticksCommand());
        climberSubsystem.setDefaultCommand(new RunClimberCommand());
        shooterSubsystem.setDefaultCommand(new ShooterFailsafeCommand());
        fuelIntakeSubsystem.setDefaultCommand(new FuelIntakeFailsafeCommand());
    }

}
