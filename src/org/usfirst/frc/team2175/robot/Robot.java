package org.usfirst.frc.team2175.robot;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc.team2175.command.DefaultCommandFactory;
import org.usfirst.frc.team2175.commandmapper.JoystickEventMapper;
import org.usfirst.frc.team2175.driverstation.DriverStation;
import org.usfirst.frc.team2175.loop.SchedulerLoop;
import org.usfirst.frc.team2175.properties.LoggingConfig;
import org.usfirst.frc.team2175.properties.PropertiesFactory;
import org.usfirst.frc.team2175.subsystem.SubsystemsFactory;
import org.usfirst.frc.team2175.subsystem.visionprocessing.CameraHandler;

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
        try {
            new LoggingConfig();
            PropertiesFactory.makeAll();
            SubsystemsFactory.makeAll();
            new DriverStation();
            DefaultCommandFactory.makeAll();
        } catch (final Throwable e) {
            final String msg =
                    "ERROR in Robot class making all in static initializer";
            log.log(Level.SEVERE, msg, e);
            throw e;
        }
    }

    SchedulerLoop schedulerLoop = new SchedulerLoop();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        new JoystickEventMapper();
        schedulerLoop.start();
        CameraHandler cameraHandler = new CameraHandler();
        new Thread(() -> {
            cameraHandler.run();
        }).start();

    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString line to get the auto name from the text box below the Gyro
     *
     * You can add additional auto modes by adding additional comparisons to the
     * switch structure below with additional strings. If using the
     * SendableChooser make sure to add them to the chooser code above as well.
     */
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
