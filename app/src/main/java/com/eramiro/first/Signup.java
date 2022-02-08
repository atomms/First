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

        AnyChartView anyChartView = (AnyChartView) findViewById(R.id.anychartview);
        Pie pie = AnyChart.pie();

        List<DataEntry> datat = new ArrayList<>();
        datat.add(new ValueDataEntry("John", 10000));
        datat.add(new ValueDataEntry("Jake", 12000));
        datat.add(new ValueDataEntry("Peter", 18000));

        pie.data(datat);

//        AnyChartView anyChartView = (AnyChartView) findViewById(R.id.anychartview);
        anyChartView.setChart(pie);


//        final AnyChartView funnelchartPayable1=  findViewById(R.id.anychartview);
//        final Funnel funnel1 = AnyChart.funnel();
//        List<DataEntry> dataf = new ArrayList<>();
//        dataf.add(new ValueDataEntry("Website Visits", 528756));
//        dataf.add(new ValueDataEntry("Downloads", 164052));
//        dataf.add(new ValueDataEntry("Valid Contacts", 112167));
//        dataf.add(new ValueDataEntry("Interested to Buy", 79128));
//        dataf.add(new ValueDataEntry("Purchased", 79128));
//
//        funnel1.data(dataf);
//        funnel1.margin(new String[]{"10", "20%", "10", "20%"});
//        //   funnel1.baseWidth("70%")
//        //         .neckWidth("17%");
//
//        funnel1.labels()
//                .position("outsideleft")
//                .format("{%X} - {%Value}");
//        funnel1.animation(true, 800);
//
//        funnelchartPayable1.setChart(funnel1);


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