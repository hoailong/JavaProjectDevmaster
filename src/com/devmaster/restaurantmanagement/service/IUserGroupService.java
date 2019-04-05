package com.devmaster.restaurantmanagement.service;

import java.util.List;

import com.devmaster.restaurantmanagement.model.UserGroupModel;

public interface IUserGroupService {
	List<UserGroupModel> findAll();
	UserGroupModel findOne(int id);
}
