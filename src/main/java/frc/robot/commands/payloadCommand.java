// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PayloadSubsystem;


/** An example command that uses an example subsystem. */
public class payloadCommand extends Command
{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final PayloadSubsystem subsystem;
    public PayloadSubsystem.State state = PayloadSubsystem.State.IDLE;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public payloadCommand(PayloadSubsystem subsystem, PayloadSubsystem.State state)
    {
        this.subsystem = subsystem;
        this.state = state;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}
    
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute()
    {
        subsystem.setState(state);
    }
    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

}
