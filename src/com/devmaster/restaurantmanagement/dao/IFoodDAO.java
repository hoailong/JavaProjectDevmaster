package com.devmaster.restaurantmanagement.dao;

import java.util.List;

import com.devmaster.restaurantmanagement.model.FoodModel;

public interface IFoodDAO extends GenericDAO<FoodModel> {
	List<FoodModel> findAll();
	List<FoodModel> findByGroupCode(String groupCode);
	List<FoodModel> findByNameAndGroupCode(String name, String groupCode);
	List<FoodModel> findTopByGroupCode(String groupCode, int count);
	void insert(FoodModel foodModel);
	void update(FoodModel foodModel);
	void delete(int id);
}
