// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class driveSubsystem extends SubsystemBase
{
    MotorController frM = new WPI_VictorSPX(23);
    MotorController flM = new WPI_VictorSPX(22);
    MotorController brM = new WPI_VictorSPX(24);
    MotorController blM = new WPI_VictorSPX(21);

    MecanumDrive base = new MecanumDrive(flM, blM, frM, brM);

    double lastYVel = 0;
    double lastXVel = 0;

    double lastRot = 0;
    double maxVelAccel = 0.2;

    double maxRotAccel = 0.2;
    /** Creates a new subsystem. */
    public driveSubsystem() {}
    
    
    @Override
    public void periodic()
    {
        // This method will be called once per scheduler run
    }

    public void drivePeriodic(double yVel, double xVel, double rot)
    {
        yVel *= 0.6;
        xVel *= 0.6;
        rot *= 0.6;
        yVel = MathUtil.clamp(yVel, this.lastYVel - this.maxVelAccel, this.lastYVel + this.maxVelAccel);
        xVel = MathUtil.clamp(xVel, this.lastXVel - this.maxVelAccel, this.lastXVel + this.maxVelAccel);
        rot = MathUtil.clamp(rot, this.lastRot - this.maxRotAccel, this.lastRot + this.maxRotAccel);
        base.driveCartesian(yVel, xVel, rot);
        this.lastYVel = yVel;
        this.lastXVel = xVel;
        this.lastRot = rot;
    }
}
