package com.devmaster.restaurantmanagement.dao;

import java.util.List;

import com.devmaster.restaurantmanagement.model.TableModel;

public interface ITableDAO extends GenericDAO<TableModel>{
	List<TableModel> findAll();
}
