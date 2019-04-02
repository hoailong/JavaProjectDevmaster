package com.devmaster.restaurantmanagement.model;

public class TimeModel {
	private int timeId;
	private String name;

	public TimeModel() {
	}

	public TimeModel(int timeId, String name) {
		super();
		this.timeId = timeId;
		this.name = name;
	}

	public int getTimeId() {
		return timeId;
	}

	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
