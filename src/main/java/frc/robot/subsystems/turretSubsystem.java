// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class turretSubsystem extends SubsystemBase
{
    MotorController hor = new WPI_VictorSPX(23);
    MotorController vert = new WPI_VictorSPX(22);

    /** Creates a new subsystem. */
    public turretSubsystem() {}
    
    
    @Override
    public void periodic()
    {
        // This method will be called once per scheduler run
    }

    public void turretPeriodic(double horVel, double vertVel)
    {
        horVel *= 0.6;
        vertVel *= 0.6;
        hor.set(horVel);
        vert.set(vertVel);
    }
}
