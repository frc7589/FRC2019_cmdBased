/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.PutHatchCmd;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  public static WPI_VictorSPX leftmotor1 = new WPI_VictorSPX(0);
  public static WPI_VictorSPX leftmotor2 = new WPI_VictorSPX(2);
  public static WPI_VictorSPX rightmotor1 = new WPI_VictorSPX(1);
  public static WPI_VictorSPX rightmotor2 = new WPI_VictorSPX(3);

  //public static SpeedControllerGroup left = new SpeedControllerGroup(leftmotor1, leftmotor2);
  //public static SpeedControllerGroup right = new SpeedControllerGroup(rightmotor1, rightmotor2);

  public static DifferentialDrive base = new DifferentialDrive(leftmotor1, rightmotor1);

  public static WPI_VictorSPX cargoMotor1 = new WPI_VictorSPX(9);
  public static WPI_VictorSPX cargoMotor2 = new WPI_VictorSPX(10);

  //public static WPI_VictorSPX rocketFirst = new WPI_VictorSPX(10);

  public static WPI_VictorSPX liftMotor1 = new WPI_VictorSPX(5);
  public static WPI_VictorSPX liftMotor2 = new WPI_VictorSPX(7);

  public static SpeedControllerGroup liftMotor = new SpeedControllerGroup(liftMotor1, liftMotor2);

  public static WPI_VictorSPX panMotor = new WPI_VictorSPX(4);

  public static WPI_VictorSPX hatchMotor = new WPI_VictorSPX(6);

  public static Encoder enc = new Encoder(0, 1, true, EncodingType.k2X);
}
