package com.example.androidstudio2dgamedevolopment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

// Circle is an abstract class which implements adraw method from GameObject for drawing the object
// as a circle

import androidx.core.content.ContextCompat;

public abstract class Circle extends GameObject {

    protected double radius;
    protected Paint paint;

    public Circle(Context context, int color, double positionX, double positionY, double radius) {
        super(positionX, positionY);
        this.radius = radius;

        //set colors of circle
        paint = new Paint();
        paint.setColor(color);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle((float)positionX,(float)positionY,(float)radius,paint);

    }


}
