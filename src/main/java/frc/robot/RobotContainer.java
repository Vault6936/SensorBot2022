// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.*;
import frc.robot.mappings.ButtonMapping;
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
    // The robot's subsystems and commands are defined here...

    private final driveSubsystem driveSubsystem = new driveSubsystem();
    private final turretSubsystem turretSubsystem = new turretSubsystem();

    private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

    private final Joystick gamepad1 = new Joystick(0);
    private final Joystick gamepad2 = new Joystick(1);



    ButtonMapping intakeIn = new ButtonMapping(gamepad1, IO.intakeInBtn);
    ButtonMapping intakeOut = new ButtonMapping(gamepad1, IO.intakeOutBtn);
    private final driveCommand driveCommand = new driveCommand(driveSubsystem,()-> gamepad1.getRawAxis(1), ()-> gamepad1.getRawAxis(0), ()-> gamepad1.getRawAxis(2));
    
    private final intakeCommand intakeInCommand = new intakeCommand(intakeSubsystem, IntakeSubsystem.State.IN);
    private final intakeCommand intakeIdleCommand = new intakeCommand(intakeSubsystem, IntakeSubsystem.State.IDLE);
    private final turretCommand turretCommand = new turretCommand(turretSubsystem, ()-> gamepad1.getRawAxis(3), ()-> gamepad1.getRawAxis(4)); //3 and 4 are just placeholders for now

    private final Command autoCommand = new ParallelCommandGroup(driveCommand);
    /** The container for the robot. Contains subsystems, OI devices, and commands. */

    public RobotContainer()
    {
        // Configure the button bindings
        SmartDashboard.putString("booted", "Hello from your happy robot.");
        SmartDashboard.getString("booted", "Hello from your unhappy robot.");
        configureButtonBindings();
        CommandScheduler.getInstance().setDefaultCommand(driveSubsystem, driveCommand);
    }
    
    
    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings()
    {
        intakeIn.getButton().whenPressed(intakeInCommand).whenReleased(intakeIdleCommand);
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
