package com.example.SuperFit;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.view.View;


public class RecipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);


    }
    public void onBack(View view){
        finish();
    }
}