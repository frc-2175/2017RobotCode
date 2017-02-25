package org.usfirst.frc.team2175.subsystem;

public class SubsystemsFactory {

    public static void makeAll() {
        new ClimberSubsystem();
        new DrivetrainSubsystem();
        new FuelIntakeSubsystem();
        new GearIntakeSubsystem();
        new ShooterSubsystem();
        // new VisionSubsystem();
    }

}
