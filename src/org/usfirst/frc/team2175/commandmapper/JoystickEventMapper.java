package org.usfirst.frc.team2175.commandmapper;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.single.ActuateGearIntakeOutAndSpinCommand;
import org.usfirst.frc.team2175.command.single.ActuateGearIntakeOutCommand;
import org.usfirst.frc.team2175.command.single.FuelIntakeFailsafeCommand;
import org.usfirst.frc.team2175.command.single.LowerHopperCommand;
import org.usfirst.frc.team2175.command.single.RunFeederAgitatorCommand;
import org.usfirst.frc.team2175.command.single.RunFuelIntakeInCommand;
import org.usfirst.frc.team2175.command.single.RunGearIntakeInCommand;
import org.usfirst.frc.team2175.command.single.RunGearIntakeOutCommand;
import org.usfirst.frc.team2175.command.single.RunShooterCommand;
import org.usfirst.frc.team2175.command.single.RunShooterReverseCommand;
import org.usfirst.frc.team2175.command.single.ShiftToHighGearCommand;
import org.usfirst.frc.team2175.command.single.ShooterFailsafeCommand;
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
                .toggleWhenPressed(new RunShooterCommand());
        driverStation.getFeederOutButton()
                .toggleWhenPressed(new RunFeederAgitatorCommand());
        driverStation.getShooterInButton()
                .whileHeld(new RunShooterReverseCommand());
        driverStation.getHopperButton()
                .toggleWhenPressed(new LowerHopperCommand());
        driverStation.getFuelIntakeInButton()
                .whileHeld(new RunFuelIntakeInCommand());
        driverStation.getGearIntakeActuateOutButton()
                .toggleWhenPressed(new ActuateGearIntakeOutCommand());
        driverStation.getGearIntakeOutAndSpinButton()
                .whileHeld(new ActuateGearIntakeOutAndSpinCommand());

        driverStation.getFuelOutPOV()
                .whileActive(new FuelIntakeFailsafeCommand());
        driverStation.getShooterInPOV()
                .whileActive(new ShooterFailsafeCommand());

    }

}
