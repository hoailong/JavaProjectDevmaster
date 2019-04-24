package com.devmaster.restaurantmanagement.service.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IFoodDAO;
import com.devmaster.restaurantmanagement.dao.impl.FoodDAO;
import com.devmaster.restaurantmanagement.model.FoodModel;
import com.devmaster.restaurantmanagement.service.IFoodService;
import com.devmaster.restaurantmanagement.util.Constant;

public class FoodService implements IFoodService {
	private IFoodDAO foodDao;

	public FoodService() {
		this.foodDao = new FoodDAO();
	}

	@Override
	public List<FoodModel> findAll() {
		return foodDao.findAll();
	}

	@Override
	public List<FoodModel> findByCode(String groupCode) {
		return foodDao.findByGroupCode(groupCode);
	}

	@Override
	public List<FoodModel> findTop(String groupCode) {
		return foodDao.findTopByGroupCode(groupCode, 6);
	}

	@Override
	public List<FoodModel> findByNameAndCode(String name, String groupCode) {
		return foodDao.findByNameAndGroupCode(name, groupCode);
	}

	@Override
	public String add(FoodModel foodModel) {
		foodDao.insert(foodModel);
		return Constant.SUCCESS;
	}

	@Override
	public String update(FoodModel foodModel) {
		foodDao.update(foodModel);
		return Constant.SUCCESS;
	}

	@Override
	public String delete(int id) {
		foodDao.delete(id);
		return Constant.SUCCESS;
	}

}
