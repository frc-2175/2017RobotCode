package org.usfirst.frc.team2175.command;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.single.ArcadeDriveWithJoysticksCommand;
import org.usfirst.frc.team2175.command.single.RunClimberCommand;
import org.usfirst.frc.team2175.subsystem.ClimberSubsystem;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;

public class DefaultCommandFactory {

    public static void makeAll() {
        DrivetrainSubsystem drivetrainSubsystem;
        ClimberSubsystem climberSubsystem;

        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        climberSubsystem = ServiceLocator.get(ClimberSubsystem.class);
        drivetrainSubsystem
                .setDefaultCommand(new ArcadeDriveWithJoysticksCommand());
        climberSubsystem.setDefaultCommand(new RunClimberCommand());

    }

}
