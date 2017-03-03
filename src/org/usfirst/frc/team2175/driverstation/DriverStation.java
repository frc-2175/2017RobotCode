package org.usfirst.frc.team2175.driverstation;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.JoystickProperties;
import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.subsystem.ClimberSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DriverStation {
    private final static Logger log = Logger.getLogger(Robot.class.getName());

    private Joystick driverGamepad;
    private Joystick weaponsGamepad;

    private double deadbandSize;
    private DeadbandCalculator deadbandCalculator;

    private JoystickButton climbButton;
    private JoystickButton feedOutButton;
    private JoystickButton fuelIntakeActuateInButton;
    private JoystickButton fuelIntakeActuateOutButton;
    private JoystickButton fuelIntakeInButton;
    private JoystickButton gearIntakeActuateOutButton;
    private JoystickButton gearIntakeInButton;
    private JoystickButton gearIntakeOutButton;
    private JoystickButton hopperButton;
    private JoystickButton shiftButton;
    private JoystickButton shootInButton;
    private JoystickButton shootOutButton;
    private JoystickButton cameraSwitchButton;
    private JoystickButton gearIntakeOutAndSpinButton;
    private JoystickButton shooterActuatorInButton;
    private JoystickButton shooterActuatorOutButton;

    private POVTrigger shooterInPOV;
    private POVTrigger fuelOutPOV;

    private double maxClimberSpeed;

    public DriverStation() {
        final JoystickProperties joystickProperties =
                ServiceLocator.get(JoystickProperties.class);
        final ClimberSubsystem climberSubsystem =
                ServiceLocator.get(ClimberSubsystem.class);

        driverGamepad = new Joystick(joystickProperties.getDriverGamepadPort());
        weaponsGamepad =
                new Joystick(joystickProperties.getWeaponsGamepadPort());

        feedOutButton =
                buttonFromButtonInfo(joystickProperties.getFeederOutInfo());
        fuelIntakeActuateInButton = buttonFromButtonInfo(
                joystickProperties.getFuelIntakeActuateInInfo());
        fuelIntakeActuateOutButton = buttonFromButtonInfo(
                joystickProperties.getFuelIntakeActuateOutInfo());
        fuelIntakeInButton =
                buttonFromButtonInfo(joystickProperties.getFuelIntakeInInfo());
        gearIntakeActuateOutButton = buttonFromButtonInfo(
                joystickProperties.getGearIntakeActuatorInfo());
        gearIntakeInButton =
                buttonFromButtonInfo(joystickProperties.getGearIntakeInInfo());
        gearIntakeOutButton =
                buttonFromButtonInfo(joystickProperties.getGearIntakeOutInfo());
        hopperButton = buttonFromButtonInfo(joystickProperties.getHopperInfo());
        shiftButton =
                buttonFromButtonInfo(joystickProperties.getShiftGearsInfo());
        shootOutButton =
                buttonFromButtonInfo(joystickProperties.getShooterOutInfo());
        cameraSwitchButton =
                buttonFromButtonInfo(joystickProperties.getCameraSwitchInfo());
        gearIntakeOutAndSpinButton = buttonFromButtonInfo(
                joystickProperties.getGearIntakeOutAndSpinInfo());
        shooterActuatorInButton = buttonFromButtonInfo(
                joystickProperties.getShooterActuatorInInfo());

        shooterInPOV = new POVTrigger(weaponsGamepad,
                joystickProperties.getShooterInPOV());
        fuelOutPOV = new POVTrigger(weaponsGamepad,
                joystickProperties.getFuelIntakeOutPOV());

        deadbandSize = joystickProperties.getDeadbandValue();
        deadbandCalculator = new DeadbandCalculator();

        maxClimberSpeed = climberSubsystem.getMaxClimberSpeed();
        shooterActuatorOutButton = buttonFromButtonInfo(
                joystickProperties.getShooterActuatorOutInfo());
        ServiceLocator.register(this);
    }

    protected JoystickButton buttonFromButtonInfo(
            final JoystickProperties.ButtonInfo buttonInfo) {
        return new JoystickButton(joystickForName(buttonInfo.joystickName),
                buttonInfo.buttonNumber);
    }

    private Joystick joystickForName(final String name) {
        Joystick joystickOfChoice = null;
        switch (name) {
        case "driver":
            joystickOfChoice = driverGamepad;
            break;
        case "weapons":
            joystickOfChoice = weaponsGamepad;
            break;
        default:
            final String msg =
                    "Joystick name parameter is not valid. Joystick name is="
                            + name;
            log.severe(msg);
            throw new IllegalArgumentException(msg);
        }
        return joystickOfChoice;
    }

    public double getMoveValue() {
        final double input = driverGamepad.getRawAxis(1);
        final double deadbandedOutput = deadbandCalculator
                .calcDeadbandedOutput(squareRootInput(input), deadbandSize);
        return -deadbandedOutput;
    }

    public double getTurnValue() {
        final double input = driverGamepad.getRawAxis(2);
        final double deadbandedOutput = deadbandCalculator
                .calcDeadbandedOutput(squareRootInput(input), deadbandSize);
        return deadbandedOutput;
    }

    protected static double squareRootInput(final double input) {
        final double sign = Math.signum(input);
        return sign * Math.sqrt(Math.abs(input));
    }

    public double getClimberSpinSpeed() {
        return -(weaponsGamepad.getRawAxis(1) * maxClimberSpeed);
    }

    public JoystickButton getFeederOutButton() {
        return feedOutButton;
    }

    public JoystickButton getFuelIntakeActuateInButton() {
        return fuelIntakeActuateInButton;
    }

    public JoystickButton getFuelIntakeActuateOutButton() {
        return fuelIntakeActuateOutButton;
    }

    public JoystickButton getFuelIntakeInButton() {
        return fuelIntakeInButton;
    }

    public JoystickButton getGearIntakeActuateOutButton() {
        return gearIntakeActuateOutButton;
    }

    public JoystickButton getGearIntakeInButton() {
        return gearIntakeInButton;
    }

    public JoystickButton getGearIntakeOutButton() {
        return gearIntakeOutButton;
    }

    public JoystickButton getHopperButton() {
        return hopperButton;
    }

    public JoystickButton getShiftButton() {
        return shiftButton;
    }

    public JoystickButton getShooterOutButton() {
        return shootOutButton;
    }

    public JoystickButton getCameraSwitchButton() {
        return cameraSwitchButton;
    }

    public JoystickButton getClimbButton() {
        return climbButton;
    }

    public POVTrigger getFuelOutPOV() {
        return fuelOutPOV;
    }

    public POVTrigger getShooterInPOV() {
        return shooterInPOV;
    }

    public JoystickButton getGearIntakeOutAndSpinButton() {
        return gearIntakeOutAndSpinButton;
    }

    public JoystickButton getShooterActuateInButton() {
        return shooterActuatorInButton;
    }

    public JoystickButton getShooterActuatorOutButton() {
        return shooterActuatorOutButton;
    }
}
