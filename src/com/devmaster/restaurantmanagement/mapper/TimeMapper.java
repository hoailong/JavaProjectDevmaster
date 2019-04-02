package com.devmaster.restaurantmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.devmaster.restaurantmanagement.model.TimeModel;

public class TimeMapper implements RowMapper<TimeModel>{

	@Override
	public TimeModel mapRow(ResultSet resultSet) {
		try {
			TimeModel time = new TimeModel();
			time.setTimeId(resultSet.getInt("TimeId"));
			time.setName(resultSet.getString("TimeName"));
			return time;
		}
		catch(SQLException e) {
			e.printStackTrace();

			return null;
		}
	}

}
