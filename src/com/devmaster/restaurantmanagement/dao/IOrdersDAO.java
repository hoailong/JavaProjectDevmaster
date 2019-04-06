package com.devmaster.restaurantmanagement.dao;

import java.util.List;

import com.devmaster.restaurantmanagement.model.OrdersModel;

public interface IOrdersDAO extends GenericDAO<OrdersModel> {
	List<OrdersModel> findAll();
	void insert(OrdersModel model);
	void update(OrdersModel model);
	void delete(int id);
}
