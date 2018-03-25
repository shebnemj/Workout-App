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
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AddExerciseActivity extends AppCompatActivity implements View.OnClickListener{

    //AllExercisesPage _parentPage;
    Intent _intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        _intent = getIntent();
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);


        Button action_add_exercise = (Button) findViewById(R.id.action_add_exercise);
        action_add_exercise.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.action_add_exercise:

                EditText name = (EditText) findViewById(R.id.exName_input);
                EditText desc = (EditText) findViewById(R.id.exDesc_input);
                EditText equip = (EditText) findViewById(R.id.exEquip_input);
                EditText exC = (EditText) findViewById(R.id.exC_input);
                EditText time = (EditText) findViewById(R.id.exTime_input);
                EditText distance = (EditText) findViewById(R.id.exDistance_input);

                String strName = name.getText().toString();
                String strDesc = desc.getText().toString();
                String strEquip = equip.getText().toString();

                try {

                    // Cardio ex = new Cardio(strName,strDesc,10,strEquip);
                    Exercise ex = new Muscle(strName,strDesc,R.drawable.barbell_shrugs,strEquip);

                    Intent intent = new Intent();
                    intent.putExtra("exercise", strName);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                catch(Exception ex){
                    System.out.println(ex);
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
