package com.example.sebnem.workoutapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Workout[] workouts = {
            Workout.workouts.get(0),
            Workout.workouts.get(1),
            Workout.workouts.get(2)
    };

    String[] nameArray = {workouts[0].getWorkoutName(),workouts[1].getWorkoutName(),workouts[2].getWorkoutName()};

    Integer[] imageArray = {R.drawable.hiit,
            R.drawable.dumbbell,
            R.drawable.stretch};

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button allWorkouts = (Button) findViewById(R.id.allWorkouts);
        allWorkouts.setOnClickListener(this);

        Button allExercises = (Button) findViewById(R.id.allExercises);
        allExercises.setOnClickListener(this);
        CustomWorkoutListAdapter whatever = new CustomWorkoutListAdapter(this, nameArray, imageArray);
        listView = (ListView) findViewById(R.id.listviewID);
        listView.setAdapter(whatever);

        final List<Workout> list;

        list = new ArrayList<Workout>();

        for(int i=0;i<workouts.length;i++){
            list.add(workouts[i]);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Intent intent = new Intent(MainActivity.this, WorkoutDetailsPage.class);
                String message = nameArray[position];
                String message2 = list.get(position).getWorkoutDescription();
                Integer image = imageArray[position];
                intent.putExtra("animal", message);
                intent.putExtra("species", message2);
                intent.putExtra("maybimage", image);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.allWorkouts:
                Intent intent = new Intent(MainActivity.this, AllWorkoutsPage.class);
                startActivity(intent);
                break;
            case R.id.allExercises:
                intent = new Intent(MainActivity.this, AllExercisesPage.class);
                startActivity(intent);
                break;
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
