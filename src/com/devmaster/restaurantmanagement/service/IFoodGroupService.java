package com.devmaster.restaurantmanagement.service;

import java.util.List;

import com.devmaster.restaurantmanagement.model.FoodGroupModel;

public interface IFoodGroupService {
		List<FoodGroupModel> findAll();		
		List<FoodGroupModel> findByName(String name);		
		boolean add(FoodGroupModel foodGroupModel);
		boolean update(FoodGroupModel foodGroupModel);
		void delete(int id);
}
