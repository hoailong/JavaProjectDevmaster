package com.devmaster.restaurantmanagement.service.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.ITimeDAO;
import com.devmaster.restaurantmanagement.dao.impl.TimeDAO;
import com.devmaster.restaurantmanagement.model.TimeModel;
import com.devmaster.restaurantmanagement.service.ITimeService;

public class TimeService implements ITimeService{
	private ITimeDAO timeDAO;
	
	public TimeService() {
		timeDAO = new TimeDAO();
	}
	
	@Override
	public List<TimeModel> findAll() {
		return timeDAO.findAll();
	}

}
