package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class CancelCmd extends Command {
    private Command target;
    public CancelCmd(Command cmd) {
        target = cmd;
    }

    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        target.cancel();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return true;
    }
}
