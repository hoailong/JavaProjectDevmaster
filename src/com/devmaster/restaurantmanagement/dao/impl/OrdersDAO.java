package com.devmaster.restaurantmanagement.dao.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IOrdersDAO;
import com.devmaster.restaurantmanagement.mapper.OrdersMapper;
import com.devmaster.restaurantmanagement.model.OrdersModel;

public class OrdersDAO extends AbstractDAO<OrdersModel> implements IOrdersDAO{

	@Override
	public List<OrdersModel> findAll() {
		String sql = "Select * from tblOrders ";
		return query(sql, new OrdersMapper());
	}

	@Override
	public void insert(OrdersModel model) {
		String sql = "Insert into tblOrders(CustomerId, DateOrder, TimeId, NumberPeople, Request) values(?,?,?,?,?)";
		udl(sql, model.getCustomerId(), model.getDateOrder(), model.getTimeId(), model.getNumberPeople(), model.getRequest());
	}

	@Override
	public void update(OrdersModel model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
