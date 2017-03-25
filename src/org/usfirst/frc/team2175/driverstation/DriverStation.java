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

    private Joystick leftJoystick;
    private Joystick rightJoystick;
    private Joystick weaponsGamepad;

    private double deadbandSize;
    private DeadbandCalculator deadbandCalculator;
    private JoystickProperties joystickProperties;

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
    private JoystickButton gearIntakeActuateOutDriverButton;
    private JoystickButton gearIntakeInDriverButton;
    private JoystickButton gearIntakeOutDriverButton;
    private JoystickButton gearIntakeOutAndSpinDriverButton;

    private POVTrigger shooterInPOV;
    private POVTrigger fuelOutPOV;

    private double maxClimberSpeed;

    public DriverStation() {
        joystickProperties = ServiceLocator.get(JoystickProperties.class);
        final ClimberSubsystem climberSubsystem =
                ServiceLocator.get(ClimberSubsystem.class);

        leftJoystick = new Joystick(joystickProperties.getLeftJoystickPort());
        rightJoystick = new Joystick(joystickProperties.getRightJoytickPort());
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
        gearIntakeActuateOutDriverButton = buttonFromButtonInfo(
                joystickProperties.getGearIntakeActuatorInfo());
        gearIntakeInDriverButton = buttonFromButtonInfo(
                joystickProperties.getGearIntakeInDriverInfo());
        gearIntakeOutDriverButton = buttonFromButtonInfo(
                joystickProperties.getGearIntakeInDriverInfo());
        gearIntakeOutAndSpinDriverButton = buttonFromButtonInfo(
                joystickProperties.getGearIntakeOutAndSpinDriverInfo());

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

    public JoystickButton getGearIntakeOutAndSpinDriverButton() {
        return gearIntakeOutAndSpinDriverButton;
    }

    public JoystickButton getGearIntakeActuateOutDriverButton() {
        return gearIntakeActuateOutDriverButton;
    }

    public JoystickButton getGearIntakeInDriverButton() {
        return gearIntakeInDriverButton;
    }

    public JoystickButton getGearIntakeOutDriverButton() {
        return gearIntakeOutDriverButton;
    }

    protected JoystickButton buttonFromButtonInfo(
            final JoystickProperties.ButtonInfo buttonInfo) {
        return new JoystickButton(joystickForName(buttonInfo.joystickName),
                buttonInfo.buttonNumber);
    }

    private Joystick joystickForName(final String name) {
        Joystick joystickOfChoice = null;
        switch (name) {
        case "left":
            joystickOfChoice = leftJoystick;
            break;
        case "right":
            joystickOfChoice = rightJoystick;
            break;
        case "gamepad":
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
        final double input = leftJoystick.getY();
        final double deadbandedOutput = deadbandCalculator
                .calcDeadbandedOutput(squareRootInput(input), deadbandSize);
        return -deadbandedOutput;
    }

    public double getTurnValue() {
        final double input = rightJoystick.getX();
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

    public boolean isPrecisionButtonPressed() {
        return rightJoystick.getRawButton(1);
    }
}
