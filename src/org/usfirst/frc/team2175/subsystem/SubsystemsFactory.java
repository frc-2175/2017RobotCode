package org.usfirst.frc.team2175.subsystem;

public class SubsystemsFactory {

    public static void makeAll() {
        new DrivetrainSubsystem();
        new GearIntakeSubsystem();
        new FuelIntakeSubsystem();
        new ClimberSubsystem();
    }

}
