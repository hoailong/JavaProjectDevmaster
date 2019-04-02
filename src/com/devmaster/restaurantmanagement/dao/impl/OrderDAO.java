package com.devmaster.restaurantmanagement.dao.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IOrderDAO;
import com.devmaster.restaurantmanagement.mapper.OrderMapper;
import com.devmaster.restaurantmanagement.model.OrderModel;

public class OrderDAO extends AbstractDAO<OrderModel> implements IOrderDAO{

	@Override
	public List<OrderModel> findAll() {
		String sql = "Select * from tblOrder";
		List<OrderModel> list = query(sql, new OrderMapper());
		return list;
	}

	@Override
	public void insert(OrderModel orderModel) {
		String sql = "Insert into tblOrder(TableId,TimeId,UserId) values(?,?,?)";
		udl(sql, orderModel.getTableId(), orderModel.getTimeId(), 1);
	}

	@Override
	public void delete(int tableIdDelete, int timeIdDelete) {
		String sql = "Delete from tblOrder where TableId = ? and TimeId = ?";
		udl(sql, tableIdDelete, timeIdDelete);
	}
}
