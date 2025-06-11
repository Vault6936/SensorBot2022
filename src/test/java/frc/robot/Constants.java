// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final CommandScheduler commandScheduler = CommandScheduler.getInstance();
    public static double maxVelAccel = 0.2;
    public static double maxRotAccel = 0.2;
    public static double maxSpeed = 0.4;
    public static double maxRotation = 0.4;
    public static double servoAngle = 90;
    public static final double deadZoneDefault = 0.05;

    public static double ArmPulleySpeed = 0.6;

    public static int DRIVE_CONTROLLER = 0;
    public static int PAYLOAD_CONTROLLER = 1;


    public static class CanIds
    {
        public static int DRIVE_MOTOR_FRONT_LEFT = 3;
        public static int DRIVE_MOTOR_FRONT_RIGHT = 4;
        public static int DRIVE_MOTOR_BACK_LEFT = 5;
        public static int DRIVE_MOTOR_BACK_RIGHT = 6;
        public static int INTAKE_PULLEY = 7;

        public static int INTAKE_UPTAKE = 18;

        public static int INTAKE_BACK = 19;

        public static int INTAKE_FRONT = 20;

        public static int PAYLOAD_HORIZONTAL_AIM = 21;
        public static int PAYLOAD_VERTICAL_AIM = 24;
        public static int LAUNCHER_WHEEL_FRONT = 22;
        public static int LAUNCHER_WHEEL_BACK = 23;
    }
}
