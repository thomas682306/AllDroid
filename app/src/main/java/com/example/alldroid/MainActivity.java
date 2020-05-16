package com.example.alldroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //why is this is not always working


        Log.d("afro","Im finally getting the hang of this");

        Toast.makeText(this, "Im still trying (sad emoji)", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Im still trying (sad emoji)", Toast.LENGTH_SHORT).show();
        


    }
}
