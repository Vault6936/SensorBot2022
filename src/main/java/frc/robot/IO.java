package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.mappings.AxisMapping;
import frc.robot.mappings.ButtonMapping;
import frc.robot.utils.GamepadLayout;
import frc.robot.utils.LogiJoystick;
import frc.robot.utils.SwitchProLayout;

import java.awt.*;
import java.util.function.DoubleSupplier;

public class IO {
    private static IO instance = null;
    public int driveControllerPort;
    public int ballControllerPort;

    public int joystickControllerPort;

    public Joystick driveController;
    public Joystick ballController;

    public Joystick joystickController;

    GamepadLayout driveLayout = new SwitchProLayout(); //drive controller layout
    GamepadLayout ballLayout = new SwitchProLayout(); //tennis ball controller layout

    GamepadLayout joystickLayout = new LogiJoystick(); //Joystick Controls

    AxisMapping driveYVel;
    AxisMapping driveXVel;
    AxisMapping driveRot;

    AxisMapping driveYVelJoystick;
    AxisMapping driveXVelJoystick;
    AxisMapping driveRotJoystick;

    ButtonMapping frontIntakeIn;
    ButtonMapping frontIntakeOut;
    ButtonMapping backIntakeIn;
    ButtonMapping backIntakeOut;

    ButtonMapping shooter;
    ButtonMapping payloadUp;
    ButtonMapping payloadDown;
    ButtonMapping armUp;
    ButtonMapping armDown;



    ButtonMapping frontIntakeInJoystick;
    ButtonMapping frontIntakeOutJoystick;
    ButtonMapping backIntakeInJoystick;
    ButtonMapping backIntakeOutJoystick;

    ButtonMapping shooterJoystick;
    ButtonMapping payloadUpJoystick;
    ButtonMapping payloadDownJoystick;
    ButtonMapping armUpJoystick;
    ButtonMapping armDownJoystick;

    DoubleSupplier turretHor;
    DoubleSupplier turretVert;

    private IO() {
        this.driveControllerPort = Constants.DRIVE_CONTROLLER;
        this.ballControllerPort = Constants.PAYLOAD_CONTROLLER;
        this.joystickControllerPort = Constants.JOYSTICK_CONTROLLER;

        this.driveController = new Joystick(driveControllerPort);
        this.ballController = new Joystick(ballControllerPort);
        this.joystickController = new Joystick(joystickControllerPort);

        this.driveYVel = new AxisMapping.Builder(this.driveController, driveLayout.driveYVel).build();
        this.driveXVel = new AxisMapping.Builder(this.driveController, driveLayout.driveXVel).build();
        this.driveRot = new AxisMapping.Builder(this.driveController, driveLayout.driveRot).build();
        this.frontIntakeIn = new ButtonMapping(this.ballController, ballLayout.frontIntakeInBtn);
        this.frontIntakeOut = new ButtonMapping(this.ballController, ballLayout.frontIntakeOutBtn);
        this.backIntakeIn = new ButtonMapping(this.ballController, ballLayout.backIntakeInBtn);
        this.backIntakeOut = new ButtonMapping(this.ballController, ballLayout.backIntakeOutBtn);
        this.shooter = new ButtonMapping(this.ballController, ballLayout.shooterBtn);
        this.payloadUp = new ButtonMapping(this.ballController, ballLayout.payloadUp);
        this.payloadDown = new ButtonMapping(this.ballController, ballLayout.payloadDown);
        this.armUp = new ButtonMapping(ballController, ballLayout.armUp);
        this.armDown = new ButtonMapping(ballController, ballLayout.armDown);

        this.driveYVelJoystick = new AxisMapping.Builder(this.joystickController,joystickLayout.driveYVel).deadzoneValue(0.15).build();
        this.driveXVelJoystick = new AxisMapping.Builder(this.joystickController, joystickLayout.driveXVel).deadzoneValue(0.15).build();
        this.driveRotJoystick = new AxisMapping.Builder(this.joystickController, joystickLayout.driveRot).deadzoneValue(0.15).build();
        this.frontIntakeInJoystick = new ButtonMapping(this.joystickController, joystickLayout.frontIntakeInBtn);
        this.frontIntakeOutJoystick = new ButtonMapping(this.joystickController, joystickLayout.frontIntakeOutBtn);
        this.backIntakeInJoystick = new ButtonMapping(this.joystickController, joystickLayout.backIntakeInBtn);
        this.backIntakeOutJoystick = new ButtonMapping(this.joystickController, joystickLayout.backIntakeOutBtn);
        this.shooterJoystick = new ButtonMapping(this.joystickController, joystickLayout.shooterBtn);
        this.payloadUpJoystick = new ButtonMapping(this.joystickController, joystickLayout.payloadUp);
        this.payloadDownJoystick = new ButtonMapping(this.joystickController, joystickLayout.payloadDown);
        this.armUpJoystick = new ButtonMapping(joystickController, joystickLayout.armUp);
        this.armDownJoystick = new ButtonMapping(joystickController, joystickLayout.armDown);


        this.turretVert = this::getPovVert;
        this.turretHor = this::getPovHorz;
    }

    public Double getPovVert() {
        if (joystickController.getPOV() == 0 || ballController.getPOV() == 0)
            return 0.4;
        else if (joystickController.getPOV() == 180 || ballController.getPOV() == 180)
            return -0.4;
        else
            return 0.;
    }

    public Double getPovHorz() {
        if (joystickController.getPOV() == 270 || ballController.getPOV() == 270)
            return 0.4;
        else if (joystickController.getPOV() == 90 || ballController.getPOV() == 90)
            return -0.4;
        else
            return 0.;
    }

    public static IO getInstance() {
        if (instance == null) {
            instance = new IO();
        }
        return instance;
    }
}
