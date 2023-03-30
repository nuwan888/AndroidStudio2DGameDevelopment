package com.example.androidstudio2dgamedevolopment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // set window to full screen .. (this hide the status bar) // not work in mine
       // Window window = getWindow();
       // window.setFlags(
         //       WindowManager.LayoutParams.FLAG_FULLSCREEN,
         //       WindowManager.LayoutParams.FLAG_FULLSCREEN
       // );
        // set content view to game , so that objects in the game class can be rendered to the screen
        setContentView(new Game(this));
    }
}