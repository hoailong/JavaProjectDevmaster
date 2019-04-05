package com.devmaster.restaurantmanagement.service;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.impl.FoodGroupDAO;
import com.devmaster.restaurantmanagement.model.FoodGroupModel;
import com.devmaster.restaurantmanagement.model.UserModel;
import com.devmaster.restaurantmanagement.service.impl.UserService;

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
		
		IUserService userService  = new UserService();
		UserModel  user=  userService.findUser("admin", "admin");
//		for (UserModel userModel : user) {
			System.out.println(user);
//		}
//		List<UserModel>  user=  userService.findOne("aaa", "aaaa");
//		UserModel user = userService.findByUserName("xxx");
//		if (user != null)
//			System.out.println(user);
//		else {
//			System.out.println("Empty");
//		}
	}
}
