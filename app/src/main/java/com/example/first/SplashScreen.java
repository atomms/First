package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        openApp(true);

        //implements and starts animation
        ImageView thunder = (ImageView) findViewById(R.id.logosplash);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        thunder.startAnimation(myanim);

    }

    private void openApp(boolean locationPermission) {

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen
                        .this, LoginActivity.class);
                startActivity(intent);
            }
        }, 2000);


    }

}