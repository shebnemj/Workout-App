package com.example.sebnem.workoutapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AddExerciseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        final EditText name = (EditText) findViewById(R.id.exName_input);
        final EditText desc = (EditText) findViewById(R.id.exDesc_input);
        final EditText equip = (EditText) findViewById(R.id.exEquip_input);
        final Switch s = (Switch) findViewById(R.id.switch1);

        Button action_add_exercise = (Button) findViewById(R.id.action_add_exercise);
        action_add_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!s.isChecked()) User.getInstance().getExerciseList().add(new Muscle(name.getText().toString(),desc.getText().toString(),R.drawable.dumbbell,equip.getText().toString()));
                else User.getInstance().getExerciseList().add(new Cardio(name.getText().toString(),desc.getText().toString(),R.drawable.dumbbell,equip.getText().toString()));
                Intent intent = new Intent(AddExerciseActivity.this, AllExercisesPage.class);
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
