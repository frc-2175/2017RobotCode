package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.driverstation.DriverStation;
import org.usfirst.frc.team2175.subsystem.communications.CommunicationSubsystem;
import org.usfirst.frc.team2175.subsystem.visionprocessing.VisionSubsystem;

public class SubsystemsFactory {

    public static void makeAll() {
        new ClimberSubsystem();
        new DrivetrainSubsystem();
        new FuelIntakeSubsystem();
        new GearIntakeSubsystem();
        new DriverStation();
        new ShooterSubsystem();
        new VisionSubsystem();
        new CommunicationSubsystem();
    }

}
