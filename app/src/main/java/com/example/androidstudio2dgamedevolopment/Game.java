package com.example.androidstudio2dgamedevolopment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class Game extends SurfaceView implements SurfaceHolder.Callback {
    private GameLoop gameLoop;
    private Context context;
    public Game(Context context) {
        super(context);

        // get surface holder and add call back
         SurfaceHolder surfaceHolder = getHolder();
         surfaceHolder.addCallback(this);

         this.context =context;
         gameLoop = new GameLoop(this,surfaceHolder);

         setFocusable(true);
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
    }

    public void drawUPS(Canvas canvas){
    String averageUPS = Double.toString(gameLoop.getAverageUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context,R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(50);
    canvas.drawText("UPS " +averageUPS,100,100,paint);

    }

    public void drawFPS(Canvas canvas){
        String averageFPS = Double.toString(gameLoop.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context,R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("FPS " +averageFPS,100,200,paint);

    }


    public void update() {
    }
}

///// last 12.50 min
//// 9.00 min important
//// 18.20 i stopped watching
//// 19.45 last watched