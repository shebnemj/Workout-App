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

public class AllExercisesPage extends AppCompatActivity {


    Exercise e = new Cardio("Jumping Jacks","Okay","","yogamatt","","Yoga Matt",10,2,0);
    Exercise e2 = new Cardio("Climbers","is this gonna work i wonder", "","yogamatt","","Yoga Matt",20,2,0);
    Exercise e3 = new Cardio("Butt Kicks","okkkkkk", "","yogamatt","","Yoga Matt",20,2,0);

    String[] nameArray = {e.getExerciseName(),e2.getExerciseName(),e3.getExerciseName()};

    Integer[] imageArray = {R.drawable.yogamatt,
            R.drawable.yogamatt,
            R.drawable.yogamatt};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_exercises);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        CustomExerciseListAdapter whatever = new CustomExerciseListAdapter(this, nameArray, imageArray);
        listView = (ListView) findViewById(R.id.listview2ID);
        listView.setAdapter(whatever);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Intent intent = new Intent(AllExercisesPage.this, ExerciseDetailsPage.class);
                String message = nameArray[position];
                intent.putExtra("animal", message);
                startActivity(intent);
            }
        });
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
