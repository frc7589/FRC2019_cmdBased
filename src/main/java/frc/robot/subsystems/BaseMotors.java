/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.BaseMotorCmd;

/**
 * Add your docs here.
 */
public class BaseMotors extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new BaseMotorCmd());
  }
  private int num = 0;
  private double fMode = 0.6;
  private double mMode = 0.4;
  private double sMode = 0.1;
  public void run(double lspeed,double rspeed){
    System.out.println(num);
    if(num == 2){
      RobotMap.base.tankDrive(-lspeed*fMode, -rspeed*fMode);
    }
    if(num == 1){
      RobotMap.base.tankDrive(-lspeed*mMode, -rspeed*mMode);
    }
    if(num == 0){
      RobotMap.base.tankDrive(-lspeed*sMode, -rspeed*sMode);
    }
  }

  public void setlow(){
    if(num == 2){
      num = 1;
    }
    else if(num == 1){
      num = 0;
    }
  }

  public void sethigh(){
    if(num == 0){
      num = 1;
    }
    else if(num == 1){
      num = 2;
    }
  }

}
