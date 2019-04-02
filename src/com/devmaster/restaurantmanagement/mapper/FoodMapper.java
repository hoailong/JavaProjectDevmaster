package com.devmaster.restaurantmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.devmaster.restaurantmanagement.model.FoodModel;

public class FoodMapper implements RowMapper<FoodModel> {

	@Override
	public FoodModel mapRow(ResultSet resultSet) {
		try {
			FoodModel food = new FoodModel();
			food.setFoodId(resultSet.getInt("FoodId"));
			food.setFoodName(resultSet.getString("FoodName"));
			food.setImage(resultSet.getString("FoodImage"));
			food.setCost(resultSet.getInt("FoodCost"));
			food.setGroupId(resultSet.getInt("GroupId"));
			return food;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
