package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Velocity Vortex Rev2", group = "velocity vortex")
public class VelocityVortexRev2 extends OpMode {

    DcMotor lfMotor;
    DcMotor rfMotor;
    DcMotor lrMotor;
    DcMotor rrMotor;

    double Vertical;
    float Horizontal;
    float Pivot;

    @Override
    public void init() {

            lfMotor = hardwareMap.dcMotor.get("lf");
            rfMotor = hardwareMap.dcMotor.get("rf");
            lrMotor = hardwareMap.dcMotor.get("lr");
            rrMotor = hardwareMap.dcMotor.get("rr");
        lfMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rrMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        }

    @Override
    public void loop() {

        Vertical = -gamepad1.left_stick_y;
        Horizontal = gamepad1.left_stick_x;
        Pivot = gamepad1.right_stick_x;
        rfMotor.setPower(-Pivot + (Vertical - Horizontal));
        rrMotor.setPower(-Pivot + Vertical + Horizontal);
        lfMotor.setPower(Pivot + Vertical + Horizontal);
        lrMotor.setPower(Pivot + (Vertical - Horizontal));

        }
    }
