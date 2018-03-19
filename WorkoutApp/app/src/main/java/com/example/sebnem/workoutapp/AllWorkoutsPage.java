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

    Workout w = new Workout("HIIT",true, "Okay", 10);
    Workout w2 = new Workout("Lifts",false, "is this gonna work i wonder", 15);
    Workout w3 = new Workout("Yoga",false, "okkkkkk", 15);

    String[] nameArray = {w.getWorkoutName(),w2.getWorkoutName(),w3.getWorkoutName()};

    Integer[] imageArray = {R.drawable.hiit,
            R.drawable.dumbbell,
            R.drawable.stretch};

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

        final List<Workout> list;

        list = new ArrayList<Workout>();

        list.add(w);
        list.add(w2);
        list.add(w3);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Intent intent = new Intent(AllWorkoutsPage.this, WorkoutDetailsPage.class);
                String message = nameArray[position];
                String message2 = list.get(position).getWorkoutDescription();
                intent.putExtra("animal", message);
                intent.putExtra("species", message2);
                startActivity(intent);
            }
        });
    }

    /**
     * Inflates the options menu and adds items to the menu.
     *
     * @param menu Options menu
     * @return True if menu is inflated.
     */
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
