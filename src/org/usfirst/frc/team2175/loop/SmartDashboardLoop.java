package org.usfirst.frc.team2175.loop;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.group.DriveForwardForSecondsCommandGroup;
import org.usfirst.frc.team2175.subsystem.GearIntakeSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardLoop extends ControlLoop {
    private final GearIntakeSubsystem gearIntakeSubsystem;

    private final SendableChooser<Command> autonSelector;

    public SmartDashboardLoop() {
        gearIntakeSubsystem = ServiceLocator.get(GearIntakeSubsystem.class);

        autonSelector = new SendableChooser<>();

        populateAutonSelector();
        SmartDashboard.putData("Auton", autonSelector);

        ServiceLocator.register(this);
    }

    @Override
    protected long getPeriodMs() {
        return 10;
    }

    @Override
    protected void runTask() {
        showGearIntakeInfo();
    }

    protected void showGearIntakeInfo() {
        SmartDashboard.putNumber("Current",
                gearIntakeSubsystem.getLeftMotorCurrent());
        SmartDashboard.putBoolean("Gear in Gear Intake",
                gearIntakeSubsystem.getLeftMotorCurrent() > 2.5);
    }

    private void populateAutonSelector() {
        autonSelector.addObject("Drive Forward for 3 Seconds",
                new DriveForwardForSecondsCommandGroup(3));
    }

    public Command getAuton() {
        return autonSelector.getSelected();
    }

}
