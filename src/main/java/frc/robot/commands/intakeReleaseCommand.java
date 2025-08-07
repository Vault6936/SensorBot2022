// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;


/** An example command that uses an example subsystem. */
public class intakeReleaseCommand extends Command
{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final IntakeSubsystem subsystem;
    public IntakeSubsystem.State state = IntakeSubsystem.State.IDLE;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public intakeReleaseCommand(IntakeSubsystem subsystem, IntakeSubsystem.State state)
    {
        this.subsystem = subsystem;
        this.state = state;
//        switch (state) {
//            case IN:
//                subsystem.setState(IntakeSubsystem.State.IN);
//                break;
//            case OUT:
//                subsystem.setState(IntakeSubsystem.State.OUT);
//            case IDLE:
//                subsystem.setState(IntakeSubsystem.State.IDLE);
//        }
//         Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}
    
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
//        subsystem.intake();
    }
    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
    
    
    // Returns true when the command should end.
    @Override
    public boolean isFinished()
    {
        return false;
    }
}
