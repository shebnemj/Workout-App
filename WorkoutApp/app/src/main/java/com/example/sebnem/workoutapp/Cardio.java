package com.example.sebnem.workoutapp;

public class Cardio extends Exercise {

    private int duration;
    private float distance;

    public Cardio(String name, String descrip, int imglink, String hyperlink, String newnote, String equip, int c, int time, float d) {
        super(name,descrip,imglink,hyperlink,newnote,equip,c);
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
