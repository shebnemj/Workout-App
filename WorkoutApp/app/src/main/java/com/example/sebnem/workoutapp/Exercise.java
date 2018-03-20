package com.example.sebnem.workoutapp;

import android.support.constraint.solver.widgets.ConstraintAnchor;

public abstract class Exercise {

    private String exerciseName;
    private String description;
    private int imageLink;
    private String link;
    private String notes;
    private String equipment;

    public static final Exercise[] exercises = {
            //new Cardio("Climbers","climbers", R.drawable.yogamatt,"equipment"),
            new Muscle("Barbell Shrugs","",R.drawable.barbell_shrugs,""),
            new Muscle("Bench Press","",R.drawable.bench_press,""),
            new Muscle("Butterfly Machine","",R.drawable.butterfly_machine,""),
            new Muscle("Cable Crossover","",R.drawable.cable_crossover,""),
            new Muscle("Chest Dips","",R.drawable.chest_dips,""),
            new Muscle("Chin Ups","",R.drawable.chin_ups,""),
            new Muscle("Dumbbell Flys","",R.drawable.dumbbell_flys,""),
            new Muscle("Dumbbell Lunges","",R.drawable.dumbbell_lunges,""),
            new Muscle("Front Dumbbell Raise","",R.drawable.front_dumbbell_raise,""),
            new Muscle("Leg Extensions","",R.drawable.leg_extensions,""),
            new Muscle("Machine Bench Press","",R.drawable.machine_bench_press,""),
            new Muscle("Narrow Stance Leg Press","",R.drawable.narrow_stance_leg_press,""),
            new Muscle("Pull Ups","",R.drawable.pull_ups,""),
            new Muscle("Push Ups","",R.drawable.push_ups,""),
            new Muscle("Seated Barbell Shoulder Press","",R.drawable.seated_barbell_shoulder_press,""),
            new Muscle("Seated Cable Rows","",R.drawable.seated_cable_rows,""),
            new Muscle("Seated Leg Curl","",R.drawable.seated_leg_curl,""),
            new Muscle("Seated Shoulder Press Machine","",R.drawable.seated_shoulder_press_machine,""),
            new Muscle("Shoulder Shrugs","",R.drawable.shoulder_shrugs,""),
            new Muscle("Squats Using Dumbbells","",R.drawable.squats_using_dumbbells,""),
            new Muscle("Upright Cable Row","",R.drawable.upright_cable_row,""),
            new Muscle("Wide Grip Lat Pull Down","",R.drawable.wide_grip_lat_pull_down,"")
    };

    public static String[] eNames(){
        String[] names=new String[exercises.length];
        for (int i=0;i<names.length;i++){
            names[i]=exercises[i].getExerciseName();
        }
        return names;
    }
    public static Integer[] eImages(){
        Integer[] images=new Integer[exercises.length];
        for (int i=0;i<images.length;i++){
            images[i]=exercises[i].getImage();
        }
        return images;
    }

    public Exercise(String name, String descrip, int imglink, String equip) {
        setExerciseName(name);
        setDescription(descrip);
        setImage(imglink);
        setEquipment(equip);
        ExerciseStats stats = new ExerciseStats();
        stats.setCount(0);
    }

    public String getExerciseName() {
        return this.exerciseName;
    }

    public String getDescription() {
        return this.description;
    }

    public int getImage() {
        return this.imageLink;
    }

    public String getLink() { return this.link; }

    public String getNotes() {
        return this.notes;
    }

    public String getEquipment() { return this.equipment; }

    public void setExerciseName(String name) {
        this.exerciseName = name;
    }

    public void setDescription(String descrip) {
        this.description = descrip;
    }

    public void setImage(int imglink) {
        this.imageLink = imglink;
    }

    public void setLink(String hyperlink) {
        this.link = hyperlink;
    }

    public void setNotes(String newnote) {
        this.notes = newnote;
    }

    public void setEquipment(String equip) {
        this.equipment = equip;
    }

}
