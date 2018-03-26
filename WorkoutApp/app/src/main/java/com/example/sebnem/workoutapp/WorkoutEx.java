package com.example.sebnem.workoutapp;

/**
 * Created by Rhiannaa on 26/03/2018.
 */

public class WorkoutEx {
    Exercise ex;
    String exName;
    boolean selected = false;

    public WorkoutEx(Exercise e, boolean selected) {
        this.ex = e;
        this.exName = ex.getExerciseName();
        this.selected = selected;
    }

    public Exercise getEx() {
        return ex;
    }

    public void setEx(Exercise e) {
        this.ex = e;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }
}
