package com.example.blackmoon.musikaa;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import custom_font.MyTextView;

public class login extends AppCompatActivity {

    TextView holliday;
    MyTextView create;
    MyTextView getstarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getstarted = findViewById(R.id.getstarted);

        getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(login.this, MainActivity.class);
                startActivity(it);
            }
        });

        Typeface custom_fonts = Typeface.createFromAsset(getAssets(), "fonts/ArgonPERSONAL-Regular.otf");

    }
}
