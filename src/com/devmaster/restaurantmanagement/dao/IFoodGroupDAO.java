package com.devmaster.restaurantmanagement.dao;

import java.util.List;

import com.devmaster.restaurantmanagement.model.FoodGroupModel;

public interface IFoodGroupDAO extends GenericDAO<FoodGroupModel>{
	List<FoodGroupModel> findAll();
	List<FoodGroupModel> findByName(String name);
	void insert(FoodGroupModel foodGroupModel);
	void update(FoodGroupModel foodGroupModel);
	void delete(int id);
}
