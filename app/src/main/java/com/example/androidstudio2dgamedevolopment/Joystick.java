package com.example.androidstudio2dgamedevolopment;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Joystick {

    private final Paint outerCirclePaint;
    private final Paint innerCirclePaint;

    private int outerCircleRadius;
    private int innerCircleRadius;
   private  int outerCircleCenterPositionX;
    private  int outerCircleCenterPositionY;
    private  int innerCircleCenterPositionX;
    private  int innerCircleCenterPositionY;
    private double joysticCenterToTouchDistance;
    private boolean isPressed;
    private double actuatorX;
    private double actuatorY;

    public Joystick(int centerPositionX, int centerPositionY,int outerCircleRadius,int innerCircleRadius){
        // outer and inner circle make up the joystic
        outerCircleCenterPositionX = centerPositionX;
        outerCircleCenterPositionY = centerPositionY;
        innerCircleCenterPositionX = centerPositionX;
        innerCircleCenterPositionY = centerPositionY;

        //radius of circles
        this.innerCircleRadius =innerCircleRadius;
        this.outerCircleRadius =outerCircleRadius;

        // paint of circles
        outerCirclePaint = new Paint();
        outerCirclePaint.setColor(Color.GRAY); // anith widihatath colors set karanda puluwan. kalin karapu widihatama
        outerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        innerCirclePaint = new Paint();
        innerCirclePaint.setColor(Color.BLUE); // anith widihatath colors set karanda puluwan. kalin karapu widihatama
        innerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);



    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(outerCircleCenterPositionX,outerCircleCenterPositionY,outerCircleRadius,outerCirclePaint);
        canvas.drawCircle(innerCircleCenterPositionX,innerCircleCenterPositionY,innerCircleRadius,innerCirclePaint);

    }

    public void update() {

        updateInnerCirclePosition();
    }

    private void updateInnerCirclePosition() {
        innerCircleCenterPositionX =(int)(outerCircleCenterPositionX+actuatorX*outerCircleRadius);
        innerCircleCenterPositionY =(int)(outerCircleCenterPositionY+actuatorY*outerCircleRadius);

    }

    public boolean isPressed(double touchPositionX, double touchPositionY) {

        joysticCenterToTouchDistance =Math.sqrt(
                Math.pow(outerCircleCenterPositionX -touchPositionX ,2)+
                Math.pow(outerCircleCenterPositionY - touchPositionY ,2)
        );

        return joysticCenterToTouchDistance < outerCircleRadius;
    }


    public void setIsPressed(boolean isPressed) {
        this.isPressed =isPressed;
    }


    public boolean getIsPressed() {
        return isPressed;
    }


    public void setActuator(double touchPositionX, double touchPositionY) {

        double deltaX =touchPositionX -outerCircleCenterPositionX;
        double deltaY =touchPositionY -outerCircleCenterPositionY;
        double deltaDistance = Math.sqrt(Math.pow(deltaX,2)+Math.pow(deltaY,2));

        if(deltaDistance <outerCircleRadius){
            actuatorX = deltaX/outerCircleRadius;
            actuatorY = deltaY/outerCircleRadius;

        } else{
            actuatorX =deltaX/deltaDistance;
            actuatorY =deltaY/deltaDistance;
        }

    }


    public void resetActuator() {

        actuatorX =0.0;
        actuatorY =0.0;
    }


    public double getActuatorX() {
        return actuatorX;
    }

    public double getActuatorY() {
        return actuatorY;
    }


}


