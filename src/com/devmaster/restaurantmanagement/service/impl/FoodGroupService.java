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

	@Override
	public List<FoodGroupModel> findByName(String name) {
		return foodGroupDao.findByName(name);
	}

	@Override
	public boolean add(FoodGroupModel foodGroupModel) {
		foodGroupDao.insert(foodGroupModel);
		return true;
	}

	@Override
	public boolean update(FoodGroupModel foodGroupModel) {
		foodGroupDao.update(foodGroupModel);
		return true;
	}

	@Override
	public void delete(int id) {
		foodGroupDao.delete(id);
	}

}
