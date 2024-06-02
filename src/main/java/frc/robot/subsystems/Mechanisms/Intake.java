package frc.robot.subsystems.Mechanisms;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{
    private TalonFX topMotor;
    private TalonFX bottomMotor;

    public Intake() {
        topMotor = new TalonFX(Constants.IntakeConstants.TopMotorID,"Canivore");
        bottomMotor = new TalonFX(Constants.IntakeConstants.BottomMotorID,"Canivore");
    }

    private void setIntakeSpeed(double speed) {
        topMotor.set(speed);
        bottomMotor.set(-speed);
    }

    public Command On() {
        return Commands.runOnce(()->{setIntakeSpeed(Constants.IntakeConstants.IntakeSpeed);}, this);
    }

    public Command Off() {
        return Commands.runOnce(()->{setIntakeSpeed(0);}, this);
    }
}
