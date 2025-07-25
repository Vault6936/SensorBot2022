// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TurretSubsystem extends SubsystemBase
{
    MotorController hor = new WPI_VictorSPX(Constants.CanIds.PAYLOAD_HORIZONTAL_AIM); //replace all the ids below with the correct numbers
    MotorController vert = new SparkMax(Constants.CanIds.PAYLOAD_VERTICAL_AIM, SparkMax.MotorType.kBrushed);
    MotorController shooter_front = new SparkMax(Constants.CanIds.LAUNCHER_WHEEL_FRONT, SparkMax.MotorType.kBrushless);
    MotorController shooter_back = new SparkMax(Constants.CanIds.LAUNCHER_WHEEL_BACK, SparkMax.MotorType.kBrushless);

    /** Creates a new subsystem. */
    public TurretSubsystem() {
        shooter_front.setInverted(false);
    }
    
    
    @Override
    public void periodic()
    {
        // This method will be called once per scheduler run
    }

    public void turretPeriodic(double horVel, double vertVel)
    {
        hor.set(horVel);
        vert.set(vertVel);
    }
    public void shoot(double vel)
    {
        shooter_front.set(vel);
        shooter_back.set(vel);
    }
}
