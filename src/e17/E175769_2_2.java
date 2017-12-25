/**
 * Copyright (c) 2001-2017 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/epl-v10.html
 */

package e17;

import robocode.AdvancedRobot;
import robocode.*;

import java.awt.*;

/**
 * This robot created in 2017 12/15 by e175769.
 * moving circle around the origin.
 */
public class E175769_2_2 extends AdvancedRobot {
    /**
     * This robot is made up 4 methods
     * explain 4 methods
     */
    public void run(){
        double width = getBattleFieldWidth()/2;	// get half length of the field.
        double height = getBattleFieldHeight()/2;
        double px =	getX();	// current coordinates of x
        double py =	getY();	// current coordinates of y
        double x = px - width;	// distance from the origin
        double y = py - height;
        double r = Math.sqrt(x*x+y*y); // hypotenuse
        // Rotatable judgment
        if(r < height-25 && r < width-25){ // YES!
            movingCircle();	// Method reference
        }
        if(r >= height-25 || r >= width-25){ // NO!
            changeCircle();
            movingCircle();
        }
        if(r >= height-25 && r >= width-25){ // NO!
            changeCircle();
            movingCircle();
        }
    }

    public double getAngle(double x,double y){
        x =	Math.abs(x); // changed an absolute value
        y =	Math.abs(y);
        double angle = Math.atan(y/x); // get angle
        return (angle*180/Math.PI);
    }

    public void movingCircle(){
        // Similar variables of run method
        double width = getBattleFieldWidth()/2;
        double height =	getBattleFieldHeight()/2;
        double px =	getX();
        double py =	getY();
        double x = px - width;
        double y = py - height;

        if (x>=0 &&	y>=0){	// 1st quadrant
            turnRight(getAngle(y,x)	+ 270 - getHeading()); // on a circular orbit
        }else if (x<=0 && y>=0){	// 2nd quadrant
            turnRight(getAngle(x,y)	+ 180 - getHeading());
        }else if (x<=0 && y<=0){	// 3th quadrant
            turnRight(getAngle(y,x)	+ 90 - getHeading());
        }else if (x>=0 && y<=0){	// 4th quadrant
            turnRight(getAngle(x,y)	+ 360 - getHeading());
        }
        while(true){	// loop forever
            setTurnLeft(1);
            ahead(2*Math.PI*Math.sqrt(x*x+y*y)/360);
        }
    }

    public void changeCircle(){
        // Similar variables of run method
        double px =	getX();
        double py =	getY();
        double width = getBattleFieldWidth()/2;
        double height =	getBattleFieldHeight()/2;
        double x = px - width;
        double y = py - height;

        if (x>=0 && y>=0){ // 1st quadrant
            turnRight(getAngle(y,x)+ 180 - getHeading()); // on a circular orbit
        }else if (x<=0 && y>=0){ // 2nd quadrant
            turnRight(getAngle(x,y)	+ 90 - getHeading());
        }else if (x<=0 && y<=0){ // 3th quadrant
            turnRight(getAngle(y,x)	- getHeading());
        }else if (x>=0 && y<=0){ // 4th quadrant
            turnRight(getAngle(x,y)	+ 270 - getHeading());
        }
        if(width > height){ // Comparison of length
            ahead(Math.sqrt(x*x+y*y) - width/2); // Shorten the distance
        }else{
            ahead(Math.sqrt(x*x+y*y) - height/2);
        }
    }
}