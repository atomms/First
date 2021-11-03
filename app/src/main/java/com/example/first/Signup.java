package com.example.first;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //added a transparent shape to the traditional action bar
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.transparent));


    }
}