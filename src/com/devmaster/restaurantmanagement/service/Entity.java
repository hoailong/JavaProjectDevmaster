package com.devmaster.restaurantmanagement.service;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.impl.FoodDAO;
import com.devmaster.restaurantmanagement.dao.impl.FoodGroupDAO;
import com.devmaster.restaurantmanagement.model.FoodGroupModel;
import com.devmaster.restaurantmanagement.model.FoodModel;
import com.devmaster.restaurantmanagement.service.impl.FoodService;

public class Entity {
	public static void main(String[] args) {
		FoodGroupDAO foodGroupDAO = new FoodGroupDAO();
		List<FoodGroupModel> listFoodGroup = foodGroupDAO.findAll();
/*		for (FoodGroupModel foodGroupModel : listFoodGroup) {
			System.out.println(foodGroupModel);
		}*/
		
/*		FoodDAO foodDAO = new FoodDAO();
		List<FoodModel> listFood = foodDAO.findAll();
		for (FoodModel foodModel : listFood) {
			System.out.println(foodModel);
		}*/
		
		IFoodService foodService = new FoodService();
		List<FoodModel> listFoodTop = foodService.findAll("khai-vi");
		for (FoodModel foodModel : listFoodTop) {
			System.out.println(foodModel);
		}
	}
}
