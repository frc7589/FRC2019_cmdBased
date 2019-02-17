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
  private double prevLSpeed=0.0, prevRSpeed=0.0;

  private double trimMaxAcc(double prevSpd, double speed) {
    final double maxAcc = 0.08;
    final double maxDec = 0.01;
    if (prevSpd>0) {         // dir: positive
      if (speed>prevSpd) {  // acc
        if (speed-prevSpd>maxAcc) speed = prevSpd+maxAcc;
      }
      else if (speed<prevSpd) { // dec
        if (prevSpd-speed>maxDec) speed = prevSpd-maxDec;
      }
    }
    else {  // prevLSpeedSpd<=0    dir: negative
      if (speed<prevSpd) {  // acc
        if (prevSpd-speed>maxAcc) speed = prevSpd-maxAcc;
      }
      else if (speed>prevSpd) { // dec
        if (speed-prevSpd>maxDec) speed = prevSpd+maxDec;
      }
    }
    return speed;
  }

  private void driveTuned(double lspeed, double rspeed, boolean boost) {
    if (!boost) {
      lspeed = trimMaxAcc(prevLSpeed, lspeed);
      rspeed = trimMaxAcc(prevRSpeed, rspeed);
    }
    RobotMap.base.tankDrive(lspeed, rspeed);
    prevLSpeed = lspeed;
    prevRSpeed = rspeed;
  }

  public void runRaw(double lspeed,double rspeed, boolean boost) {
    if(num == 2){
      driveTuned(-lspeed*fMode, -rspeed*fMode, boost);
    }
    if(num == 1){
      driveTuned(-lspeed*mMode, -rspeed*mMode, boost);
    }
    if(num == 0){
      driveTuned(-lspeed*sMode, -rspeed*sMode, boost);
    }
  }

  public void run(double lspeed,double rspeed) {
    runRaw(lspeed, rspeed, false);
  }

  public void runBoosted(double lspeed, double rspeed) {
    runRaw(lspeed, rspeed, true);
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
