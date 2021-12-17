// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.SwerveDriveCommand;
import frc.robot.subsystems.SwerveDrive;
import frc.robot.subsystems.WheelDrive;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private Joystick leftJoystick = new Joystick(0);
  private Joystick rightJoystick = new Joystick(0);

  private WheelDrive backRight = 
    new WheelDrive(Constants.backRightSpeedMotorPort, Constants.backRightAngleMotorPort, Constants.backRightEncoderPort);
  private WheelDrive backLeft = 
    new WheelDrive(Constants.backLeftSpeedMotorPort, Constants.backLeftAngleMotorPort, Constants.backLeftEncoderPort);
  private WheelDrive frontRight = 
    new WheelDrive(Constants.frontRightSpeedMotorPort, Constants.frontRightAngleMotorPort, Constants.frontRightEncoderPort);
  private WheelDrive frontLeft = 
    new WheelDrive(Constants.frontLeftSpeedMotorPort, Constants.frontLeftAngleMotorPort, Constants.frontLeftEncoderPort);

  private final SwerveDrive swerveDrive = new SwerveDrive(backRight, backLeft, frontRight, frontLeft);
  private SwerveDriveCommand swerveDriveCommand = new SwerveDriveCommand(swerveDrive, leftJoystick, rightJoystick);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    swerveDrive.setDefaultCommand(swerveDriveCommand);
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
