package com.example.SuperFit;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;



public class FirstActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        boolean isLoggedIn = sharedpreferences.getBoolean("IsLoggedIn", false);

        if(isLoggedIn) {
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(this, Auth2Activity.class);
                startActivity(intent);
                finish();
            }, 2000);

        } else {
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }, 2000);
        }
    }
}