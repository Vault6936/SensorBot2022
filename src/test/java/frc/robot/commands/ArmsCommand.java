package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmsSubsystem;

public class ArmsCommand extends Command
{
    private final ArmsSubsystem subsystem;
    private final ArmsSubsystem.ArmsState state;
    private double startTime;

    public ArmsCommand(ArmsSubsystem subsystem, ArmsSubsystem.ArmsState state)
    {
        this.state = state;
        this.subsystem = subsystem;
    }

    @Override
    public void initialize()
    {
        subsystem.setState(state);
        startTime = Timer.getFPGATimestamp();
    }

    @Override
    public void cancel()
    {
        subsystem.setState(ArmsSubsystem.ArmsState.STOP);
    }

    @Override
    public boolean isFinished()
    {
        if(Timer.getFPGATimestamp() - startTime > 0.75)
        {
            subsystem.setState(ArmsSubsystem.ArmsState.STOP);
            return true;
        }
        return false;
    }
}
