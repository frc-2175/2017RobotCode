package org.usfirst.frc.team2175.commandmapper;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.EmptyCommand;
import org.usfirst.frc.team2175.command.single.LowerHopperCommand;
import org.usfirst.frc.team2175.command.single.RunFeederAgitatorCommand;
import org.usfirst.frc.team2175.command.single.RunFeederAgitatorReverseCommand;
import org.usfirst.frc.team2175.command.single.RunGearIntakeInCommand;
import org.usfirst.frc.team2175.command.single.RunGearIntakeOutCommand;
import org.usfirst.frc.team2175.command.single.RunShooterCommand;
import org.usfirst.frc.team2175.command.single.RunShooterReverseCommand;
import org.usfirst.frc.team2175.command.single.ShiftToHighGearCommand;
import org.usfirst.frc.team2175.driverstation.DriverStation;

public class JoystickEventMapper {

    public JoystickEventMapper() {
        DriverStation driverStation = ServiceLocator.get(DriverStation.class);

        driverStation.getShiftButton().whenPressed(new EmptyCommand());
        driverStation.getShiftButton().whenReleased(new EmptyCommand());
        driverStation.getShiftButton().whileHeld(new ShiftToHighGearCommand());
        driverStation.getGearIntakeInButton()
                .whileHeld(new RunGearIntakeInCommand());
        driverStation.getGearIntakeOutButton()
                .whileHeld(new RunGearIntakeOutCommand());

        driverStation.getRunShooterOut().whileHeld(new RunShooterCommand());
        driverStation.getRunFeederOut()
                .whileHeld(new RunFeederAgitatorCommand());
        driverStation.getFeederIn()
                .whileHeld(new RunFeederAgitatorReverseCommand());
        driverStation.getRunShooterIn()
                .whileHeld(new RunShooterReverseCommand());
        driverStation.getRaiseHopper()
                .toggleWhenPressed(new LowerHopperCommand());
    }

}
