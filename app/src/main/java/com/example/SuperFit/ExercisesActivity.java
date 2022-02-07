package com.example.SuperFit;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExercisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
    }
    public void onBack(View view){
        finish();
    }
    public void OnPush_Ups(View view){
        Intent intent = new Intent(this,Push_Ups.class);
        startActivity(intent);
    }
    public void OnCrunch(View view){
        Intent intent = new Intent(this,Crunch.class);
        startActivity(intent);
    }
    public void OnSquats(View view){
        Intent intent = new Intent(this,Squats.class);
        startActivity(intent);
    }
    public void OnPlank(View view){
        Intent intent = new Intent(this,Plank.class);
        startActivity(intent);
    }
    public void OnRunning(View view){
        Intent intent = new Intent(this,Running.class);
        startActivity(intent);
    }
}