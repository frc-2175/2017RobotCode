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
import org.usfirst.frc.team2175.properties.Properties;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class JoystickEventMapper {

    public JoystickEventMapper() {
        final DriverStation driverStation =
                ServiceLocator.get(DriverStation.class);
        Properties props = ServiceLocator.get(Properties.class);
        HashMap<String, JoystickButton> buttonMap =
                driverStation.getButtonMap();

        buttonMap.get(props.getShiftGears()).whileHeld(new ShiftGearsCommand());
        buttonMap.get(props.getGearIn()).whileHeld(new RunGearInCommand());
        buttonMap.get(props.getGearOut()).whileHeld(new RunGearOutCommand());
        buttonMap.get(props.getShootOut())
                .toggleWhenPressed(new RunShooterOutCommand());
        buttonMap.get(props.getHopper())
                .toggleWhenPressed(new LowerHopperCommand());
        buttonMap.get(props.getFuelIn()).whileHeld(new RunFuelInCommand());
        buttonMap.get(props.getActuateGear())
                .whenPressed(new ActuateGearCommand());
        buttonMap.get(props.getGearOutAndSpin())
                .whileHeld(new ActuateGearIntakeOutAndSpinCommand());

        buttonMap.get(props.getActuateGearDriver())
                .whenPressed(new ActuateGearCommand());
        buttonMap.get(props.getGearInDriver())
                .whileHeld(new RunGearInCommand());
        buttonMap.get(props.getGearOutDriver())
                .whileHeld(new RunGearOutCommand());
        buttonMap.get(props.getGearOutAndSpinDriver())
                .whileHeld(new ActuateGearIntakeOutAndSpinCommand());

        driverStation.getFuelOutPOV()
                .whileActive(new FuelIntakeFailsafeCommand());
        driverStation.getShooterInPOV()
                .whileActive(new ShooterFailsafeCommand());
    }
}
