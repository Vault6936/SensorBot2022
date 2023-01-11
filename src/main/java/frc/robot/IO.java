package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.mappings.AxisMapping;
import frc.robot.mappings.ButtonMapping;
import frc.robot.utils.GamepadLayout;
import frc.robot.utils.SwitchProLayout;

public class IO {
    private static IO instance = null;
    public int driveControllerPort;

    public Joystick driveController;

    GamepadLayout driveLayout = new SwitchProLayout(); //drive controller layout

    AxisMapping driveYVel;
    AxisMapping driveXVel;

    private IO() {
        this.driveControllerPort = Constants.DRIVE_CONTROLLER;
        this.driveController = new Joystick(driveControllerPort);
        this.driveYVel = new AxisMapping.Builder(this.driveController, driveLayout.driveYVel).build();
        this.driveXVel = new AxisMapping.Builder(this.driveController, driveLayout.driveXVel).build();

    }
    public static IO getInstance() {
        if (instance == null) {
            instance = new IO();
        }
        return instance;
    }
}
