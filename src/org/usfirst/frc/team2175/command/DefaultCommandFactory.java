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
        // TODO: Combine these variable declarations with their assignments
        // below. There is really no need to define them on one line, and
        // assign them on another.
        DrivetrainSubsystem drivetrainSubsystem;
        ClimberSubsystem climberSubsystem;
        ShooterSubsystem shooterSubsystem;
        FuelIntakeSubsystem fuelIntakeSubsystem;

        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        climberSubsystem = ServiceLocator.get(ClimberSubsystem.class);
        shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
        fuelIntakeSubsystem = ServiceLocator.get(FuelIntakeSubsystem.class);
        drivetrainSubsystem
                .setDefaultCommand(new ArcadeDriveWithJoysticksCommand());
        climberSubsystem.setDefaultCommand(new RunClimberCommand());
        shooterSubsystem.setDefaultCommand(new ShooterFailsafeCommand());
        fuelIntakeSubsystem.setDefaultCommand(new FuelIntakeFailsafeCommand());
    }

}
