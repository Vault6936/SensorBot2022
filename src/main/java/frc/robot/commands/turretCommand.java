// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.turretSubsystem;

import java.util.function.DoubleSupplier;


/** An example command that uses an example subsystem. */
public class turretCommand extends CommandBase
{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final turretSubsystem subsystem;
    private final DoubleSupplier horVel;
    private final DoubleSupplier vertVel;


    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public turretCommand(turretSubsystem subsystem, DoubleSupplier horVel, DoubleSupplier vertVel)
    {
        this.subsystem = subsystem;
        this.horVel = horVel;
        this.vertVel = vertVel;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }
    
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}
    
    
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        subsystem.turretPeriodic(horVel.getAsDouble(), vertVel.getAsDouble());
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
