package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
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
    ButtonMapping intakeIn;
    ButtonMapping intakeOut;
    private IO() {
        this.driveControllerPort = 0;
        this.ballControllerPort = 1;
        this.driveController = new Joystick(driveControllerPort);
        this.ballController = new Joystick(ballControllerPort);
        this.intakeIn = new ButtonMapping(this.ballController, driveLayout.intakeInBtn);
        this.intakeOut = new ButtonMapping(this.ballController, driveLayout.intakeOutBtn);
    }
    public static IO getInstance() {
        if (instance == null) {
            instance = new IO();
        }
        return instance;
    }
}
