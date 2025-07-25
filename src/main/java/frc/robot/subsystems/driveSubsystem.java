// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class driveSubsystem extends SubsystemBase
{
    MotorController frM = new WPI_TalonSRX(Constants.CanIds.DRIVE_MOTOR_FRONT_RIGHT);
    MotorController flM = new WPI_TalonSRX(Constants.CanIds.DRIVE_MOTOR_FRONT_LEFT);
    MotorController brM = new WPI_VictorSPX(Constants.CanIds.DRIVE_MOTOR_BACK_RIGHT);
    MotorController blM = new WPI_TalonSRX(Constants.CanIds.DRIVE_MOTOR_BACK_LEFT);

    final MecanumDrive base;

    double lastYVel = 0;
    double lastXVel = 0;

    double lastRot = 0;
    double maxVelAccel = 0.04;

    double maxRotAccel = 0.01;
    /** Creates a new subsystem. */
    public driveSubsystem() {
        frM.setInverted(true);
        flM.setInverted(true);
        base = new MecanumDrive(flM, blM, frM, brM);

    }
    
    
    @Override
    public void periodic()
    {
        // This method will be called once per scheduler run
    }

    public void drivePeriodic(double yVel, double xVel, double rot)
    {
        yVel *= -0.6;
        xVel *= 0.6;
        rot *= 0.6;
        yVel = MathUtil.clamp(yVel, this.lastYVel - this.maxVelAccel, this.lastYVel + this.maxVelAccel);
        xVel = MathUtil.clamp(xVel, this.lastXVel - this.maxVelAccel, this.lastXVel + this.maxVelAccel);
        rot = MathUtil.clamp(rot, this.lastRot - this.maxRotAccel, this.lastRot + this.maxRotAccel);
        yVel = MathUtil.clamp(yVel, -1. * Constants.maxSpeed, Constants.maxSpeed);
        xVel = MathUtil.clamp(xVel, -1. * Constants.maxSpeed, Constants.maxSpeed);
        rot = MathUtil.clamp(rot, -1. * Constants.maxRotation, Constants.maxRotation);
        base.driveCartesian(yVel, xVel, rot);
        this.lastYVel = yVel;
        this.lastXVel = xVel;
        this.lastRot = rot;
    }
}
