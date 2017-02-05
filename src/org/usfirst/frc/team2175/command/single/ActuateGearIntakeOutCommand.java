package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.subsystem.GearIntakeSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class ActuateGearIntakeOutCommand extends Command {

    // TODO: Make this class extend BaseCommand instead of Command

    GearIntakeSubsystem gearIntakeSubsystem;

    public ActuateGearIntakeOutCommand() {
        gearIntakeSubsystem = ServiceLocator.get(GearIntakeSubsystem.class);
        // TODO: Require the gear intake subsystem
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
        return false;
    }

    @Override
    protected void end() {
        super.end();
        gearIntakeSubsystem.raiseIntake();
    }

}
