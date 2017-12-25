package e17;
import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * E175769_2_1 - a robot in 2017 12/25 by Takuya Shinjo
 */
public class E175769_2_1 extends Robot
{
    double px,py;
    /**
     * run: E175769_2_1's default behavior
     */
    public void run() {
        // Robot main loop
        double height = getBattleFieldHeight(); // get length of the field.
        double width = getBattleFieldWidth();
        px = getX(); // current coordinates of x
        py = getY(); // current coordinates y
        turnLeft(getHeading()); // turn to 0 degree
        ahead(height/2 - py); // go to coordinates of x
        turnRight(90); // turn to 90 degree
        ahead(width/2 - px); // go to coordinates of y
        turnLeft(90); // turn to 90 degree
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        // fire bullet
        fire(1);
    }


    public void onHitByBullet(HitByBulletEvent e) {
        // back to 10pixel
        back(10);
    }

    public void onHitWall(HitWallEvent e) {
        // back to 20pixel
        back(20);
    }
}
