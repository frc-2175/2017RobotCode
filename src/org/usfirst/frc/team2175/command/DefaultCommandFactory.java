package org.usfirst.frc.team2175.command;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.single.ArcadeDriveWithJoysticksCommand;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;

public class DefaultCommandFactory {

    public static void makeAll() {
        DrivetrainSubsystem drivetrainSubsystem;

        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        drivetrainSubsystem
                .setDefaultCommand(new ArcadeDriveWithJoysticksCommand());
    }

}
