package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.mappings.AxisMapping;
import frc.robot.mappings.ButtonMapping;
import frc.robot.utils.GamepadLayout;
import frc.robot.utils.SwitchProLayout;

public class IO {
    private static IO instance = null;
    public int driveControllerPort;
    public int ballControllerPort;

    public Joystick driveController;
    public Joystick ballController;

    GamepadLayout driveLayout = new SwitchProLayout(); //drive controller layout
    GamepadLayout ballLayout = new SwitchProLayout(); //tennis ball controller layout

    AxisMapping driveYVel;
    AxisMapping driveXVel;
    AxisMapping driveRot;
    ButtonMapping frontIntakeIn;
    ButtonMapping frontIntakeOut;
    ButtonMapping backIntakeIn;
    ButtonMapping backIntakeOut;

    ButtonMapping shooter;
    ButtonMapping payloadUp;
    ButtonMapping payloadDown;
    ButtonMapping armUp;
    ButtonMapping armDown;
    AxisMapping turretHor;
    AxisMapping turretVert;
    private IO() {
        this.driveControllerPort = Constants.DRIVE_CONTROLLER;
        this.ballControllerPort = Constants.PAYLOAD_CONTROLLER;
        this.driveController = new Joystick(driveControllerPort);
        this.ballController = new Joystick(ballControllerPort);
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
        this.turretHor = new AxisMapping.Builder(ballController, ballLayout.turretHor).build();
        this.turretVert = new AxisMapping.Builder(ballController, ballLayout.turretVert).build();
        this.armUp = new ButtonMapping(ballController, ballLayout.armUp);
        this.armDown = new ButtonMapping(ballController, ballLayout.armDown);
    }
    public static IO getInstance() {
        if (instance == null) {
            instance = new IO();
        }
        return instance;
    }
}
