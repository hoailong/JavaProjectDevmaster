package com.devmaster.restaurantmanagement.service.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IFoodDAO;
import com.devmaster.restaurantmanagement.dao.impl.FoodDAO;
import com.devmaster.restaurantmanagement.model.FoodModel;
import com.devmaster.restaurantmanagement.service.IFoodService;

public class FoodService implements IFoodService{
	private IFoodDAO foodDao;
	
	
	public FoodService() {
		this.foodDao = new FoodDAO();
	}

	@Override
	public List<FoodModel> findByCode(String groupCode) {
		return foodDao.findByGroupCode(groupCode);
	}

	@Override
	public List<FoodModel> findTop(String groupCode) {
		return foodDao.findTopByGroupCode(groupCode, 6);
	}

}
