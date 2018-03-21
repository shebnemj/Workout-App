package com.example.sebnem.workoutapp;

public class Settings {

	private User user=User.getInstance();
	private boolean distanceUnits;
	private boolean weightUnits;
	private boolean heightUnits;

	public String getDistanceUnit() {
		if(distanceUnits) return "km";
		else return "m";
	}

	public String getWeightUnit() {
		if(weightUnits)return "kg";
		else return "lb";
	}

	public String getHeightUnit() {
		if(heightUnits) return "m";
		else return "inches";
	}

	public void changeDistanceUnit() {
		distanceUnits=!distanceUnits;
	}

	public void changeWeightUnit() {
		weightUnits=!weightUnits;
	}
	
	public void changeHeightUnit() {
		heightUnits=!heightUnits;
	}

	public void changeUserWeight(float weight) {
        user.addWeight(weight);
	}

	public void changeUserHeight(float height) {
        user.addHeight(height);
	}
}