package com.devmaster.restaurantmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.devmaster.restaurantmanagement.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel user = new UserModel();
			user.setUserId(resultSet.getInt("UserId"));
			user.setUserName(resultSet.getString("UserName"));
			user.setPassword(resultSet.getString("Password"));
			user.setFullName(resultSet.getString("FullName"));
			user.setGroupId(resultSet.getInt("GroupId"));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
