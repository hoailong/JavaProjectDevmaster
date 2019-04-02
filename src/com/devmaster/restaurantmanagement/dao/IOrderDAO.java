package com.devmaster.restaurantmanagement.dao;

import java.util.List;

import com.devmaster.restaurantmanagement.model.OrderModel;

public interface IOrderDAO extends GenericDAO<OrderModel>{
	List<OrderModel> findAll();
	void insert(OrderModel orderModel);
	void delete(int tableIdDelete, int timeIdDelete);
}
