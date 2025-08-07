// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;



import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.driveSubsystem;

import java.util.function.DoubleSupplier;


/** An example command that uses an example subsystem. */
public class driveCommand extends Command
{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final driveSubsystem subsystem;
    private final DoubleSupplier xVel;
    private final DoubleSupplier yVel;
    private final DoubleSupplier rot;

    AHRS ahrs;



    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public driveCommand(driveSubsystem subsystem, DoubleSupplier yVel, DoubleSupplier xVel, DoubleSupplier rot)
    {
        this.subsystem = subsystem;
        this.yVel = yVel;
        this.xVel = xVel;
        this.rot = rot;

        ahrs = new AHRS(SPI.Port.kMXP);

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }
    
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        ahrs.reset();
    }
    
    
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double robotAngleRadians = ahrs.getYaw() * Math.PI/180;
        subsystem.drivePeriodic(yVel.getAsDouble(), xVel.getAsDouble(), rot.getAsDouble(), robotAngleRadians, Constants.FieldCentric);
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
