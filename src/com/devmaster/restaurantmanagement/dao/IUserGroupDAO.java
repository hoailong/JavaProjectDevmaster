package com.devmaster.restaurantmanagement.dao;

import java.util.List;

import com.devmaster.restaurantmanagement.model.UserGroupModel;

public interface IUserGroupDAO extends GenericDAO<UserGroupModel>{
	List<UserGroupModel> findAll();
	UserGroupModel findById(int id);
}
