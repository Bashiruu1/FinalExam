package com.example.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class BarGraph extends AppCompatActivity {

    BarChart barChart;
    float a_students;
    float b_students;
    float c_students;
    float d_students;
    float f_students;

    Intent intent;
    BarDataSet barDataSet;
    BarData barData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);

        intent =  getIntent();
        a_students = intent.getFloatExtra("A", 0);
        b_students = intent.getFloatExtra("B", 0);
        c_students = intent.getFloatExtra("C", 0);
        d_students = intent.getFloatExtra("D", 0);
        f_students = intent.getFloatExtra("F", 0);

        barChart = findViewById(R.id.bar_chart);
        barDataSet = new BarDataSet(dataValue(), "Grades");
        barData = new BarData();
        barData.addDataSet(barDataSet);

        barChart.setData(barData);
        barChart.setFitBars(true);
    }

    private ArrayList<BarEntry> dataValue() {
        ArrayList<BarEntry> dataVals = new ArrayList<>();
        dataVals.add(new BarEntry(a_students, 0));
        dataVals.add(new BarEntry(b_students, 1));
        dataVals.add(new BarEntry(c_students, 2));
        dataVals.add(new BarEntry(d_students, 3));
        dataVals.add(new BarEntry(f_students, 4));
        return dataVals;
    }

}
