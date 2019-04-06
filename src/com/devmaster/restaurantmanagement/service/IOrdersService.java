package com.devmaster.restaurantmanagement.service;

import java.util.List;

import com.devmaster.restaurantmanagement.model.OrdersModel;

public interface IOrdersService {
	List<OrdersModel> findAll();
	boolean insert(OrdersModel ordersModel);
}
