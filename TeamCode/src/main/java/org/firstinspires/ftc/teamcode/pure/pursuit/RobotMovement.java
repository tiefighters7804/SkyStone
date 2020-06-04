package org.firstinspires.ftc.teamcode.pure.pursuit;

import static org.firstinspires.ftc.teamcode.Odometry.OdometryGlobalPosition.robotGlobalXCoordinatePosition;
import static org.firstinspires.ftc.teamcode.Odometry.OdometryGlobalPosition.robotGlobalYCoordinatePosition;
import static org.firstinspires.ftc.teamcode.Odometry.OdometryGlobalPosition.robotOrientationRadians;
import static org.firstinspires.ftc.teamcode.pure.pursuit.MathFunctions.AngleWrap;



public class RobotMovement {
    /**
     *
     * @param x
     * @param y
     * @param movementSpeed
     */
    public static void goToPosition (double x, double y, double movementSpeed) {
      double distanceToTarget = Math.hypot(x- robotGlobalXCoordinatePosition, y - robotGlobalYCoordinatePosition);

      double absoluteAngleToTarget = Math.atan2(y- robotGlobalYCoordinatePosition, x- robotGlobalXCoordinatePosition) ;

      double relativeAngleToPoint = AngleWrap(absoluteAngleToTarget - (robotOrientationRadians - Math.toRadians(90)));


      double relativeXToPoint = Math.cos(relativeAngleToPoint) * distanceToTarget;
      double relativeYToPoint = Math.sin(relativeAngleToPoint) * distanceToTarget;

      double movementXPower = relativeXToPoint / (Math.abs(relativeXToPoint) + Math.abs(relativeYToPoint));
      double movementYPower = relativeYToPoint / (Math.abs(relativeXToPoint) + Math.abs(relativeYToPoint));

      movement_x = movementXPower;
      movement_y = movementYPower;


    }
}
