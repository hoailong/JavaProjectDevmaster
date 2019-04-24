package com.devmaster.restaurantmanagement.service.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.ITimeDAO;
import com.devmaster.restaurantmanagement.dao.impl.TimeDAO;
import com.devmaster.restaurantmanagement.model.TimeModel;
import com.devmaster.restaurantmanagement.service.ITimeService;
import com.devmaster.restaurantmanagement.util.Constant;

public class TimeService implements ITimeService{
	private ITimeDAO timeDAO;
	
	public TimeService() {
		timeDAO = new TimeDAO();
	}
	
	@Override
	public List<TimeModel> findAll() {
		return timeDAO.findAll();
	}

	@Override
	public String add(TimeModel timeModel) {
		timeDAO.insert(timeModel);
		return Constant.SUCCESS;
	}

	@Override
	public String update(TimeModel timeModel) {
		timeDAO.update(timeModel);
		return Constant.SUCCESS;
	}

	@Override
	public String delete(int id) {
		timeDAO.delete(id);
		return Constant.SUCCESS;
	}

}
