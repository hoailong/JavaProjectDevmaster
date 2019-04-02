package com.devmaster.restaurantmanagement.dao.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IUserDAO;
import com.devmaster.restaurantmanagement.mapper.UserMapper;
import com.devmaster.restaurantmanagement.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public List<UserModel> findAll() {
		String sql = "Select * from tbUser";
		List<UserModel> list = query(sql, new UserMapper());
		return list;
	}

}
