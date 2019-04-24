package com.devmaster.restaurantmanagement.dao.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IOrderDAO;
import com.devmaster.restaurantmanagement.mapper.OrderMapper;
import com.devmaster.restaurantmanagement.model.OrderModel;

public class OrderDAO extends AbstractDAO<OrderModel> implements IOrderDAO{

	@Override
	public List<OrderModel> findAll() {
		String sql = "Select * from tblOrder ";
		return query(sql, new OrderMapper());
	}

	@Override
	public void insert(OrderModel model) {
		String sql = "Insert into tblOrder(CustomerId, DateOrder, TimeId, NumberPeople, Request, Status) values(?,?,?,?,?,?)";
		udl(sql, model.getCustomerId(), model.getDateOrder(), model.getTimeId(), model.getNumberPeople(), model.getRequest(), model.getStatus());
	}

	@Override
	public void update(OrderModel model) {
		String sql = "UPDATE tblOrder set CustomerId = ?, DateOrder = ?, TimeId = ?, NumberPeople = ?, Request = ?, Status = ? Where OrderId = ?";
		udl(sql, model.getCustomerId(), model.getDateOrder(), model.getTimeId(), model.getNumberPeople(), model.getRequest(), model.getStatus(), model.getOrderId());
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE from tblOrder Where OrderId = ?";
		udl(sql, id);
	}

}
