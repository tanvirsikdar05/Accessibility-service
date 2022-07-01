package com.proficient.proficientworkers;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;

public class dashbord extends AppCompatActivity {
    Button permissionm,webviewu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);
        permissionm=findViewById(R.id.permissiona);
        webviewu=findViewById(R.id.webviewu);


        permissionm.setOnClickListener(view -> {
            startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
        });
        webviewu.setOnClickListener(view -> {
            startActivity(new Intent(this,webviewA.class));
        });
    }
}