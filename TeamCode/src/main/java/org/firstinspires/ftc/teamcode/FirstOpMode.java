package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="First Tele Op", group = "Practice")
public class FirstOpMode extends OpMode {

    DcMotor lfMotor;
    DcMotor rfMotor;
    DcMotor lrMotor;
    DcMotor rrMotor;
    DcMotor horizontalSlide;
    DcMotor verticalLift;
    DcMotor tapeMotor;

    double lfMotorPower;
    double rfMotorPower;
    double lrMotorPower;
    double rrMotorPower;


    @Override
    public void init() {
        lfMotor = hardwareMap.dcMotor.get("lf_motor");
        rfMotor = hardwareMap.dcMotor.get("rf_motor");
        lrMotor = hardwareMap.dcMotor.get("lr_motor");
        rrMotor = hardwareMap.dcMotor.get("rr_motor");
        horizontalSlide = hardwareMap.dcMotor.get("horizontal_slide");
        verticalLift = hardwareMap.dcMotor.get("vertical_lift");
        tapeMotor = hardwareMap.dcMotor.get("tape_motor");


    }

    @Override
    public void loop() {
        lfMotorPower = gamepad1.left_stick_y;
        rfMotorPower = gamepad1.left_stick_y;
        lrMotorPower = gamepad1.left_stick_y;
        rrMotorPower = gamepad1.left_stick_y;


        lfMotor.setPower(lfMotorPower);
        rfMotor.setPower(rfMotorPower);
        lrMotor.setPower(lrMotorPower);
        rrMotor.setPower(rrMotorPower);

    }
}
