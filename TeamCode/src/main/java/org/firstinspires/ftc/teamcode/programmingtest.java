package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Programming Test")
public class programmingtest extends OpMode {

    DcMotor lfMotor;
    DcMotor rfMotor;
    DcMotor lrMotor;
    DcMotor rrMotor;


    @Override
    public void init() {

        lfMotor = hardwareMap.dcMotor.get("lf");
        rfMotor = hardwareMap.dcMotor.get("rf");
        lrMotor = hardwareMap.dcMotor.get("lr");
        rrMotor = hardwareMap.dcMotor.get("rr");


    }

    @Override
    public void loop() {

    }
}
