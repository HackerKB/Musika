package com.example.blackmoon.musikaa;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import custom_font.MyTextView;

public class signup extends AppCompatActivity {

    TextView holliday;
    MyTextView signin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        Typeface custom_fonts = Typeface.createFromAsset(getAssets(), "fonts/ArgonPERSONAL-Regular.otf");




    }
}
