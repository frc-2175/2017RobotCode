package org.usfirst.frc.team2175.commandmapper;

import java.util.HashMap;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.single.ActuateGearCommand;
import org.usfirst.frc.team2175.command.single.ActuateGearIntakeOutAndSpinCommand;
import org.usfirst.frc.team2175.command.single.FuelIntakeFailsafeCommand;
import org.usfirst.frc.team2175.command.single.LowerHopperCommand;
import org.usfirst.frc.team2175.command.single.RunFuelInCommand;
import org.usfirst.frc.team2175.command.single.RunGearInCommand;
import org.usfirst.frc.team2175.command.single.RunGearOutCommand;
import org.usfirst.frc.team2175.command.single.RunShooterOutCommand;
import org.usfirst.frc.team2175.command.single.ShiftGearsCommand;
import org.usfirst.frc.team2175.command.single.ShooterFailsafeCommand;
import org.usfirst.frc.team2175.driverstation.DriverStation;
import org.usfirst.frc.team2175.properties.ButtonProps;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class JoystickEventMapper {

    public JoystickEventMapper() {
        final DriverStation driverStation =
                ServiceLocator.get(DriverStation.class);
        HashMap<String, JoystickButton> buttonMap =
                driverStation.getButtonMap();

        buttonMap.get(ButtonProps.SHIFT_GEARS)
                .whileHeld(new ShiftGearsCommand());
        buttonMap.get(ButtonProps.GEAR_IN).whileHeld(new RunGearInCommand());
        buttonMap.get(ButtonProps.GEAR_OUT).whileHeld(new RunGearOutCommand());
        buttonMap.get(ButtonProps.SHOOT_OUT)
                .toggleWhenPressed(new RunShooterOutCommand());
        buttonMap.get(ButtonProps.ACTUATE_HOPPER)
                .toggleWhenPressed(new LowerHopperCommand());
        buttonMap.get(ButtonProps.FUEL_IN).whileHeld(new RunFuelInCommand());
        buttonMap.get(ButtonProps.ACTUATE_GEAR)
                .whenPressed(new ActuateGearCommand());
        buttonMap.get(ButtonProps.GEAR_OUT_SPIN)
                .whileHeld(new ActuateGearIntakeOutAndSpinCommand());

        buttonMap.get(ButtonProps.RAISE_GEAR_DRIVER)
                .whenPressed(new ActuateGearCommand());
        buttonMap.get(ButtonProps.GEAR_IN_DRIVER)
                .whileHeld(new RunGearInCommand());
        buttonMap.get(ButtonProps.GEAR_OUT_DRIVER)
                .whileHeld(new RunGearOutCommand());
        buttonMap.get(ButtonProps.GEAR_OUT_SPIN_DRIVER)
                .whileHeld(new ActuateGearIntakeOutAndSpinCommand());

        driverStation.getFuelOutPOV()
                .whileActive(new FuelIntakeFailsafeCommand());
        driverStation.getShooterInPOV()
                .whileActive(new ShooterFailsafeCommand());
    }
}
