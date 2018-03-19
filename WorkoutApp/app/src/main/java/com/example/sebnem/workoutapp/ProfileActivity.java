package com.example.sebnem.workoutapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProfileActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;
    private static final Random RANDOM = new Random();
    ArrayList<Double> aList=new ArrayList<>();
    double yVal=60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        for (int i=0;i<5;i++){
            aList.add(yVal=yVal+RANDOM.nextDouble()-0.6);
        }
        GraphView graph=(GraphView) findViewById(R.id.graph);

        series = new LineGraphSeries<>();
        for(int i=0;i<aList.size();i++){
            series.appendData(new DataPoint(i+1,aList.get(i)), true, 15);
        }

        series.setDrawBackground(true);
        series.setThickness(5);
        series.setDrawDataPoints(true);
        graph.addSeries(series);

        Viewport viewport = graph.getViewport();
        viewport.setXAxisBoundsManual(true);
        viewport.setMinX(Math.floor(series.getLowestValueX()));
        viewport.setMaxX(Math.ceil(series.getHighestValueX()));
    }

}
