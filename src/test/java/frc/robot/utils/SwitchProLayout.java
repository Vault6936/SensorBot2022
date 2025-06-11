package frc.robot.utils;

public class SwitchProLayout extends GamepadLayout {

    private static final int btnX = 4;
    private static final int btnY = 1;
    private static final int btnA = 3;
    private static final int btnB = 2;
    private static final int btnZL = 7;
    private static final int btnZR = 8;
    private static final int btnL = 5;
    private static final int btnR = 6;
    private static final int btnMINUS = 9;
    private static final int btnPLUS = 10;
    private static final int btnSCREENSHOT = 14;
    private static final int btnHOME = 13;
    // Note that these refer to the stick button (pushing in the stick), not the axes of the sticks.
    private static final int btnLSTICK = 11;
    private static final int btnRSTICK = 12;

    private static final int axsLX = 0;
    private static final int axsLY = 1;
    private static final int axsRX = 2;
    private static final int axsRY = 3;

    public SwitchProLayout() {
        driveYVel = axsLY;
        driveXVel = axsLX;
        driveRot = axsRX;
        frontIntakeInBtn = btnX;
        frontIntakeOutBtn = btnY;
        backIntakeInBtn = btnA;
        backIntakeOutBtn = btnB;
        turretHor = 2;
        turretVert = 3;
        shooterBtn = btnZL;
        payloadUp = btnR;
        payloadDown = btnL;
        armUp = btnPLUS;
        armDown = btnMINUS;
    }
}
