package com.devmaster.restaurantmanagement.dao;

import java.util.List;

import com.devmaster.restaurantmanagement.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	List<UserModel> findAll();
	List<UserModel> findByGroupId(int groupId);
	UserModel findByUserNameAndPassword(String username, String pass);
	UserModel findByUserName(String username);
	UserModel findById(int id);
	void insert(UserModel userModel);
	void update(UserModel userModel);
	void delete(int id);
}
