package frc.robot;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType; 
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.PS4Controller.Axis;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */

 //Funcao executada quando o robo liga
public class Robot extends TimedRobot {
  
  //definicao dos motores
  SparkMax frontLeft = new SparkMax(2, MotorType.kBrushed);
  SparkMax frontRight = new SparkMax(4, MotorType.kBrushed);
  SparkMax backLeft = new SparkMax(3, MotorType.kBrushed);
  SparkMax backRight = new SparkMax(5, MotorType.kBrushed);
  SparkMax negocioQueEmpurra = new SparkMax(6, MotorType.kBrushed);

  DifferentialDrive drive;

  //definicao do joystick
  Joystick xBoxController = new Joystick(0); //

  //Criar variavel para guardar o tempo
  double startTime;

  public Robot() {}

  @Override
  public void robotPeriodic() {}

  //quando o robo entra no modo autonomo
  @Override
  public void autonomousInit() {
    //atribui a variavel startTime o tempo que o robo entrou no modo autonomo
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void autonomousPeriodic() {

    //variavel para medir o tempo desde que o robo ligou
    double time = Timer.getFPGATimestamp();

    if (time - startTime < 3) {
      frontLeft.set(0.6);
      backLeft.set(0.6);
      frontRight.set(-0.6);
      backRight.set(-0.6);
    } else {
      frontLeft.set(0);
      backLeft.set(0);
      frontRight.set(0);
      backRight.set(0);
    }
  }

  @Override
  public void teleopInit() {}


  //quando o robo entra no modo teleoperado
  @Override
  public void teleopPeriodic() {
double speed = xBoxController.getRawAxis(1); //eixo 1 = L3 pra frente e pra tras
double turn = xBoxController.getRawAxis(4); //eixo 4 = R3 pros lado

//definicao dos botoes do negocio que empurra
boolean directionFront = xBoxController.getRawButton(2); //botao 2 = B
boolean directionBack = xBoxController.getRawButton(3); // botao 3 = X

//se um botao estiver pressionado, o negocio que empurra anda para frente ou para tras
if (directionFront) {
   negocioQueEmpurra.set(1);
 } else if (directionBack) {
   negocioQueEmpurra.set(-1);
  
 } else {
   negocioQueEmpurra.set(0);
 }

 
 double speedLimit = 0.5; // 40% da velocidade máxima
 double turnLimit = 0.45;  // também pode limitar a curva
 
 speed *= speedLimit;
 turn *= turnLimit;

double left = speed - turn; //
double right = speed + turn; //

    frontLeft.set(left);
    backLeft.set(left);
    frontRight.set(-right);
    backRight.set(-right);

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
