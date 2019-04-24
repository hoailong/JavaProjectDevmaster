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

	@Override
	public void insert(TimeModel model) {
		String sql = "Insert into tblTime(TimeName) values(?)";
		udl(sql, model.getName());
	}

	@Override
	public void update(TimeModel model) {
		String sql = "UPDATE tblTime set TimeName = ? Where TimeId = ?";
		udl(sql, model.getName(), model.getTimeId());
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE from tblTime Where TimeId = ?";
		udl(sql, id);
	}

}
