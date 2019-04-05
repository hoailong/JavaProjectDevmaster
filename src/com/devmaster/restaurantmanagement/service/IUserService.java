package com.devmaster.restaurantmanagement.service;

import java.util.List;

import com.devmaster.restaurantmanagement.model.UserModel;

public interface IUserService {
	List<UserModel> findUserByRole(int groupId);
	UserModel findUser(String username, String pass);
	UserModel findUserById(int id);
	boolean checkContain(String username);
	boolean add(UserModel userModel);
	boolean update(UserModel userModel);
	void delete(int id);
}
