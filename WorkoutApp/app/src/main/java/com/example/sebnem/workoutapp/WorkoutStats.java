package com.example.sebnem.workoutapp;

public class WorkoutStats {

	private int count;
	private int totalTime;

	public int getCount() {
		return this.count;
	}

	public int getTotalTime() {
		return this.totalTime;
	}

	public void setCount() {
		this.count += 1;
	}

	public void setTotalTime(int exerciseDuration) {
		this.totalTime += exerciseDuration;
	}

}