package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;

public class JoystickTrigger extends Button {
    XboxController stick;
    Hand hand;
    double thres;
    JoystickTrigger(XboxController joystick, Hand hnd, double threshold) {
        stick = joystick;
        hand = hnd;
        thres = threshold;
    }

    @Override
    public boolean get() {
        return stick.getTriggerAxis(hand)>=thres;
    }
}