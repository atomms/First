package com.eramiro.first;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * This is the Signup
 *
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

        TextView dateView = (TextView) findViewById(R.id.mydate);
        setDate(dateView);

        Pie pie = AnyChart.pie();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("John", 10000));
        data.add(new ValueDataEntry("Jake", 12000));
        data.add(new ValueDataEntry("Peter", 18000));

        AnyChartView anyChartView = (AnyChartView) findViewById(R.id.anychartview);
        anyChartView.setChart(pie);


    }

    public void setDate(TextView view) {
//        String str = String.format("%tc", new Date());
//        view.setText(str);
//
        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy"); //formating according to my needs
        String date = formatter.format(today);
        view.setText(date);

    }
}