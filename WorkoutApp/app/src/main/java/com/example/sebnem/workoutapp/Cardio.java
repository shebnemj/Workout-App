package com.example.sebnem.workoutapp;

public class Cardio extends Exercise {

    private int duration;
    private float distance;

    public Cardio(String name, String descrip, int imglink, String equip) {
        super(name,descrip,imglink,equip);
    }

    public int getDuration() {
        return this.duration;
    }

    public float getDistance() {
        return this.distance;
    }

    public void setDuration(int time) {
        this.duration = time;
    }

    public void setDistance(int d) {
        this.distance = d;
    }

}
