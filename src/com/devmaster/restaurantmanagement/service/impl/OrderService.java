package com.devmaster.restaurantmanagement.service.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IOrderDAO;
import com.devmaster.restaurantmanagement.dao.impl.OrderDAO;
import com.devmaster.restaurantmanagement.model.OrderModel;
import com.devmaster.restaurantmanagement.service.IOrderService;
import com.devmaster.restaurantmanagement.util.Constant;

public class OrderService implements IOrderService{
	private IOrderDAO orderDAO;
	
	public OrderService() {
		orderDAO = new OrderDAO();
	}
	@Override
	public List<OrderModel> findAll() {
		return orderDAO.findAll();
	}

	@Override
	public String insert(OrderModel orderModel) {
		orderModel.setStatus(1);
		orderDAO.insert(orderModel);
		return Constant.SUCCESS;
	}
	@Override
	public String update(OrderModel orderModel) {
		orderDAO.update(orderModel);
		return Constant.SUCCESS;
	}
	@Override
	public String delete(int id) {
		orderDAO.delete(id);
		return Constant.SUCCESS;
	}
	

}
