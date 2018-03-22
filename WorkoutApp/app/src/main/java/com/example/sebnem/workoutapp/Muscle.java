package com.example.sebnem.workoutapp;

public class Muscle extends Exercise {

	private int reps;
	private float equipmentWeight;
	private String muscleType;

	public Muscle(String name, String descrip, int imglink, String equip) {
		super(name,descrip,imglink,equip);
		reps=10;
		equipmentWeight=10.0f;
		muscleType="";
	}
	public Muscle(String name, String descrip, int imglink, String equip,int reps,float weight,String type) {
		super(name,descrip,imglink,equip);
		this.reps=reps;
		this.equipmentWeight=weight;
		this.muscleType=type;
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