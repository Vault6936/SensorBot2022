package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.mappings.ButtonMapping;
import frc.robot.utils.GamepadLayout;
import frc.robot.utils.SwitchProLayout;

public class IO {
    private static IO instance = null;
    public static final int driveControllerPort = 0;
    public static final int ballControllerPort = 1;

    public static final Joystick driveController = new Joystick(driveControllerPort);
    public static final Joystick ballController = new Joystick(ballControllerPort);

    GamepadLayout driveLayout = new SwitchProLayout(); //drive controller layout
    GamepadLayout ballLayout = new SwitchProLayout(); //tennis ball controller layout
    ButtonMapping intakeIn;
    ButtonMapping intakeOut;
    private IO() {
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
