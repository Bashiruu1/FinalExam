package com.example.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class BarGraph extends AppCompatActivity {

    BarChart barChart;
    ArrayList<BarEntry> barEntries;
    float a_students;
    float b_students;
    float c_students;
    float d_students;
    float f_students;

    Intent intent;
    BarDataSet barDataSet;
    BarData data;
    String[] grades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);

        grades = new String[]{"A", "B", "C", "D", "F"};
        intent = getIntent();
        a_students = intent.getFloatExtra("A", 0);
        b_students = intent.getFloatExtra("B", 0);
        c_students = intent.getFloatExtra("C", 0);
        d_students = intent.getFloatExtra("D", 0);
        f_students = intent.getFloatExtra("F", 0);

        barChart = findViewById(R.id.bar_chart);
        barChart.setDrawBarShadow(false);
        barChart.setMaxVisibleValueCount(100);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(true);

        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, a_students));
        barEntries.add(new BarEntry(2, b_students));
        barEntries.add(new BarEntry(3, c_students));
        barEntries.add(new BarEntry(4, d_students));
        barEntries.add(new BarEntry(5, f_students));

        barDataSet = new BarDataSet(barEntries, "Grades");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        data = new BarData(barDataSet);
        data.setBarWidth(0.9f);

        barChart.setData(data);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
    }

}