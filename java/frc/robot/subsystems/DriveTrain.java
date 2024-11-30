package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Command.RunCommand;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSPX;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Utility;


public class DriveTrain extends SubsystemBase {
  private WPI_TalonSRX rightWheels, leftWheels;
  private DifferentialDrive driveSystem = new DifferentialDrive(leftWheels, rightWheels);
  private CANSparkMax controller = new CANSparkMax (deviceID, motorType);
  private double speed, forward, rotation;
  private double[] values;
  private Robot robot;


  public DriveTrain(){
    arcadeValues(controller);
    long millisecondsToRun = 15000;
    long startingTime = Utility.getFPGATime();
    while (Utility.getFPGATime() - startingTime <= millisecondsToRun){
      run15Secs.excecute();
    robot.rotateBy(180);
    
  }

  public static Command run15Secs = new RunCommand(driveSystem.arcadeDrive(forward, 0));


  public void arcadeValues(CANSparkMax controller){
    speed = controller.get();
    values = controller.ControlType[] values();
    rotation = values[1];
    forward = Math.sqrt(Math.pow(speed, 2) - Math.pow(forward, 2));

    driveSystem.arcadeDrive(-forward, -rotation);

  }

  }  

}