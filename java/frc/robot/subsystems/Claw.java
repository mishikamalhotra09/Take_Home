// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import com.revrobotics.CANSparkMax;


public class Claw extends SubsystemBase {
  private WPI_VictorSPX leftMotor = new WPI_VictorSPX(port);
  private WPI_VictorSPX rightMotor = new WPI_VictorSPX(port);
  private Compressor c = new Compressor();
  private Solenoid rightClaw = new Solenoid(port);
  private Solenoid leftClaw = new Solenoid(port);
  CANSparkMax controller = new CANSparkMax();
  private int BTN_A = 0;


  public Claw() {
    c.start();
    toggleClawButton.whenPressed(toggleClaw);
  }

  JoystickButton toggleClawButton = new JoystickButton(controller, 0);

  public static Command toggleClaw = InstantCommand(() -> subsystems.Claw.toggle(), subsystems.Claw);


  public void toggle() {
    rightClaw.toggle();
    leftClaw.toggle();
  }


}
