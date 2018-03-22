package com.example.sebnem.workoutapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;

public class ExerciseDetailsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_muscle_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        String savedExtra = getIntent().getStringExtra("animal");
        TextView myText = (TextView) findViewById(R.id.textID2);
        myText.setText(savedExtra);

        String exerciseDescripTest = getIntent().getStringExtra("species");
        TextView myText2 = (TextView) findViewById(R.id.textID14);
        myText2.setText(exerciseDescripTest);

        String exerciseEquipment = getIntent().getStringExtra("equipment");
        TextView myText3 = (TextView) findViewById(R.id.textID16);
        myText3.setText(exerciseEquipment);

        int exerciseReps = getIntent().getIntExtra("reps",0);
        TextView myText4 = (TextView) findViewById(R.id.textID30);
        myText4.setText(exerciseReps);

        Integer muscleImage = getIntent().getIntExtra("maybimage",0);
        ImageView imageView = (ImageView) findViewById(R.id.imageView3);
        imageView.setImageResource(muscleImage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the app bar.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_profile:
                intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

