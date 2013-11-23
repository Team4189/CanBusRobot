/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team4189.code2013.CanChasisRobot.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 * @author hal
 */
public class CanDriveWithJoysticks extends CommandBase {
    private Joystick leftStick;
    private Joystick rightStick;
    public CanDriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(chassis);
        leftStick = new Joystick(1);
        rightStick = new Joystick(2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        chassis.setSpeed(leftStick.getY(), rightStick.getY());
        SmartDashboard.putNumber("left raw", leftStick.getY());
        SmartDashboard.putNumber("right raw", rightStick.getY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        chassis.setSpeed(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        chassis.setSpeed(0, 0);
    }
}