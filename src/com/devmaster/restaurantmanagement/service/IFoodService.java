package com.devmaster.restaurantmanagement.service;

import java.util.List;

import com.devmaster.restaurantmanagement.model.FoodModel;

public interface IFoodService {
	List<FoodModel> findAll();		
	List<FoodModel> findByCode(String groupCode);		
	List<FoodModel> findByNameAndCode(String name, String groupCode);		
	List<FoodModel> findTop(String groupCode);		
	String add(FoodModel foodModel);
	String update(FoodModel foodModel);
	String delete(int id);
}
