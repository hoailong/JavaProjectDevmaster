package com.devmaster.restaurantmanagement.service;

import java.util.List;

import com.devmaster.restaurantmanagement.model.OrderModel;

public interface IOrderService {
	List<OrderModel> findAll();
	String insert(OrderModel orderModel);		
	String update(OrderModel orderModel);
	String delete(int id);
}
