package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Sky Stone TeleOp", group = "sky stone")
public class SkyStoneTeleOp extends OpMode {

    DcMotor lfMotor, rfMotor, lrMotor, rrMotor, verticalLift, horizontalLift, tapeMotor;

    double Vertical;
    float Horizontal;
    float Pivot;

    double Out;
    double Up;

    Servo gripper, lefttray, righttray;


    @Override
    public void init() {

        lfMotor = hardwareMap.dcMotor.get("lf");
        rfMotor = hardwareMap.dcMotor.get("rf");
        lrMotor = hardwareMap.dcMotor.get("lr");
        rrMotor = hardwareMap.dcMotor.get("rr");
        verticalLift = hardwareMap.dcMotor.get("vertical");
        horizontalLift = hardwareMap.dcMotor.get("horizontal");
        tapeMotor = hardwareMap.dcMotor.get("tape");

        gripper = hardwareMap.servo.get("gripper");
        lefttray = hardwareMap.servo.get("lefttray");
        righttray = hardwareMap.servo.get("righttray");

        lfMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        lrMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        verticalLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        horizontalLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

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

        if (gamepad1.right_trigger !=0) {
            tapeMotor.setPower(1);
        } else {
            tapeMotor.setPower(0);
        }

        if (gamepad1.left_trigger !=0) {
            tapeMotor.setPower(-1);
        } else {
            tapeMotor.setPower(0);
        }

        if (gamepad1.a) {
            lefttray.setPosition(0.2);
            righttray.setPosition(0.2);
        } else if (gamepad1.b) {
            lefttray.setPosition(0.6);
            righttray.setPosition(0.7);
        }

        Out = -gamepad2.left_stick_y;
        horizontalLift.setPower(Out);

        Up = -gamepad2.right_stick_y;
        verticalLift.setPower(Up);

        if (gamepad2.a) {
            gripper.setPosition(0.4);
        }

        if (gamepad2.b) {
            gripper.setPosition(0.8);
        }


    }
}
