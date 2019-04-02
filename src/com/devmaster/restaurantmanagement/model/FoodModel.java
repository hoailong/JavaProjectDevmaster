package com.devmaster.restaurantmanagement.model;

public class FoodModel {
	private int foodId;
	private String foodName;
	private String image;
	private int cost;
	private int groupId;

	public FoodModel() {
		super();
	}

	public FoodModel(int foodId, String foodName, String image, int cost, int groupId) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.image = image;
		this.cost = cost;
		this.groupId = groupId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "FoodModel [foodId=" + foodId + ", foodName=" + foodName + ", image=" + image + ", cost=" + cost
				+ ", groupId=" + groupId + "]";
	}

}
