// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.*;
import frc.robot.subsystems.driveSubsystem;
import frc.robot.subsystems.turretSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{

    public static IO io = IO.getInstance();

    private final driveSubsystem driveSubsystem = new driveSubsystem();
    private final turretSubsystem turretSubsystem = new turretSubsystem();
    private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

    private final driveCommand driveCommand = new driveCommand(driveSubsystem, ()-> io.driveYVel.getRawValue(), ()-> io.driveXVel.getRawValue(), ()-> io.driveRot.getRawValue()); //done
    
    private final intakeCommand frontIntakeInCommand = new intakeCommand(intakeSubsystem, IntakeSubsystem.State.IN, IntakeSubsystem.Intakes.INTAKE_FRONT); //done
    private final intakeCommand frontIntakeIdleCommand = new intakeCommand(intakeSubsystem, IntakeSubsystem.State.IDLE, IntakeSubsystem.Intakes.INTAKE_FRONT); //done
    private final intakeCommand backIntakeInCommand = new intakeCommand(intakeSubsystem, IntakeSubsystem.State.IN, IntakeSubsystem.Intakes.INTAKE_BACK); //done
    private final intakeCommand backIntakeIdleCommand = new intakeCommand(intakeSubsystem, IntakeSubsystem.State.IDLE, IntakeSubsystem.Intakes.INTAKE_BACK); //done
    private final intakeCommand frontIntakeOutCommand = new intakeCommand(intakeSubsystem, IntakeSubsystem.State.OUT, IntakeSubsystem.Intakes.INTAKE_FRONT); //done
    private final intakeCommand backIntakeOutCommand = new intakeCommand(intakeSubsystem, IntakeSubsystem.State.OUT, IntakeSubsystem.Intakes.INTAKE_BACK); //done
    private final turretCommand turretCommand = new turretCommand(turretSubsystem, ()-> io.turretHor.getRawValue(), ()-> io.turretVert.getRawValue()); //3 and 4 are just placeholders for now

    private final shooterCommand beginShootingCommand = new shooterCommand(turretSubsystem, true);
    private final shooterCommand stopShootingCommand = new shooterCommand(turretSubsystem, false);

    //private final Command autoCommand = new ParallelCommandGroup(driveCommand);
    /** The container for the robot. Contains subsystems, OI devices, and commands. */

    public RobotContainer()
    {
        // Configure the button bindings
        SmartDashboard.putString("booted", "Robot booted successfully.");
        configureButtonBindings();
        Constants.commandScheduler.setDefaultCommand(driveSubsystem, driveCommand);
        Constants.commandScheduler.setDefaultCommand(turretSubsystem, turretCommand);
    }
    
    
    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings()
    {
        io.frontIntakeIn.getButton().whenPressed(frontIntakeInCommand).whenReleased(frontIntakeIdleCommand);
        io.backIntakeIn.getButton().whenPressed(backIntakeInCommand).whenReleased(backIntakeIdleCommand);
        io.frontIntakeOut.getButton().whenPressed(frontIntakeOutCommand).whenReleased(frontIntakeIdleCommand);
        io.backIntakeOut.getButton().whenPressed(backIntakeOutCommand).whenReleased(backIntakeIdleCommand);
        io.shooter.getButton().whenPressed(beginShootingCommand).whenReleased(stopShootingCommand);
        // Add button to command mappings here.
        // See https://docs.wpilib.org/en/stable/docs/software/commandbased/binding-commands-to-triggers.html
    }
    
    
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        // An ExampleCommand will run in autonomous
        return driveCommand;
    }
}
