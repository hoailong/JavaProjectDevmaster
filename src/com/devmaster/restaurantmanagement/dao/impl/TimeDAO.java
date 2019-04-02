package com.devmaster.restaurantmanagement.dao.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.ITimeDAO;
import com.devmaster.restaurantmanagement.mapper.TimeMapper;
import com.devmaster.restaurantmanagement.model.TimeModel;

public class TimeDAO extends AbstractDAO<TimeModel> implements ITimeDAO {

	@Override
	public List<TimeModel> findAll() {
		String sql = "Select * from tblTime";
		List<TimeModel> list = query(sql, new TimeMapper());
		return list;
	}

}
