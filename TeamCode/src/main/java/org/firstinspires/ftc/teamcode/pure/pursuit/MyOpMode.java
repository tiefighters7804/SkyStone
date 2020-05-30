package org.firstinspires.ftc.teamcode.pure.pursuit;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class MyOpMode extends OpMode {


    @Override
    public void init() {

    }

    @Override
    public void loop() {
        RobotMovement.goToPosition(358/2, 358/2, 0.3);
    }
}
