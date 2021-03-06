package org.usfirst.frc.team2175.robot;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.DefaultCommandFactory;
import org.usfirst.frc.team2175.commandmapper.JoystickEventMapper;
import org.usfirst.frc.team2175.loop.SchedulerLoop;
import org.usfirst.frc.team2175.loop.SmartDashboardLoop;
import org.usfirst.frc.team2175.properties.LoggingConfig;
import org.usfirst.frc.team2175.properties.PropertiesFactory;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;
import org.usfirst.frc.team2175.subsystem.SubsystemsFactory;
import org.usfirst.frc.team2175.subsystem.visionprocessing.VisionSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    private final static Logger log = Logger.getLogger(Robot.class.getName());
    private SmartDashboardLoop smartDashboardLoop;
    private DrivetrainSubsystem drivetrainSubsystem;
    private VisionSubsystem visionSubsystem;
    private Command auton;

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

        DefaultCommandFactory.makeAll();

        new JoystickEventMapper();
        schedulerLoop.start();
        smartDashboardLoop = new SmartDashboardLoop();
        smartDashboardLoop.start();
        drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
        visionSubsystem = ServiceLocator.get(VisionSubsystem.class);
        SmartDashboard.putBoolean("Refresh Auton Selector", false);
        log.info("Robot program successfully initialized!");
    }

    @Override
    public void disabledPeriodic() {
        if (SmartDashboard.getBoolean("Refresh Auton Selector", false)) {
            smartDashboardLoop.makeAutonSelector();
        }
    }

    @Override
    public void autonomousInit() {
        visionSubsystem.setExposureManual(1);
        drivetrainSubsystem.resetSensors();
        auton = smartDashboardLoop.getAuton();
        Scheduler.getInstance().add(auton);
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
        visionSubsystem.setExposureManual(3);
        drivetrainSubsystem.resetSensors();

        if (auton != null && auton.isRunning()) {
            auton.cancel();
        }
    }

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
