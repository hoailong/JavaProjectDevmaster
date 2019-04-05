package com.devmaster.restaurantmanagement.service.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IUserGroupDAO;
import com.devmaster.restaurantmanagement.dao.impl.UserGroupDAO;
import com.devmaster.restaurantmanagement.model.UserGroupModel;
import com.devmaster.restaurantmanagement.service.IUserGroupService;

public class UserGroupService implements IUserGroupService{

	private IUserGroupDAO userGroupDao;
	
	public UserGroupService() {
		userGroupDao = new  UserGroupDAO();
	}
	@Override
	public List<UserGroupModel> findAll() {
		return userGroupDao.findAll();
	}

	@Override
	public UserGroupModel findOne(int id) {
		// TODO Auto-generated method stub
		return userGroupDao.findById(id);
	}

}
