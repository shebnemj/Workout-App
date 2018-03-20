package com.example.sebnem.workoutapp;

public class Muscle extends Exercise {

	private int reps;
	private float equipmentWeight;
	private String muscleType;

	public Muscle(String name, String descrip, int imglink, String equip) {
		super(name,descrip,imglink,equip);
	}

	public int getReps() {
		return this.reps;
	}

	public float getEquipmentWeight() {
		return this.equipmentWeight;
	}

	public String getMuscleType() {
		return this.muscleType;
	}

	public void setReps(int rep) {
		this.reps = rep;
	}

	public void setEquipmentWeight(float weight) {
		this.equipmentWeight = weight;
	}

	public void setMuscleType(String muscleName) {
		this.muscleType = muscleName;
	}

}