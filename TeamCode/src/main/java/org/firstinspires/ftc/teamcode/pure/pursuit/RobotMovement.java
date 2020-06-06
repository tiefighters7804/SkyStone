package org.firstinspires.ftc.teamcode.pure.pursuit;

import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.RobotUtilities.Point;

import java.util.ArrayList;

import static org.firstinspires.ftc.teamcode.Odometry.OdometryGlobalPosition.robotGlobalXCoordinatePosition;
import static org.firstinspires.ftc.teamcode.Odometry.OdometryGlobalPosition.robotGlobalYCoordinatePosition;
import static org.firstinspires.ftc.teamcode.Odometry.OdometryGlobalPosition.robotOrientationRadians;
import static org.firstinspires.ftc.teamcode.RobotUtilities.MovementVars.movement_turn;
import static org.firstinspires.ftc.teamcode.RobotUtilities.MovementVars.movement_x;
import static org.firstinspires.ftc.teamcode.RobotUtilities.MovementVars.movement_y;
import static org.firstinspires.ftc.teamcode.pure.pursuit.MathFunctions.AngleWrap;
import static org.firstinspires.ftc.teamcode.pure.pursuit.MathFunctions.lineCircleIntersection;


public class RobotMovement {



    public static void followCurve (ArrayList<CurvePoint> allPoints, double followAngle) {
        for (int i = 0; i < allPoints.size()- 1; i++) {

        }


        CurvePoint followMe = getFollowPointPath(allPoints, new Point(robotGlobalXCoordinatePosition,robotGlobalYCoordinatePosition),
                allPoints.get(0).followDistance);



        goToPosition(followMe.x, followMe.y, followMe.moveSpeed, followAngle, followMe.turnSpeed);
    }

    public static CurvePoint getFollowPointPath(ArrayList<CurvePoint> pathPoints, Point robotLocation, double followRadius) {
        CurvePoint followMe = new CurvePoint(pathPoints.get(0));

        for(int i = 0; i < pathPoints.size() - 1; i ++) {
            CurvePoint startLine = pathPoints.get(i);
            CurvePoint endLine = pathPoints.get(i + 1);

            ArrayList<Point> intersections = lineCircleIntersection(robotLocation, followRadius, startLine.toPoint(),
                    endLine.toPoint());

            double closestAngle = 10000000;

            for (Point thisIntersection : intersections) {
                double angle = Math.atan2(thisIntersection.y - robotGlobalYCoordinatePosition, thisIntersection.x - robotGlobalXCoordinatePosition);
                double deltaAngle = Math.abs(MathFunctions.AngleWrap(angle - robotOrientationRadians));

                if (deltaAngle < closestAngle) {
                    closestAngle = deltaAngle;
                    followMe.setPoint(thisIntersection);
                }

            }
        }
        return followMe;
    }


    /**
     *
     * @param x
     * @param y
     * @param movementSpeed
     */
    public static void goToPosition (double x, double y, double movementSpeed, double preferredAngle, double turnSpeed) {
      double distanceToTarget = Math.hypot(x - robotGlobalXCoordinatePosition, y - robotGlobalYCoordinatePosition);

      double absoluteAngleToTarget = Math.atan2(y - robotGlobalYCoordinatePosition, x - robotGlobalXCoordinatePosition) ;

      double relativeAngleToPoint = AngleWrap(absoluteAngleToTarget - (robotOrientationRadians - Math.toRadians(90)));


      double relativeXToPoint = Math.cos(relativeAngleToPoint) * distanceToTarget;
      double relativeYToPoint = Math.sin(relativeAngleToPoint) * distanceToTarget;

      double movementXPower = relativeXToPoint / (Math.abs(relativeXToPoint) + Math.abs(relativeYToPoint));
      double movementYPower = relativeYToPoint / (Math.abs(relativeXToPoint) + Math.abs(relativeYToPoint));

      movement_x = movementXPower * movementSpeed;
      movement_y = movementYPower * movementSpeed;


        /**
         * Making the robot follow the preferred angle of the drivetrain
         */
      double relativeTurnAngle = relativeAngleToPoint - Math.toRadians(180) + preferredAngle;

      movement_turn = Range.clip(relativeTurnAngle/Math.toRadians(30), -1, 1) * turnSpeed;

      if (distanceToTarget < 10) {
          movement_turn = 0;
      }
    }
}
