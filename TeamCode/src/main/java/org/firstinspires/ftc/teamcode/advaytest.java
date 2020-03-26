package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

//Created by Advay Nomula 03/19/20

@TeleOp(name = "Advay Op Mode", group = "TeleOp")
public class AdvayTestOpMode extends OpMode {

    DcMotor leftFrontMotor;
    DcMotor rightFrontMotor;
    DcMotor leftRearMotor;
    DcMotor rightRearMotor;
    DcMotor tapeMeasureMotor;


    double leftFrontMotorPower;
    double rightFrontMotorPower;
    double leftRearMotorPower;
    double rightRearMotorPower;
    double tapeMeasureMotorPower;
    double tapeMeasureMotorPowerBack;

    @Override
    public void init() {
        leftFrontMotor = hardwareMap.dcMotor.get("lf");
        rightFrontMotor = hardwareMap.dcMotor.get("rf");
        leftRearMotor = hardwareMap.dcMotor.get("lr");
        rightRearMotor = hardwareMap.dcMotor.get("rr");

        leftFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftRearMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        tapeMeasureMotor = hardwareMap.dcMotor.get("tape_measure");
    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        leftFrontMotorPower = gamepad1.left_stick_y;
        rightFrontMotorPower = gamepad1.right_stick_y;
        leftRearMotorPower = gamepad1.left_stick_y;
        rightRearMotorPower = gamepad1.right_stick_y;

        tapeMeasureMotorPower = gamepad1.right_trigger;
        tapeMeasureMotorPowerBack = gamepad1.right_bumper;

        leftFrontMotor.setPower(leftFrontMotorPower);
        rightFrontMotor.setPower(rightFrontMotorPower);
        leftRearMotor.setPower(leftFrontMotorPower);
        rightRearMotor.setPower(rightFrontMotorPower);

        tapeMeasureMotor.setPower(tapeMeasureMotorPower);
        tapeMeasureMotor.setPower(tapeMeasureMotorPowerBack);
    }

    @Override
    public void stop() {

    }
}
