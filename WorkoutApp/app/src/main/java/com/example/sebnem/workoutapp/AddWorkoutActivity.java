package com.example.sebnem.workoutapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddWorkoutActivity extends AppCompatActivity implements View.OnClickListener {

    Intent _intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        _intent = getIntent();

        Button action_add_workout = (Button) findViewById(R.id.action_add_workout);
        action_add_workout.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.action_add_workout:
                try{
                    String workoutName = ((EditText) findViewById(R.id.wName)).getText().toString();
                    String workoutDes = ((EditText) findViewById(R.id.wDes)).getText().toString();
                    int workoutDur = Integer.parseInt(((EditText) findViewById(R.id.wDur)).getText().toString());

                    User.getInstance().addWorkout(workoutName, true, workoutDes, workoutDur);
                    Intent intent = new Intent();
                    intent.putExtra("Workout", workoutName);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                catch(Exception e){
                    System.out.println(e);
                }
            default:
                break;
        }
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
