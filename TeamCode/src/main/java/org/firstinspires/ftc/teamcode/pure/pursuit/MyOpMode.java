package org.firstinspires.ftc.teamcode.pure.pursuit;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.util.ArrayList;

import static org.firstinspires.ftc.teamcode.pure.pursuit.RobotMovement.followCurve;

public class MyOpMode extends OpMode {


    @Override
    public void init() {

    }

    @Override
    public void loop() {
        ArrayList<CurvePoint> allPoints = new ArrayList<>();
        allPoints.add(new CurvePoint(0,0,1.0,1.0,50, Math.toRadians(50), 1.0));

        followCurve(allPoints, Math.toRadians(90));
    }
}
