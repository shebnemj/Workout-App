package com.example.sebnem.workoutapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
