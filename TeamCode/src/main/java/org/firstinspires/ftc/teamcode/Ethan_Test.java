package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Ethans Auto", group = "")
public class Ethan_Test extends LinearOpMode {

    DcMotor Front_Left;
    DcMotor Front_Right;
    DcMotor Back_Left;
    DcMotor Back_Right;



    @Override
    public void runOpMode() throws InterruptedException{

        Front_Left = hardwareMap.dcMotor.get("lf");
        Front_Right = hardwareMap.dcMotor.get("rf");
        Back_Left = hardwareMap.dcMotor.get("lr");
        Back_Right = hardwareMap.dcMotor.get("rr");

        Front_Right.setDirection(DcMotorSimple.Direction.REVERSE);
        Front_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        Back_Left.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        Front_Left.setPower(1);
        Front_Right.setPower(1);
        Back_Left.setPower(1);
        Back_Right.setPower(1);
        sleep(1000);
        Front_Left.setPower(-1);
        Front_Right.setPower(-1);
        Back_Left.setPower(-1);
        Back_Right.setPower(-1);
        sleep(1000);
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
        telemetry.update();
    }
}


