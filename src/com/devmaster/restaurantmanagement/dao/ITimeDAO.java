package com.devmaster.restaurantmanagement.dao;

import java.util.List;

import com.devmaster.restaurantmanagement.model.TimeModel;

public interface ITimeDAO extends GenericDAO<TimeModel>{
	List<TimeModel> findAll();
	void insert(TimeModel model);
	void update(TimeModel model);
	void delete(int id);
}
