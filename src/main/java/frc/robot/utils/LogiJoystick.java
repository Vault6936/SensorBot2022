package frc.robot.utils;

import edu.wpi.first.wpilibj2.command.button.Trigger;

import java.util.function.BooleanSupplier;

public class LogiJoystick extends GamepadLayout {

    private static final int btn4 = 4;
    private static final int trigger = 1;
    private static final int btn3 = 3;
    private static final int thumbBtn = 2;
    private static final int btn5 = 5;
    private static final int btn6 = 6;
    private static final int btn7 = 7;
    private static final int btn8 = 8;
    private static final int btn9 = 9;
    private static final int btn10 = 10;
    private static final int btn11 = 11;
    private static final int btn12 = 12;
    private static final int btn13 = 13;
    private static final int btn14 = 14;

    // Note that these refer to the stick button (pushing in the stick), not the axes of the sticks.


    private static final int axsLY = 0;
    private static final int axsLX = 1;
    private static final int axsRX = 2;
    private static final int axsRY = 3;

    public Trigger TurretUp;
    public Trigger TurretDown;
    public LogiJoystick() {
        driveYVel = axsLY;
        driveXVel = axsLX;
        driveRot = axsRX;
        frontIntakeInBtn = btn5;
        frontIntakeOutBtn = btn9;
        backIntakeInBtn = btn5;
        backIntakeOutBtn = btn9;
        turretHor = 2;
        turretVert = 3;
        shooterBtn = trigger;
        payloadUp = btn6;
        payloadDown = btn4;
        armUp = btn11;
        armDown = btn12;
    }
}
