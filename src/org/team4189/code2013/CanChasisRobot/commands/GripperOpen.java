/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team4189.code2013.CanChasisRobot.commands;

/**
 *
 * @author hal
 */
public class GripperOpen extends CommandBase {
    
    public GripperOpen() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(gripper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        gripper.openGripper();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        gripper.stopGripper();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        gripper.stopGripper();
    }
}