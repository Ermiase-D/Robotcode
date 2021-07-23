package bot;

    import robocode.*;
        import robocode.Robot;
        import java.awt.*;

/**
 * robot name  .
 */
public class Awash extends Robot {
    double firePower;
    //boolean peek; // Don't turn if there's a robot there
    /**
     * run: the robot default behavior
     */
    public void run() {

        // Initialization of the robot what should be put
        //After trying out your robot, try uncommenting the import at the top,// and the next line:
        //set color for the robot
        setColors(Color.RED, Color.YELLOW, Color.BLUE, Color.WHITE, Color.GREEN);

        // robot main loop
        while (true) {
            boolean peak = true;
            double distance = Math.random()*300;
            double angle = Math.random()*45;
            ahead(400);
            //turnRight(45);
            turnGunRight(45);
            //turnLeft(getHeading() - 90);
            back(100);
            turnGunLeft(270);
            // turnLeft(getHeading() - 90);
            //peak = false;
        }
    }

    /**
     *  What to do  when this robot is hit by a bullet.
     */
    public void onHitByBullet(HitByBulletEvent event){
        back(20);

    }
    /**
     * What to do when this robot collides with a wall.
     */
    public void  onHitWall(HitWallEvent event){
        ScannedRobotEvent e = null;
       //bearing - relative angle to some object from my robot's heading, positive clockwise. -180 < bearing <= 180
        double bearing = e.getBearing();
        //get the bearing of the wall
        turnRight(-bearing);
        //This isn't accurate but release your robot.
        ahead(200);
        turnGunLeft(30);
        //The robot goes away from the wall.
    }
    /**
     * What to do when this robot sees another robot
     */
    public void onScannedRobot(ScannedRobotEvent event) {
        //How to find distance between robot
        double energy=(event.getDistance() > 300) ? 1 : (event.getDistance() > 100) ? 2:3;
        fire(3);
        turnLeft(30);
        fire(3);
        System.out.println(event.getDistance());
    }
    /**
     * What to do when a robot collides with another robot
     */
    public void onHitRobot(HitRobotEvent e) {
        if (e.getBearing() > -10 && e.getBearing() <= 10)
            fire(3);
        else if (e.getBearing() > -90 && e.getBearing() <= 90)
            back(100);
        else
            ahead(100);
            fire(1);
    }
}