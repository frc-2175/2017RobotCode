package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.GearIntakeSubsystem;

public class ActuateGearIntakeOutCommand extends BaseCommand {
    GearIntakeSubsystem gearIntakeSubsystem;

    public ActuateGearIntakeOutCommand() {
        gearIntakeSubsystem = ServiceLocator.get(GearIntakeSubsystem.class);
        requires(gearIntakeSubsystem);
    }

    @Override
    protected void initialize() {
        super.initialize();
        gearIntakeSubsystem.lowerIntake();
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        super.end();
    }
}
