// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;


public class IntakeSubsystem extends SubsystemBase
{
    public enum State {
        IN,
        OUT,
        IDLE
    }
    public enum Intakes {
        INTAKE_FRONT,
        INTAKE_BACK,
        BOTH
    }
    private static class IntakeReleaseData {
        private double speed = 0;
        private double timeToRun = 0;
        private boolean isRunning = false;
        private Timer timer = new Timer();
        public IntakeReleaseData() {
            timer.reset();
        }
        private void begin(double time) {
            timer.reset();
            timeToRun = time;
            isRunning = true;
        }
        private void update() {
            if(timer.get() >= timeToRun) {
                speed = 0;
                timeToRun = 0;
                isRunning = false;
            }
        }
    }

    MotorController intake1 = new WPI_VictorSPX(Constants.CanIds.INTAKE_FRONT);
    MotorController intake2 = new WPI_VictorSPX(Constants.CanIds.INTAKE_BACK);

    private State state = State.IDLE;

    private Intakes intakeMotor = Intakes.INTAKE_FRONT;

    private MotorController intakeMotorArray[] = {intake1, intake2};
    private final double outSpeed = -0.35;
    private final double inSpeed = 0.35;

    public IntakeSubsystem() {}
    
    public void setState(State state) {
        this.state = state;
    }
    public void setIntakeMotor(Intakes intakeMotor) {
        this.intakeMotor = intakeMotor;
    }

    public void intakePeriodic() {
        // TODO : allow support for both motors.
        switch (state) {
            case IN:
                if(intakeMotor == Intakes.BOTH) {
                    intakeMotorArray[0].set(outSpeed);
                    intakeMotorArray[1].set(outSpeed);
                }
                else {
                    intakeMotorArray[intakeMotor.ordinal()].set(outSpeed);
                }
                break;
            case OUT:
                intakeMotorArray[intakeMotor.ordinal()].set(inSpeed);
                break;
            case IDLE:
                intakeMotorArray[intakeMotor.ordinal()].set(0);
                break;
        }
    }
}
