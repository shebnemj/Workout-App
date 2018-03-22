package com.example.sebnem.workoutapp;

public class Cardio extends Exercise {

    private int duration;
    private float distance;

    public Cardio(String name, String descrip, int imglink, String equip) {
        super(name,descrip,imglink,equip,"Cardio");
        duration=1000*5;
        distance=5.0f;
    }
    public Cardio(String name, String descrip, int imglink, String equip,int dur,float dist) {
        super(name,descrip,imglink,equip,"Cardio");
        this.duration=dur;
        this.distance=dist;
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
