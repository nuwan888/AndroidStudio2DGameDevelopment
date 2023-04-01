package com.example.androidstudio2dgamedevolopment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.Locale;

public class Game extends SurfaceView implements SurfaceHolder.Callback {
    private GameLoop gameLoop;
    private final Player player;
    private final Joystick joystick;
    //private Context context; // replaced by getContext(); so no need extra variable to store it
    public Game(Context context) {
        super(context);

        // get surface holder and add call back
         SurfaceHolder surfaceHolder = getHolder();
         surfaceHolder.addCallback(this);

         //this.context =context; // // replaced by getContext(); so no need extra variable to store it
         gameLoop = new GameLoop(this,surfaceHolder);

         // initialize player  and game objects
        joystick = new Joystick(275,500,70,40);

        player = new Player(getContext(),500,550,30);

         setFocusable(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

        // handle touch event actions
        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                if(joystick.isPressed((double)event.getX(),(double)event.getY())){
                    joystick.setIsPressed(true);
                }
                return true;

            case MotionEvent.ACTION_MOVE:
                if(joystick.getIsPressed()){
                    joystick.setActuator((double)event.getX(),(double)event.getY());
                }
                return true;

            case MotionEvent.ACTION_UP:
                joystick.setIsPressed(false);
                joystick.resetActuator();
                return true;

        }

        return super.onTouchEvent(event);
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

        gameLoop.startLoop();


    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        drawUPS(canvas);
        drawFPS(canvas);

        joystick.draw(canvas);
        player.draw(canvas);

    }

    public void drawUPS(Canvas canvas){
    String averageUPS = Double.toString(gameLoop.getAverageUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(),R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(50);
    canvas.drawText("UPS " +averageUPS,100,100,paint);

    }

    public void drawFPS(Canvas canvas){
        String averageFPS = Double.toString(gameLoop.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(),R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("FPS " +averageFPS,100,200,paint);

    }



    public void update() {
        // update game state
        joystick.update();
        player.update(joystick);


    }
}

///// last 12.50 min
//// 9.00 min important
//// 18.20 i stopped watching
//// 19.45 last watched
// 3rd video 6.30 min
// 4th video 4.05 min