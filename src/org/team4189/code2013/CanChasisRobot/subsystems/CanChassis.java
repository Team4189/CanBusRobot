/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team4189.code2013.CanChasisRobot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import org.team4189.code2013.CanChasisRobot.commands.CanDriveWithJoysticks;

/**
 *
 * @author hal
 */
public class CanChassis extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private CANJaguar leftJag;
    private CANJaguar rightJag;
    public double p = 10;
    public double i = .01;
    public double d = 0;
    public CanChassis(){
        try{
            canInit();
        }catch(CANTimeoutException e){
            System.out.println("canInit() failed");
        }
    }
    public final void canInit() throws CANTimeoutException {
        leftJag = new CANJaguar(3,CANJaguar.ControlMode.kPercentVbus);
        leftJag.setVoltageRampRate(524);
        leftJag.configNeutralMode(CANJaguar.NeutralMode.kCoast);
        rightJag = new CANJaguar(4, CANJaguar.ControlMode.kPercentVbus);
        rightJag.setVoltageRampRate(524);
        leftJag.configNeutralMode(CANJaguar.NeutralMode.kCoast);
    }
    public void setSpeed(double left, double right){
        try{
            leftJag.setX(left);
            rightJag.setX(right);
        }catch(CANTimeoutException e){
            try{
                canInit();
            }catch(CANTimeoutException f){
                System.out.println("canInit Failed");
            }
        }catch(NullPointerException g){
            try{
                canInit();
            }catch(CANTimeoutException h){
                System.out.println("canInit Failed");
            }
        }
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new CanDriveWithJoysticks());
    }
}