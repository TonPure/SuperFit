package com.example.SuperFit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity
{



    boolean check(String name, String  email, String code, String recode) {
        if(name.isEmpty() || email.isEmpty() || code.isEmpty()) {
            Toast.makeText(this, "Enter data", Toast.LENGTH_SHORT).show();
            return false;
        } else if(!email.contains("@")) {
            Toast.makeText(this, "Wrong email", Toast.LENGTH_SHORT).show();
            return false;
        } else if(code.contains("0")) {
            Toast.makeText(this,"0 in code, it's wrong", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!code.equals(recode)) {
            Toast.makeText(this, "wrong confirm code", Toast.LENGTH_SHORT).show();
            return false;
        } else return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        String MyPREFERENCES = "MyPrefs";
        SharedPreferences sharedPreferences;
        TextView btnSI = findViewById(R.id.registerSI);
        TextView btnSU = findViewById(R.id.registerSU);
        EditText nameET = findViewById(R.id.registerUN);
        EditText emailET = findViewById(R.id.registerEmail);
        EditText codeET = findViewById(R.id.registerCode);
        EditText recodeET = findViewById(R.id.registerRecode);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        btnSI.setOnClickListener (v -> {
            String name = nameET.getText().toString();
            Intent intent = new Intent(this, AuthActivity.class);
            intent.putExtra("userName", name);
            startActivity(intent);
            finish();
        });
        btnSU.setOnClickListener(v -> {
            String name = nameET.getText().toString();
            String email = emailET.getText().toString();
            String code = codeET.getText().toString();
            String recode = recodeET.getText().toString();
            if(check(name, email, code, recode)) {
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("Name", name);
                editor.putString("Email", email);
                editor.putString("Code", code);
                editor.putBoolean("IsLoggedIn", true);
                editor.apply();

                Toast.makeText(this, "LoggedIn", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}