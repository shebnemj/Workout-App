package com.example.sebnem.workoutapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.*;

public class AllWorkoutsPage extends AppCompatActivity {
    String[] nameArray = Workout.wNames();

    Integer[] imageArray = Workout.wImages();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_workouts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        CustomWorkoutListAdapter whatever = new CustomWorkoutListAdapter(this, nameArray, imageArray);
        listView = (ListView) findViewById(R.id.listviewID);
        listView.setAdapter(whatever);

        final List<Workout> list=Workout.workouts;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Intent intent = new Intent(AllWorkoutsPage.this, WorkoutDetailsPage.class);
                String message = list.get(position).getWorkoutName();
                String message2 = list.get(position).getWorkoutDescription();
                Integer image = imageArray[position];
                intent.putExtra("name", message);
                intent.putExtra("description", message2);
                intent.putExtra("image", image);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the app bar.
        getMenuInflater().inflate(R.menu.menu_add, menu);
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
            case R.id.action_add:
                 intent = new Intent(this, AddWorkoutActivity.class);
                 startActivity(intent);
                 return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
