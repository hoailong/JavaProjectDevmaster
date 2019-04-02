package com.devmaster.restaurantmanagement.dao;

import java.util.List;

import com.devmaster.restaurantmanagement.model.FoodModel;

public interface IFoodDAO extends GenericDAO<FoodModel> {
	List<FoodModel> findAll();
	List<FoodModel> findByGroupCode(String groupCode);
	List<FoodModel> findTopByGroupCode(String groupCode, int count);
}
