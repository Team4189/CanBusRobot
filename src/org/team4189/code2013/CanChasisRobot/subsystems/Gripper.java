/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team4189.code2013.CanChasisRobot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;
/**
 *
 * @author hal
 */
public class Gripper extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Relay gripperRelay;
    
    public Gripper(){
        gripperRelay = new Relay(1);
        gripperRelay.setDirection(Relay.Direction.kBoth);
    }
    public void openGripper()
    {
        gripperRelay.set(Relay.Value.kForward);
    }
    
    public void closeGripper()
    {
       gripperRelay.set(Relay.Value.kReverse);
    }
    public void stopGripper()
    {
        gripperRelay.set(Relay.Value.kOff);
    }
    
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}