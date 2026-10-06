package com.eramiro.first;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This is the Signup
 * transformed into a calendar
 * @author ernesto
 * @see Login
 */
public class Date extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        //added a transparent shape to the traditional action bar
//        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.transparent));

        TextView dateView = (TextView) findViewById(R.id.mydate);
        setDate(dateView);

    }

    public void setDate(TextView view) {
//        String str = String.format("%tc", new Date());
//        view.setText(str);
//
        java.util.Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy"); //formating according to my needs
        String date = formatter.format(today);
        view.setText(date);

    }
}