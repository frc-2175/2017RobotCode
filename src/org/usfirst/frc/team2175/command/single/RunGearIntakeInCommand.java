package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.GearIntakeSubsystem;

public class RunGearIntakeInCommand extends BaseCommand {
    private final GearIntakeSubsystem gearIntakeSubsystem;

    public RunGearIntakeInCommand() {
        gearIntakeSubsystem = ServiceLocator.get(GearIntakeSubsystem.class);
    }

    @Override
    protected void initialize() {
        super.initialize();
        gearIntakeSubsystem.runIn();
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        super.end();
        gearIntakeSubsystem.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
