// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class IntakeSubsystem extends SubsystemBase
{
    public static enum State {
        IN,
        OUT,
        IDLE
    }
    MotorController vert = new WPI_VictorSPX(314159);
    MotorController intake = new WPI_VictorSPX(271828);

    Servo setup = new Servo(3);

    private State state = State.IDLE;
    private final double inSpeed = 0.45;
    private final double outSpeed = -0.45;

    public IntakeSubsystem() {}
    
    public void setState(State state) {
        this.state = state;
    }

    public void intakePeriodic() {
        switch (state) {
            case IN:
                intake.set(inSpeed);
                break;
            case OUT:
                intake.set(outSpeed);
                break;
            case IDLE:
                intake.set(0);
                break;
        }
    }

    public void vertPeriodic() {
        switch (state) {
            case IN:
                vert.set(inSpeed);
                break;
            case OUT:
                vert.set(outSpeed);
                break;
            case IDLE:
                vert.set(0);
                break;
            }
        }

    public void releaseIntake() {
        setup.setAngle(Constants.servoAngle);
    }
    public void storeIntake() {
        setup.setAngle(0);
    }
}


