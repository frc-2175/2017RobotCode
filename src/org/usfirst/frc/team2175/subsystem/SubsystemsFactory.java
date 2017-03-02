package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.subsystem.drivetrain.DrivetrainSubsystem;
import org.usfirst.frc.team2175.subsystem.visionprocessing.VisionSubsystem;

public class SubsystemsFactory {

    public static void makeAll() {
        new ClimberSubsystem();
        new DrivetrainSubsystem();
        new FuelIntakeSubsystem();
        new GearIntakeSubsystem();
        new ShooterSubsystem();
        new VisionSubsystem();
    }

}
