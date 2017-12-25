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
 My second robot created in 2017 12/25 by Takuya.
 */
public class Mysecondrobot extends AdvancedRobot {


    public void run(){
        double width = getBattleFieldWidth()/2;
        double height = getBattleFieldHeight()/2;
        double px =	getX();
        double py =	getY();
        double x = px - width;
        double y = py - height;
        double r = Math.sqrt(x*x+y*y);

        if(r < height -50 && r < width -50){
            movingCircle();
        }
        if(r >= height -50 || r >= width -50){
            changeCircle();
            movingCircle();
        }
        if(r >= height -50 && r >= width -50){
            changeCircle();
            movingCircle();
        }
    }

    public double getAngle(double x,double y){
        x =	Math.abs(x);
        y =	Math.abs(y);
        double angle = Math.atan(y/x);
        return (angle*180/Math.PI);
    }

    public void movingCircle(){
        double width = getBattleFieldWidth()/2;
        double height =	getBattleFieldHeight()/2;
        double px =	getX();
        double py =	getY();
        double x = px - width;
        double y = py - height;

        if (x>=0 &&	y>=0){	//1
            turnRight(getAngle(y,x)	+ 270 - getHeading());
        }else if (x<=0 && y>=0){	//2
            turnRight(getAngle(x,y)	+ 180 - getHeading());
        }else if (x<=0 && y<=0){	//3
            turnRight(getAngle(y,x)	+ 90 - getHeading());
        }else if (x>=0 && y<=0){	//4
            turnRight(getAngle(x,y)	+ 360 - getHeading());
        }
        while(true){	//loop forever
            setTurnLeft(1);
            ahead(2*Math.PI*Math.sqrt(x*x+y*y)/360);
        }
    }

    public void changeCircle(){
        double px =	getX();
        double py =	getY();
        double width = getBattleFieldWidth()/2;
        double height =	getBattleFieldHeight()/2;
        double x = px - width;
        double y = py - height;

        if (x>=0 &&	y>=0){ //1
            turnRight(getAngle(y,x)+ 180 - getHeading());
        }else if (x<=0 && y>=0){ //2
            turnRight(getAngle(x,y)	+ 90 - getHeading());
        }else if (x<=0 && y<=0){ //3
            turnRight(getAngle(y,x)	- getHeading());
        }else if (x>=0 && y<=0){ //4
            turnRight(getAngle(x,y)	+ 270 - getHeading());
        }
        if(width > height){
            ahead(Math.sqrt(x*x+y*y) - width/2);
        }else{
            ahead(Math.sqrt(x*x+y*y) - height/2);
        }
    }
}