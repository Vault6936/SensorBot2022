// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class PayloadSubsystem extends SubsystemBase
{
    MotorController up = new WPI_VictorSPX(Constants.CanIds.INTAKE_UPTAKE);
    private State state = State.IDLE;
    public enum State {
        UP,
        DOWN,
        IDLE
    }

    public PayloadSubsystem() {}
    
    public void setState(State state) {
        this.state = state;
    }
    public State getDirection() {
        return this.state;
    }

    @Override
    public void periodic()
    {
        // This method will be called once per scheduler run
        switch (state) {
            case UP:
                up.set(0.5);
                break;
            case DOWN:
                up.set(-0.5);
                break;
            case IDLE:
                up.set(0);
                break;
        }
    }

    public void payloadPeriodic()
    {
    }
}
