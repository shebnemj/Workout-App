package com.example.sebnem.workoutapp;

/**
 * Created by sebnem on 12/03/2018.
 */

public abstract class Exercise {

    private String exerciseName;
    private String description;
    private String imageLink;
    private String link;
    private String notes;
    private String equipment;

    public Exercise(String name, String descrip, String imglink, String hyperlink, String newnote, String equip, int c) {
        setExerciseName(name);
        setDescription(descrip);
        setImage(imglink);
        setLink(hyperlink);
        setNotes(newnote);
        setEquipment(equip);

        ExerciseStats stats = new ExerciseStats();
        stats.setCount(c);
    }

    public String getExerciseName() {
        return this.exerciseName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImage() {
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

    public void setImage(String imglink) {
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
