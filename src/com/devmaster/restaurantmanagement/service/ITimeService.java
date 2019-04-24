package com.devmaster.restaurantmanagement.service;

import java.util.List;

import com.devmaster.restaurantmanagement.model.TimeModel;

public interface ITimeService {
	List<TimeModel> findAll();
	String add(TimeModel timeModel);		
	String update(TimeModel timeModel);
	String delete(int id);
}
