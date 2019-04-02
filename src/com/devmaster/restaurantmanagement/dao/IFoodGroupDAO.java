package com.devmaster.restaurantmanagement.dao;

import java.util.List;

import com.devmaster.restaurantmanagement.model.FoodGroupModel;

public interface IFoodGroupDAO extends GenericDAO<FoodGroupModel>{
	List<FoodGroupModel> findAll();
}
