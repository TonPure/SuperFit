package com.example.SuperFit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class Auth2Activity extends AppCompatActivity {

    Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth2);


        TextView editText_email;
        buttons = new Button[9];
        editText_email = findViewById(R.id.login);
        editText_email.setText(getIntent().getStringExtra("login"));
        buttons[0] = findViewById(R.id.B1);
        buttons[1] = findViewById(R.id.B2);
        buttons[2] = findViewById(R.id.B3);
        buttons[3] = findViewById(R.id.B4);
        buttons[4] = findViewById(R.id.B5);
        buttons[5] = findViewById(R.id.B6);
        buttons[6] = findViewById(R.id.B7);
        buttons[7] = findViewById(R.id.B8);
        buttons[8] = findViewById(R.id.B9);
    }
    private void Checker(String pass, String curPass){
        if (pass.length() == curPass.length()) {
            Toast.makeText(getApplicationContext(), pass, Toast.LENGTH_LONG).show();
            if (pass.equals(curPass))
            {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
            else {
                Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void onClick1(View view) {
        SharedPreferences shp = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String pass = "";
        String curPass = shp.getString("Code", "");
        pass += ((Button)view).getText();
        Toast.makeText(getApplicationContext(), curPass, Toast.LENGTH_LONG).show();
        Checker(pass, curPass);
        Random r = new Random();
        for (Button btn : buttons) {
            int rndIndex = r.nextInt(buttons.length);
            String temp = String.valueOf(buttons[rndIndex].getText());
            buttons[rndIndex].setText(btn.getText());
            btn.setText(temp);
        }
    }
}