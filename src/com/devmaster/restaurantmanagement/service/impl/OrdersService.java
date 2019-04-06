package com.devmaster.restaurantmanagement.service.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IOrdersDAO;
import com.devmaster.restaurantmanagement.dao.impl.OrdersDAO;
import com.devmaster.restaurantmanagement.model.OrdersModel;
import com.devmaster.restaurantmanagement.service.IOrdersService;

public class OrdersService implements IOrdersService{
	private IOrdersDAO ordersDAO;
	
	public OrdersService() {
		ordersDAO = new OrdersDAO();
	}
	@Override
	public List<OrdersModel> findAll() {
		return ordersDAO.findAll();
	}

	@Override
	public boolean insert(OrdersModel ordersModel) {
		ordersDAO.insert(ordersModel);
		return true;
	}

}
