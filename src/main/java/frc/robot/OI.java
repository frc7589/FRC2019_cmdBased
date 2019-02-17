/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.*;
import frc.robot.Robot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public XboxController stick = new XboxController(0);
  public Button back = new JoystickButton(stick, 7);    //back button for camera change
  public Button rBumper = new JoystickButton(stick, 6); //right bumper for speedmode fast
  public Button lBumper = new JoystickButton(stick, 5); //left bumber for speedmode slow

  public Button btnA = new JoystickButton(stick, 1);    //button A for get the cargo
  public Button btnB = new JoystickButton(stick, 2);    //button B for put the cargo
  public Button btnX = new JoystickButton(stick, 3);    //button X for put the rocket hatch
  public Button btnY = new JoystickButton(stick, 4);    //button Y for get the rocket hatch

  public Button POV0 = new POVButton(stick, 0);         //POV button at 0 degree for lift the slide rail
  public Button POV90 = new POVButton(stick, 90);       //POV button at 90 dergee that make the slide rail slide right
  public Button POV180 = new POVButton(stick, 180);     //POV button at 180 degree for drop the slide rail
  public Button POV270 = new POVButton(stick, 270);     //POV button at 270 dergee that make the slide rail slide left

  public JoystickTrigger trgRight = new JoystickTrigger(stick, Hand.kRight, 0.1);
  public JoystickTrigger trgLeft = new JoystickTrigger(stick, Hand.kLeft, 0.1);

  public OI(){
    rBumper.whenPressed(new speedHighCmd());
    lBumper.whenPressed(new speedLowCmd());

    Command getCargoCmd = new GetCargoCmd();
    btnA.whenPressed(getCargoCmd);
    btnA.whenReleased(new CancelCmd(getCargoCmd));
    Command putCargoCmd = new PutCargoCmd();
    btnB.whenPressed(putCargoCmd);
    btnB.whenReleased(new CancelCmd(putCargoCmd));

    Command putHatchCmd = new PutHatchCmd();
    btnX.whenPressed(putHatchCmd);
    btnX.whenReleased(new CancelCmd(putHatchCmd));
    Command getHatchCmd = new GetHatchCmd();
    btnY.whenPressed(getHatchCmd);
    btnY.whenReleased(new CancelCmd(getHatchCmd));
    
    Command shiftRightCmd = new ShiftRightCmd();
    POV90.whenPressed(shiftRightCmd);
    POV90.whenReleased(new CancelCmd(shiftRightCmd));
    Command shiftLeftCmd = new ShiftLeftCmd();
    POV270.whenPressed(shiftLeftCmd);
    POV270.whenReleased(new CancelCmd(shiftLeftCmd));

    Command liftCmd = new LiftCmd();
    POV0.whenPressed(liftCmd);
    POV0.whenReleased(new CancelCmd(liftCmd));
    Command dropCmd = new DropCmd();
    POV180.whenPressed(dropCmd);
    POV180.whenReleased(new CancelCmd(dropCmd));

    //Command putHatchCmd = new PutHatchCmd();
    trgLeft.whenPressed(putHatchCmd);
    trgLeft.whenReleased(new CancelCmd(putHatchCmd));
    //if(stick.getTriggerAxis(Hand.kRight)>=0.1){
    //  new PutHatchCmd();
    //}
    //Command catchHatchCmd = new CatchHatchCmd();
    trgRight.whenPressed(getHatchCmd);
    trgRight.whenReleased(new CancelCmd(getHatchCmd));
    //if(stick.getTriggerAxis(Hand.kLeft)>=0.1){
    //  new CatchHatchCmd();
    //}
    
  }

  public double getLeftDrive() {
    return stick.getY(Hand.kLeft);
  }
  public double getRightDrive() {
    return stick.getY(Hand.kRight);
  }
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // Thnere are a few additioal built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
