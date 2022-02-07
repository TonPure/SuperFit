package com.example.SuperFit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onSeeAll(View view)
    {
        Intent intent = new Intent(MainActivity.this,ExercisesActivity.class);
        startActivity(intent);
    }
    public void onRecipes(View view)
    {
        Intent intent = new Intent(MainActivity.this, RecipesActivity.class);
        startActivity(intent);
    }
    public  void onOut(View view)
    {
        Intent intent = new Intent(MainActivity.this, AuthActivity.class);
        startActivity(intent);
    }
}