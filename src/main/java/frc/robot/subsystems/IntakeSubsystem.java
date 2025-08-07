// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;

import java.util.ArrayList;
import java.util.List;


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

    private Intakes intakeMotor = Intakes.INTAKE_FRONT;

    private MotorController intakeMotorArray[] = {intake1, intake2};
    private final double outSpeed = -0.35;
    private final double inSpeed = 0.35;

    List<MotorController> motors = new ArrayList<>();

    public IntakeSubsystem() {
        intake1.setInverted(true);
    }

    public void intake(State state, Intakes intakes) {
        motors.clear();
        switch (intakes)
        {
            case INTAKE_FRONT :
                motors.add(intake1);
                break;
            case INTAKE_BACK:
                motors.add(intake2);
                break;
            case BOTH:
                motors.add(intake1);
                motors.add(intake2);
                break;
        }

        for(MotorController m : motors) {
            switch (state) {
                case IN:
                    m.set(outSpeed);
                    break;
                case OUT:
                    m.set(inSpeed);
                    break;
                case IDLE:
                    m.set(0);
                    break;
            }
        }
    }
}
