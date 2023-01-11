// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class driveSubsystem extends SubsystemBase
{
    MotorController frM = new WPI_TalonSRX(Constants.CanIds.DRIVE_MOTOR_FRONT_RIGHT);
    MotorController flM = new WPI_TalonSRX(Constants.CanIds.DRIVE_MOTOR_FRONT_LEFT);
    MotorController brM = new WPI_VictorSPX(Constants.CanIds.DRIVE_MOTOR_BACK_RIGHT);
    MotorController blM = new WPI_TalonSRX(Constants.CanIds.DRIVE_MOTOR_BACK_LEFT);
    MotorControllerGroup leftSide = new MotorControllerGroup(flM, blM);
    MotorControllerGroup rightSide = new MotorControllerGroup(frM, brM);

    final DifferentialDrive base;

    double lastYVel = 0;
    double lastXVel = 0;

    double maxVelAccel = 1; //set very high since SensorBot won't have a top

    /** Creates a new subsystem. */
    public driveSubsystem() {
        frM.setInverted(true);
        brM.setInverted(true);
        base = new DifferentialDrive(leftSide, rightSide);

    }
    
    
    @Override
    public void periodic()
    {
        // This method will be called once per scheduler run
    }

    public void drivePeriodic(double yVel, double xVel)
    {
        yVel *= -0.6;
        xVel *= 0.6;
        yVel = MathUtil.clamp(yVel, this.lastYVel - this.maxVelAccel, this.lastYVel + this.maxVelAccel);
        xVel = MathUtil.clamp(xVel, this.lastXVel - this.maxVelAccel, this.lastXVel + this.maxVelAccel);
        yVel = MathUtil.clamp(yVel, -1. * Constants.maxSpeed, Constants.maxSpeed);
        xVel = MathUtil.clamp(xVel, -1. * Constants.maxSpeed, Constants.maxSpeed);
        base.tankDrive(yVel, xVel);
        this.lastYVel = yVel;
        this.lastXVel = xVel;
    }
}
