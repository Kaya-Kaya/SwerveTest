package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveDrive;

public class SwerveDriveCommand extends CommandBase {
    
    private final SwerveDrive swerveDrive;
    private final Joystick leftJoystick;
    private final Joystick rightJoystick;

    public SwerveDriveCommand(final SwerveDrive swerveDrive, final Joystick leftJoystick, final Joystick rightJoystick){
        this.swerveDrive = swerveDrive;
        this.leftJoystick = leftJoystick;
        this.rightJoystick = rightJoystick;

        addRequirements(swerveDrive);
    }

    @Override
    public void execute() {
        swerveDrive.drive(leftJoystick.getX(), leftJoystick.getY(), rightJoystick.getX());
    }

}
