package com.devmaster.restaurantmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.devmaster.restaurantmanagement.model.UserGroupModel;

public class UserGroupMapper implements RowMapper<UserGroupModel>{

	@Override
	public UserGroupModel mapRow(ResultSet resultSet) {
		try {
			UserGroupModel userGroup = new UserGroupModel();
			userGroup.setId(resultSet.getInt("GroupId"));
			userGroup.setCode(resultSet.getString("GroupCode"));
			userGroup.setName(resultSet.getString("GroupName"));
			return userGroup;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
