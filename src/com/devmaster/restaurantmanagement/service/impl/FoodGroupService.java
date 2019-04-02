package com.devmaster.restaurantmanagement.service.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IFoodGroupDAO;
import com.devmaster.restaurantmanagement.dao.impl.FoodGroupDAO;
import com.devmaster.restaurantmanagement.model.FoodGroupModel;
import com.devmaster.restaurantmanagement.service.IFoodGroupService;

public class FoodGroupService implements IFoodGroupService{
	private IFoodGroupDAO foodGroupDao;
	
	public FoodGroupService() {
		this.foodGroupDao = new FoodGroupDAO();
	}

	@Override
	public List<FoodGroupModel> findAll() {
		return foodGroupDao.findAll();
	}

}
