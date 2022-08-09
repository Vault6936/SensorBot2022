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
    ButtonMapping intakeIn;
    ButtonMapping intakeOut;

    ButtonMapping shooter;

    AxisMapping turretHor;
    AxisMapping turretVert;
    private IO() {
        this.driveControllerPort = 0;
        this.ballControllerPort = 1;
        this.driveController = new Joystick(driveControllerPort);
        this.ballController = new Joystick(ballControllerPort);
        this.driveYVel = new AxisMapping.Builder(this.driveController, driveLayout.driveYVel).build();
        this.driveXVel = new AxisMapping.Builder(this.driveController, driveLayout.driveXVel).build();
        this.driveRot = new AxisMapping.Builder(this.driveController, driveLayout.driveRot).build();
        this.intakeIn = new ButtonMapping(this.ballController, driveLayout.intakeInBtn);
        this.intakeOut = new ButtonMapping(this.ballController, driveLayout.intakeOutBtn);
        this.shooter = new ButtonMapping(this.ballController, ballLayout.shooterBtn);
        this.turretHor = new AxisMapping.Builder(ballController, ballLayout.turretHor).build();
        this.turretVert = new AxisMapping.Builder(ballController, ballLayout.turretVert).build();
    }
    public static IO getInstance() {
        if (instance == null) {
            instance = new IO();
        }
        return instance;
    }
}
