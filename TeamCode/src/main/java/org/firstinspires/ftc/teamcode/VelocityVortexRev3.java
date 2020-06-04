package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Velocity Vortex Rev3", group = "velocity vortex")
public class VelocityVortexRev3 extends OpMode {


    DcMotor lfMotor, lrMotor, rfMotor, rrMotor, intake, ballShooter1, ballShooter2;

    double Vertical;
    float Horizontal;
    float Pivot;

    Servo shooter;

    @Override
    public void init() {

        lfMotor = hardwareMap.dcMotor.get("lf");
        rfMotor = hardwareMap.dcMotor.get("rf");
        lrMotor = hardwareMap.dcMotor.get("lr");
        rrMotor = hardwareMap.dcMotor.get("rr");
        intake = hardwareMap.dcMotor.get("intake");
        ballShooter1 = hardwareMap.dcMotor.get("ballshooter1");
        ballShooter2 = hardwareMap.dcMotor.get("ballshooter2");

        shooter = hardwareMap.servo.get("shooter");

        lfMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        lrMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        ballShooter1.setDirection(DcMotorSimple.Direction.REVERSE);
        intake.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void loop() {

        Vertical = -gamepad1.left_stick_y;
        Horizontal = -gamepad1.left_stick_x;
        Pivot = gamepad1.right_stick_x;

        rfMotor.setPower(-Pivot + (Vertical - Horizontal));
        rrMotor.setPower(-Pivot + Vertical + Horizontal);
        lfMotor.setPower(Pivot + Vertical + Horizontal);
        lrMotor.setPower(Pivot + (Vertical - Horizontal));

        if (gamepad2.right_trigger !=0) {
            shooter.setPosition(0.3);
        } else {
            shooter.setPosition(0.1);
        }

        if (gamepad2.a) {
            ballShooter1.setPower(1);
            ballShooter2.setPower(1);
        } else if (gamepad2.b) {
            ballShooter1.setPower(0);
            ballShooter2.setPower(0);
        }

        if (gamepad2.dpad_up) {
            intake.setPower(1);
        } else if (gamepad2.dpad_down) {
            intake.setPower(-1);
        } else {
            intake.setPower(0);
        }

    }
}