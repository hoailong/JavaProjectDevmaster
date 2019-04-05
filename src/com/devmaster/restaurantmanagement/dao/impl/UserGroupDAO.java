package com.devmaster.restaurantmanagement.dao.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IUserGroupDAO;
import com.devmaster.restaurantmanagement.mapper.UserGroupMapper;
import com.devmaster.restaurantmanagement.model.UserGroupModel;

public class UserGroupDAO extends AbstractDAO<UserGroupModel> implements IUserGroupDAO{

	@Override
	public List<UserGroupModel> findAll() {
		String sql = "Select * from tblUserGroup";
		return query(sql, new UserGroupMapper());
	}

	@Override
	public UserGroupModel findById(int id) {
		String sql = "Select * from tblUserGroup where GroupId = ?";
		List<UserGroupModel> list = query(sql, new UserGroupMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

}
