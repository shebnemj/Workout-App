package com.example.sebnem.workoutapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    User user=User.getInstance();
    private LineGraphSeries<DataPoint> weightSeries;
    private LineGraphSeries<DataPoint> bmiSeries;
    ArrayList<Double> weights =User.getInstance().getWeight();
    ArrayList<Double> heights =User.getInstance().getHeight();
    double yVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if(!user.getName().equals(""))
        ((TextView)findViewById(R.id.weightTextView)).setText(user.getName()+"'s weight (kg)");

        GraphView weightGraph=(GraphView) findViewById(R.id.weightGraph);

        weightSeries = new LineGraphSeries<>();
        for(int i = 0; i< weights.size(); i++){
            weightSeries.appendData(new DataPoint(i+1, weights.get(i)), true, 15);
        }

        weightSeries.setDrawBackground(true);
        weightSeries.setThickness(5);
        weightSeries.setDrawDataPoints(true);
        weightGraph.addSeries(weightSeries);

        Viewport viewport = weightGraph.getViewport();
        viewport.setXAxisBoundsManual(true);
        viewport.setMinX(Math.floor(weightSeries.getLowestValueX()));
        viewport.setMaxX(Math.ceil(weightSeries.getHighestValueX()));

        viewport.setYAxisBoundsManual(true);
        viewport.setMinY(Math.floor(weightSeries.getLowestValueY())-1);
        viewport.setMaxY(Math.ceil(weightSeries.getHighestValueY())+1);

        if(!user.getName().equals(""))
            ((TextView)findViewById(R.id.bmiTextView)).setText(user.getName()+"'s BMI");

        GraphView bmiGraph=(GraphView) findViewById(R.id.bmiGraph);

        bmiSeries = new LineGraphSeries<>();
        for(int i = 0; i< heights.size(); i++){
            bmiSeries.appendData(new DataPoint(i+1,  weights.get(i)/(heights.get(i)*heights.get(i))), true, 15);
        }

        bmiSeries.setDrawBackground(true);
        bmiSeries.setThickness(5);
        bmiSeries.setDrawDataPoints(true);
        bmiGraph.addSeries(bmiSeries);

        Viewport bmiViewport = bmiGraph.getViewport();
        bmiViewport.setXAxisBoundsManual(true);
        bmiViewport.setMinX(Math.floor(bmiSeries.getLowestValueX()));
        bmiViewport.setMaxX(Math.ceil(bmiSeries.getHighestValueX()));
        bmiViewport.setYAxisBoundsManual(true);
        bmiViewport.setMinY(Math.floor(bmiSeries.getLowestValueY())-1);
        bmiViewport.setMaxY(Math.ceil(bmiSeries.getHighestValueY())+1);
    }
    public void onClickBtn(View v)
    {
        GraphView weightGraph=(GraphView) findViewById(R.id.weightGraph);
        GraphView bmiGraph=(GraphView) findViewById(R.id.bmiGraph);
        EditText editText =(EditText) findViewById(R.id.editText);

        if(!editText.getText().toString().equals("")){
            yVal=Double.parseDouble(editText.getText().toString());
            user.addWeight(yVal);
            user.addHeight(user.getHeight().get(user.getHeight().size()-1));
            weightSeries.appendData(new DataPoint(weightSeries.getHighestValueX()+1, yVal), false, 15);
            bmiSeries.appendData(new DataPoint(bmiSeries.getHighestValueX()+1, yVal/(user.getHeight().get(user.getHeight().size()-1)*user.getHeight().get(user.getHeight().size()-1))), false, 15);

            Viewport viewport = weightGraph.getViewport();
            viewport.setMinY(Math.floor(weightSeries.getLowestValueY())-1);
            viewport.setMaxY(Math.ceil(weightSeries.getHighestValueY())+1);
            viewport.setMinX(Math.floor(weightSeries.getLowestValueX()));
            viewport.setMaxX(Math.ceil(weightSeries.getHighestValueX()));
            viewport = bmiGraph.getViewport();
            viewport.setMinY(Math.floor(bmiSeries.getLowestValueY())-1);
            viewport.setMaxY(Math.ceil(bmiSeries.getHighestValueY())+1);
            viewport.setMinX(Math.floor(bmiSeries.getLowestValueX()));
            viewport.setMaxX(Math.ceil(bmiSeries.getHighestValueX()));
        }
    }

}
