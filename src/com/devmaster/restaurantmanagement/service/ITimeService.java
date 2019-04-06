package com.devmaster.restaurantmanagement.service;

import java.util.List;

import com.devmaster.restaurantmanagement.model.TimeModel;

public interface ITimeService {
	List<TimeModel> findAll();
}
