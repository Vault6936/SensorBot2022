package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmsSubsystem extends SubsystemBase
{
    private final MotorController armPulley = new WPI_VictorSPX(Constants.CanIds.INTAKE_PULLEY);
    private ArmsState state = ArmsState.STOP;

    public void setState(ArmsState state) {
        switch (state) {
            case UP:
                armPulley.set(Constants.ArmPulleySpeed);
                break;
            case DOWN:
                armPulley.set(-1.0 * Constants.ArmPulleySpeed);
                break;
            case STOP:
                armPulley.set(0.0);
        }
    }

    public enum ArmsState
    {
        UP,
        DOWN,
        STOP
    }
}
