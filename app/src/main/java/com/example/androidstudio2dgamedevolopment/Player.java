package com.example.androidstudio2dgamedevolopment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

// player is the main character of the game ,which user can control with a touch joystick
// the player class is an extension of a Circle. which is an extension of GameObject


public class Player extends Circle {

    private static final double SPEED_PIXELS_PER_SECOND =400.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND/GameLoop.MAX_UPS;


    private double velocityX;
    private double velocityY;
    private final Joystick joystick;

    public Player(Context context ,Joystick joystick, double positionX, double positionY, double radius){
        super(context,ContextCompat.getColor(context,R.color.player),positionX, positionY,radius);// super class eke default contructor ekak nathi nisa
        this.joystick =joystick;

    }

    public void update() {
        //update velocity based on actuator of joystick
        velocityX =joystick.getActuatorX()*MAX_SPEED;
        velocityY =joystick.getActuatorY()*MAX_SPEED;
        // update position
        positionX+=velocityX;
        positionY+=velocityY;
    }

    public void setPosition(double positionX, double positionY) {
        this.positionX =positionX;
        this.positionY =positionY;
    }
}
