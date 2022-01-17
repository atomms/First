package com.example.first;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * This is the Signup
 * @author ernesto
 * @see Login
 */
public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //added a transparent shape to the traditional action bar
//        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.transparent));

        TextView dateView = (TextView)findViewById(R.id.mydate);
        setDate(dateView);

    }

    public void setDate (TextView view){
//        String str = String.format("%tc", new Date());
        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//formating according to my need
        String date = formatter.format(today);
        view.setText(date);
//        view.setText(str);
    }
}