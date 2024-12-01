// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

public class Claw extends SubsystemBase {
  private Compressor c = new Compressor();
  private Solenoid rightClaw = new Solenoid(0);
  private Solenoid leftClaw = new Solenoid(1);
  private Joystick controller = new Joystick(0);
  private int BTN_1 = 0;


  public Claw() {
    c.start();
    toggleClawButton.whenPressed(toggleClaw);
  }

  JoystickButton toggleClawButton = new JoystickButton(controller, BTN_1);

  public static Command toggleClaw = InstantCommand(() -> subsystems.Claw.toggle(), subsystems.Claw);


  public void toggle() {
    rightClaw.toggle();
    leftClaw.toggle();
  }


}
