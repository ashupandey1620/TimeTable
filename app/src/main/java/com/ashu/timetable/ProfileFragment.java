package com.ashu.timetable;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {

    private CombinedChart chart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        chart = v.findViewById(R.id.chart);

        // Customize chart
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);

        // Customize chart description
        Description description = new Description();
        description.setText("Line Chart Example");
        chart.setDescription(description);

        // Customize legend
        Legend legend = chart.getLegend();
        legend.setEnabled(true);

        // Generate sample data
        List<Entry> entries1 = generateData1();
        List<Entry> entries2 = generateData2();
        List<Entry> entries3 = generateData3();

        // Create datasets and set colors
        LineDataSet dataSet1 = new LineDataSet(entries1, "Data 1");
        dataSet1.setColor(Color.RED);

        LineDataSet dataSet2 = new LineDataSet(entries2, "Data 2");
        dataSet2.setColor(Color.BLUE);

        LineDataSet dataSet3 = new LineDataSet(entries3, "Data 3");
        dataSet3.setColor(Color.GREEN);

        // Create a list of LineDataSets
        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet1);
        dataSets.add(dataSet2);
        dataSets.add(dataSet3);

        // Create a LineData object and add the datasets
        LineData lineData = new LineData(dataSets);

        // Create a CombinedData object and add the LineData
        CombinedData combinedData = new CombinedData();
        combinedData.setData(lineData);


        chart.setData(combinedData);//refresh chart


        // Adjust chart dimensions programmatically
        int chartHeight = calculateChartHeight(); // Calculate the desired height here
        ViewGroup.LayoutParams layoutParams = chart.getLayoutParams();
        layoutParams.height = chartHeight;
        chart.setLayoutParams(layoutParams);

        chart.invalidate(); // Refresh the chart

        return v;
    }
    private List<Entry> generateData1() {
        List<Entry> entries = new ArrayList<>();
        // Add your data points here
        entries.add(new Entry(0, 10));
        entries.add(new Entry(1, 15));
        entries.add(new Entry(2, 8));
        entries.add(new Entry(3,7));
        // Add more entries as needed
        return entries;
    }

    // Example method to generate sample data for Data 2
    private List<Entry> generateData2() {
        List<Entry> entries = new ArrayList<>();
        // Add your data points here
        entries.add(new Entry(0, 5));
        entries.add(new Entry(1, 12));
        entries.add(new Entry(2, 3));
        entries.add(new Entry(3,7));
        // Add more entries as needed
        return entries;
    }

    // Example method to generate sample data for Data 3
    private List<Entry> generateData3() {
        List<Entry> entries = new ArrayList<>();
        // Add your data points here
        entries.add(new Entry(0, 8));
        entries.add(new Entry(1, 10));
        entries.add(new Entry(2, 7));
        entries.add(new Entry(3,7));
        // Add more entries as needed
        return entries;
    }

    private int calculateChartHeight() {
        // Calculate the desired height based on your requirements
        // For example, you can use the display metrics to calculate a percentage of the screen height
        // Here's an example that sets the chart height to 70% of the screen height
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int screenHeight = displayMetrics.heightPixels;
        return (int) (screenHeight * 0.7);
    }
}