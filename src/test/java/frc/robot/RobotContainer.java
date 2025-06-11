// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

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
    private final TurretSubsystem turretSubsystem = new TurretSubsystem();
    private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    private final PayloadSubsystem payloadSubsystem = new PayloadSubsystem();
    private final ArmsSubsystem armsSubsystem = new ArmsSubsystem();

    private final driveCommand driveCommand = new driveCommand(driveSubsystem, ()-> io.driveYVel.getRawValue(), ()-> io.driveXVel.getRawValue(), ()-> io.driveRot.getRawValue()); //done

    private final ArmsCommand armUpCommand = new ArmsCommand(armsSubsystem, ArmsSubsystem.ArmsState.UP);
    private final ArmsCommand armDownCommand = new ArmsCommand(armsSubsystem, ArmsSubsystem.ArmsState.DOWN);
    private final intakeCommand frontIntakeInCommand = new intakeCommand(intakeSubsystem, IntakeSubsystem.State.IN, IntakeSubsystem.Intakes.INTAKE_FRONT);
    private final intakeCommand frontIntakeIdleCommand = new intakeCommand(intakeSubsystem, IntakeSubsystem.State.IDLE, IntakeSubsystem.Intakes.INTAKE_FRONT);
    private final intakeCommand backIntakeInCommand = new intakeCommand(intakeSubsystem, IntakeSubsystem.State.IN, IntakeSubsystem.Intakes.INTAKE_BACK);
    private final intakeCommand backIntakeIdleCommand = new intakeCommand(intakeSubsystem, IntakeSubsystem.State.IDLE, IntakeSubsystem.Intakes.INTAKE_BACK);
    private final intakeCommand frontIntakeOutCommand = new intakeCommand(intakeSubsystem, IntakeSubsystem.State.OUT, IntakeSubsystem.Intakes.INTAKE_FRONT);
    private final intakeCommand backIntakeOutCommand = new intakeCommand(intakeSubsystem, IntakeSubsystem.State.OUT, IntakeSubsystem.Intakes.INTAKE_BACK);
    private final payloadCommand payloadUpCommand = new payloadCommand(payloadSubsystem, PayloadSubsystem.State.UP);
    private final payloadCommand payloadDownCommand = new payloadCommand(payloadSubsystem, PayloadSubsystem.State.DOWN);
    private final payloadCommand payloadIdleCommand = new payloadCommand(payloadSubsystem, PayloadSubsystem.State.IDLE);
    private final turretCommand turretCommand = new turretCommand(turretSubsystem, ()-> io.turretHor.getRawValue(), ()-> io.turretVert.getRawValue());

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
        io.frontIntakeIn.getButton().whileTrue(frontIntakeInCommand).onFalse(frontIntakeIdleCommand);
        io.backIntakeIn.getButton().whileTrue(backIntakeInCommand).onFalse(backIntakeIdleCommand);
        io.frontIntakeOut.getButton().whileTrue(frontIntakeOutCommand).onFalse(frontIntakeIdleCommand);
        io.backIntakeOut.getButton().whileTrue(backIntakeOutCommand).onFalse(backIntakeIdleCommand);
        io.shooter.getButton().whileTrue(beginShootingCommand).onFalse(stopShootingCommand);
        io.payloadUp.getButton().whileTrue(payloadUpCommand).onFalse(payloadIdleCommand);
        io.payloadDown.getButton().whileTrue(payloadDownCommand).onFalse(payloadIdleCommand);
        io.armUp.getButton().whileTrue(armUpCommand).onFalse(new InstantCommand(armUpCommand::cancel));
        io.armDown.getButton().whileTrue(armDownCommand).onFalse(new InstantCommand(armDownCommand::cancel));
        // Add button to command mappings here.
        // See https://docs.wpilib.org/en/stable/docs/software/Commandd/binding-commands-to-triggers.html
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
