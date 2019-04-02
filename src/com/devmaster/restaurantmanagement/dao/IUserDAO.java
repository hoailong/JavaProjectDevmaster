package com.devmaster.restaurantmanagement.dao;

import java.util.List;

import com.devmaster.restaurantmanagement.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	List<UserModel> findAll();
}
