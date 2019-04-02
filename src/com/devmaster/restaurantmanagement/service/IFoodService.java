package com.devmaster.restaurantmanagement.service;

import java.util.List;

import com.devmaster.restaurantmanagement.model.FoodModel;

public interface IFoodService {

	List<FoodModel> findByCode(String groupCode);		
	List<FoodModel> findTop(String groupCode);		
}
