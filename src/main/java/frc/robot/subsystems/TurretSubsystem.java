// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TurretSubsystem extends SubsystemBase
{
    MotorController hor = new WPI_VictorSPX(Constants.CanIds.PAYLOAD_HORIZONTAL_AIM); //replace all the ids below with the correct numbers
    MotorController vert = new CANSparkMax(Constants.CanIds.PAYLOAD_VERTICAL_AIM, CANSparkMaxLowLevel.MotorType.kBrushed);
    MotorController shooter_front = new CANSparkMax(Constants.CanIds.LAUNCHER_WHEEL_FRONT, CANSparkMaxLowLevel.MotorType.kBrushless);
    MotorController shooter_back = new CANSparkMax(Constants.CanIds.LAUNCHER_WHEEL_BACK, CANSparkMaxLowLevel.MotorType.kBrushless);

    /** Creates a new subsystem. */
    public TurretSubsystem() {}
    
    
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
    public void shoot(double vel)
    {
        shooter_front.set(vel);
        shooter_back.set(vel);
    }
}
