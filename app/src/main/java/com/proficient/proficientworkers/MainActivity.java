package com.proficient.proficientworkers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed((Runnable) () -> {

            Intent mainIntent = new Intent(MainActivity.this,dashbord.class);
            startActivity(mainIntent);
            finish();
        }, 1000);
    }
}