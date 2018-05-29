package com.example.blackmoon.musikaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import custom_font.MyTextView;

public class welcome extends AppCompatActivity {

    MyTextView login;
    MyTextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(welcome.this, login.class);
                startActivity(it);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(welcome.this, signup.class);
                startActivity(it);
            }
        });

    }
}
