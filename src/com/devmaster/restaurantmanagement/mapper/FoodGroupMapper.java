package com.devmaster.restaurantmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.devmaster.restaurantmanagement.model.FoodGroupModel;

public class FoodGroupMapper implements RowMapper<FoodGroupModel> {

	@Override
	public FoodGroupModel mapRow(ResultSet resultSet) {
		try {
			FoodGroupModel foodGroup = new FoodGroupModel();
			foodGroup.setId(resultSet.getInt("GroupId"));
			foodGroup.setCode(resultSet.getString("GroupCode"));
			foodGroup.setName(resultSet.getString("GroupName"));
			return foodGroup;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
