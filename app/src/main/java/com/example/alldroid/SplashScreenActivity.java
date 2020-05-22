package com.example.alldroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    private static int Splash_time=6000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    Intent homeintent=new Intent(SplashScreenActivity.this,MainActivity.class);
                    startActivity(homeintent);
                    finish();
            }
        },Splash_time);
    }
}
