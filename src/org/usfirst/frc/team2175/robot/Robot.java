package org.usfirst.frc.team2175.robot;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.command.DefaultCommandFactory;
import org.usfirst.frc.team2175.commandmapper.JoystickEventMapper;
import org.usfirst.frc.team2175.driverstation.DriverStation;
import org.usfirst.frc.team2175.loop.SchedulerLoop;
import org.usfirst.frc.team2175.properties.LoggingConfig;
import org.usfirst.frc.team2175.properties.PropertiesFactory;
import org.usfirst.frc.team2175.subsystem.SubsystemsFactory;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    private final static Logger log = Logger.getLogger(Robot.class.getName());

    static {
        new LoggingConfig();
    }

    SchedulerLoop schedulerLoop = new SchedulerLoop();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        PropertiesFactory.makeAll();
        SubsystemsFactory.makeAll();
        new DriverStation();
        DefaultCommandFactory.makeAll();

        new JoystickEventMapper();
        schedulerLoop.start();

        log.info("Robot program successfully initialized!");
    }

    @Override
    public void autonomousInit() {
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
    }

}
