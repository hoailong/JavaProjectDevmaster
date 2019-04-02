package com.devmaster.restaurantmanagement.model;

public class FoodGroupModel {
	private int id;
	private String code;
	private String name;

	public FoodGroupModel() {
		super();
	}

	public FoodGroupModel(int id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FoodGroupModel [id=" + id + ", code=" + code + ", name=" + name + "]";
	}

}
