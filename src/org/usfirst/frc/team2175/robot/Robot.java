package org.usfirst.frc.team2175.robot;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.DefaultCommandFactory;
import org.usfirst.frc.team2175.commandmapper.JoystickEventMapper;
import org.usfirst.frc.team2175.driverstation.DriverStation;
import org.usfirst.frc.team2175.loop.SchedulerLoop;
import org.usfirst.frc.team2175.loop.SmartDashboardLoop;
import org.usfirst.frc.team2175.properties.LoggingConfig;
import org.usfirst.frc.team2175.properties.PropertiesFactory;
import org.usfirst.frc.team2175.subsystem.SubsystemsFactory;
import org.usfirst.frc.team2175.subsystem.drivetrain.DrivetrainSubsystem;
import org.usfirst.frc.team2175.subsystem.drivetrain.TrapezoidalMotionProfile;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    private SmartDashboardLoop smartDashboardLoop;
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
        new TrapezoidalMotionProfile();
        DefaultCommandFactory.makeAll();

        new JoystickEventMapper();
        schedulerLoop.start();
        smartDashboardLoop = new SmartDashboardLoop();
        smartDashboardLoop.start();

        log.info("Robot program successfully initialized!");
    }

    @Override
    public void autonomousInit() {
        Scheduler.getInstance().add(smartDashboardLoop.getAuton());
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
    public void teleopInit() {
        // Scheduler.getInstance().removeAll();
    }

    @Override
    public void teleopPeriodic() {
        log.info("Current Encoder Position = " + ServiceLocator
                .get(DrivetrainSubsystem.class).getCurrentEncPosition());
    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
    }

}
