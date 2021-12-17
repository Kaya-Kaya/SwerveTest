package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;

public class WheelDrive extends SubsystemBase {
    
    private Talon angleMotor;
    private Talon speedMotor;
    private PIDController pidController;
    private AnalogInput encoder;

    public WheelDrive(int speedMotor, int angleMotor, int encoder){
        this.angleMotor = new Talon(angleMotor);
        this.speedMotor = new Talon(speedMotor);

        pidController = new PIDController(1, 0, 0);
        this.encoder = new AnalogInput(encoder);

        pidController.enableContinuousInput(0, Constants.MAX_VOLTS);
    }

    public void drive(double speed, double angle){
        speedMotor.set(speed);

        //convert angle to a value between 0 and MAX_VOLTS
        double setpoint = angle * (Constants.MAX_VOLTS * 0.5) + (Constants.MAX_VOLTS * 0.5);
        if(setpoint < 0){
            setpoint = Constants.MAX_VOLTS + setpoint;
        }
        if(setpoint > Constants.MAX_VOLTS){
            setpoint = setpoint - Constants.MAX_VOLTS;
        }

        angleMotor.set(MathUtil.clamp(pidController.calculate(encoder.getVoltage(), setpoint), -1, 1));
    }

}
