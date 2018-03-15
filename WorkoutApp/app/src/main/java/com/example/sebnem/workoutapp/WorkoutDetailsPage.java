package com.example.sebnem.workoutapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WorkoutDetailsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_details);

        String savedExtra = getIntent().getStringExtra("animal");
        TextView myText = (TextView) findViewById(R.id.textID);
        myText.setText(savedExtra);

        String workoutDescripTest = getIntent().getStringExtra("species");
        TextView myText2 = (TextView) findViewById(R.id.textID6);
        myText2.setText(workoutDescripTest);

        String workoutTypeTest = "Makeswitch";
        TextView myText3 = (TextView) findViewById(R.id.textID3);
        myText3.setText(workoutTypeTest);
    }
}
