package org.usfirst.frc.team2175.commandmapper;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.single.ActuateGearIntakeOutAndSpinCommand;
import org.usfirst.frc.team2175.command.single.ActuateShooterCommand;
import org.usfirst.frc.team2175.command.single.FuelIntakeFailsafeCommand;
import org.usfirst.frc.team2175.command.single.LowerGearIntakeCommand;
import org.usfirst.frc.team2175.command.single.LowerHopperCommand;
import org.usfirst.frc.team2175.command.single.RaiseGearIntakeCommand;
import org.usfirst.frc.team2175.command.single.RunFeedingMechanismsCommand;
import org.usfirst.frc.team2175.command.single.RunFuelIntakeInCommand;
import org.usfirst.frc.team2175.command.single.RunGearIntakeInCommand;
import org.usfirst.frc.team2175.command.single.RunGearIntakeOutCommand;
import org.usfirst.frc.team2175.command.single.RunShooterPercentVbusCommand;
import org.usfirst.frc.team2175.command.single.ShiftToHighGearCommand;
import org.usfirst.frc.team2175.command.single.ShooterFailsafeCommand;
import org.usfirst.frc.team2175.command.single.ToggleGearIntakeActuationCommand;
import org.usfirst.frc.team2175.driverstation.DriverStation;

public class JoystickEventMapper {

    public JoystickEventMapper() {
        final DriverStation driverStation =
                ServiceLocator.get(DriverStation.class);

        driverStation.getShiftButton().whileHeld(new ShiftToHighGearCommand());
        driverStation.getGearIntakeInButton()
                .whileHeld(new RunGearIntakeInCommand());
        driverStation.getGearIntakeOutButton()
                .whileHeld(new RunGearIntakeOutCommand());

        driverStation.getShooterOutButton()
                .toggleWhenPressed(new RunShooterPercentVbusCommand());
        driverStation.getFeederOutButton()
                .toggleWhenPressed(new RunFeedingMechanismsCommand());
        driverStation.getHopperButton()
                .toggleWhenPressed(new LowerHopperCommand());
        driverStation.getFuelIntakeInButton()
                .whileHeld(new RunFuelIntakeInCommand());
        driverStation.getGearIntakeActuateOutButton()
                .whenPressed(new ToggleGearIntakeActuationCommand());
        driverStation.getGearIntakeOutAndSpinButton()
                .whileHeld(new ActuateGearIntakeOutAndSpinCommand());
        driverStation.getShooterActuatorButton()
                .toggleWhenPressed(new ActuateShooterCommand());

        driverStation.getGearIntakeUpDriverButton()
                .whenPressed(new RaiseGearIntakeCommand());
        driverStation.getGearIntakeDownDriverButton()
                .whenPressed(new LowerGearIntakeCommand());
        driverStation.getGearIntakeInDriverButton()
                .whileHeld(new RunGearIntakeInCommand());
        driverStation.getGearIntakeOutAndSpinDriverButton()
                .whileHeld(new ActuateGearIntakeOutAndSpinCommand());

        driverStation.getFuelOutPOV()
                .whileActive(new FuelIntakeFailsafeCommand());
        driverStation.getShooterInPOV()
                .whileActive(new ShooterFailsafeCommand());

    }

}
