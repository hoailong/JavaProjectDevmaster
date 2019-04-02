package com.devmaster.restaurantmanagement.dao.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IFoodGroupDAO;
import com.devmaster.restaurantmanagement.mapper.FoodGroupMapper;
import com.devmaster.restaurantmanagement.model.FoodGroupModel;

public class FoodGroupDAO extends AbstractDAO<FoodGroupModel> implements IFoodGroupDAO{

	@Override
	public List<FoodGroupModel> findAll() {
		String sql = "Select * From tblFoodGroup";
		List<FoodGroupModel> list = query(sql, new FoodGroupMapper());
		return list;
	}

}
