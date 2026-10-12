// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
//import com.revrobotics.CANSparkMax;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

//import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.PS4Controller.Axis;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.motorcontrol.Spark;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  //deviceId
  //SparkMax frontLeft = new SparkMax(2, SparkLowLevel.MotorType.kBrushed);
 // SparkMax frontRight = new SparkMax(3, SparkLowLevel.MotorType.kBrushed);
  SparkMax backLeft = new SparkMax(4, SparkLowLevel.MotorType.kBrushed);
  //SparkMax backRight = new SparkMax(5, SparkLowLevel.MotorType.kBrushed);
  //WPI_TalonSRX leftLeader = new WPI_TalonSRX(5);
  //WPI_TalonSRX rightLeader = new WPI_TalonSRX(6);

  DifferentialDrive drive;

  Joystick xBoxController = new Joystick(0); //

  public Robot() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
double speed = xBoxController.getRawAxis(1); //
double turn = xBoxController.getRawAxis(4); //

double left = speed + turn; //
double right = speed - turn; //

    //frontLeft.set(left);
    backLeft.set(left);
    // frontRight.set(-right);
    // backRight.set(-right);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
