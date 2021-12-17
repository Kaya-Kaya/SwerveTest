// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final double L = 1; //distance between wheel axles on the length
    public static final double W = 1; //distance between wheel axles on the width

    public static final double MAX_VOLTS = 1; //max volts that swerve modules take

    //speed motor ports
    public static final int backRightSpeedMotorPort = 1;
    public static final int backLeftSpeedMotorPort = 1;
    public static final int frontRightSpeedMotorPort = 1;
    public static final int frontLeftSpeedMotorPort = 1;

    //angle motor ports
    public static final int backRightAngleMotorPort = 1;
    public static final int backLeftAngleMotorPort = 1;
    public static final int frontRightAngleMotorPort = 1;
    public static final int frontLeftAngleMotorPort = 1;

    //encoder ports
    public static final int backRightEncoderPort = 1;
    public static final int backLeftEncoderPort = 1;
    public static final int frontRightEncoderPort = 1;
    public static final int frontLeftEncoderPort = 1;
}
