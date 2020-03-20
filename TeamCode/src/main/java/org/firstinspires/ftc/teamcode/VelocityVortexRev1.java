package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Velocity Vortex rev1", group = "velocity vortex")
public class VelocityVortexRev1 extends OpMode {

    DcMotor lfMotor;
    DcMotor rfMotor;
    DcMotor lrMotor;
    DcMotor rrMotor;
    //DcMotor ballShooterMotor1;
    //DcMotor ballShooterMotor2;
    //DcMotor intakeMotor;

    double lfMotorPower;
    double rfMotorPower;
    double lrMotorPower;
    double rrMotorPower;
    //double ballShooterMotor1Power;
    //double ballShooterMotor2Power;
    //double intakeMotorPower;

    Servo shooterServo;

    double shooterServoPosition;


    @Override
    public void init() {
      lfMotor = hardwareMap.dcMotor.get("lf");
      rfMotor = hardwareMap.dcMotor.get("rf");
      lrMotor = hardwareMap.dcMotor.get("lr");
      rrMotor = hardwareMap.dcMotor.get("rr");
      //ballShooterMotor1 = hardwareMap.dcMotor.get("ballshooter1");
      //ballShooterMotor2 = hardwareMap.dcMotor.get("ballshooter2");
      //intakeMotor = hardwareMap.dcMotor.get("intake");
      shooterServo = hardwareMap.servo.get("shooter");


    }

    @Override
    public void loop() {

    }
}
