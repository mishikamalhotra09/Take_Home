package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Command.RunCommand;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.Joystick;


public class DriveTrain extends SubsystemBase {

  private CANSparkMax frontRight = new CANSparkMax(1, motorType);
  private CANSparkMax backRight = new CANSparkMax(2, motorType);
  private CANSparkMax frontLeft = new CANSparkMax(3, motorType);
  private CANSparkMax frontLeft = new CANSparkMax(4, motorType);
  private Joystick controller = new Joystick(0);
  private DifferentialDrive drive;
  private double forward, rotation;
  private Robot robot;

  public static Command run15Secs = new RunCommand(driveSystem.arcadeDrive(forward, 0));

  public DriveTrain(){
    arcadeValues();
    backRight.follow(frontRight);
    backLeft.follow(frontLeft);
    drive = new DifferentialDrive(frontLeft, frontRight);
    long msToRun = 15000;
    long startingTime = Utility.getFPGATime();
    while (Utility.getFPGATime() - startingTime <= millisecondsToRun){
      run15Secs.excecute();
    robot.rotateBy(180);
    }
  }

  public arcadeValues(){
    forward = -controller.getY();
    rotation = -controller.getX();
  }
}