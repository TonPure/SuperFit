package com.example.SuperFit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        EditText login = findViewById(R.id.authUN);
        TextView loginSI = findViewById(R.id.loginSI);
        TextView loginSU = findViewById(R.id.loginSU);
        String userName = login.getText().toString();

        String ses = this.getIntent().getStringExtra("userName");
        login.setText(ses);

        loginSI.setOnClickListener (v -> {

            if(userName.trim().isEmpty()) Toast.makeText(this, "Entry UserName", Toast.LENGTH_SHORT).show();
            else {
                Intent i = new Intent(this, Auth2Activity.class);
                startActivity(i);
                finish();
            }
        });
        loginSU.setOnClickListener(v -> {
            if(userName.trim().isEmpty()) Toast.makeText(this, "Entry UserName", Toast.LENGTH_SHORT).show();
            else {
                Intent i = new Intent(this, RegisterActivity.class);
                i.putExtra("userName", userName);
                startActivity(i);
                finish();
            }
        });

    }
}