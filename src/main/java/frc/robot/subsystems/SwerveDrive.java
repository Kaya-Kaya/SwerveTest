// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveDrive extends SubsystemBase {

  private WheelDrive backRight;
  private WheelDrive backLeft;
  private WheelDrive frontRight;
  private WheelDrive frontLeft;

  public SwerveDrive(WheelDrive backRight, WheelDrive backLeft, WheelDrive frontRight, WheelDrive frontLeft) {
    this.backRight = backRight;
    this.backLeft = backLeft;
    this.frontRight = frontRight;
    this.frontLeft = frontLeft;
  }

  public void drive(double x1, double y1, double x2){
    //x1 - left joystick strafe
    //y1 - left joystick forwards/backwards
    //x2 - right joystick turning

    double r = Math.sqrt((Constants.L * Constants.L) + (Constants.W * Constants.W));
    y1 *= -1;

    double a = x1 - x2 * (Constants.L / r);
    double b = x1 + x2 * (Constants.L / r);
    double c = y1 - x2 * (Constants.W / r);
    double d = y1 + x2 * (Constants.W / r);

    //speeds are between 0 and 1
    double backRightSpeed = Math.sqrt((a * a) + (d * d));
    double backLeftSpeed = Math.sqrt((a * a) + (c * c));
    double frontRightSpeed = Math.sqrt((b * b) + (d * d));
    double frontLeftSpeed = Math.sqrt((b * b) + (c * c));

    //angles between -1 and 1
    double backRightAngle = Math.atan2(a, d) / Math.PI;
    double backLeftAngle = Math.atan2(a, c) / Math.PI;
    double frontRightAngle = Math.atan2(b, d) / Math.PI;
    double frontLeftAngle = Math.atan2(b, c) / Math.PI;

    backRight.drive(backRightSpeed, backRightAngle);
    backLeft.drive(backLeftSpeed, backLeftAngle);
    frontRight.drive(frontRightSpeed, frontRightAngle);
    frontLeft.drive(frontLeftSpeed, frontLeftAngle);
  }
}
