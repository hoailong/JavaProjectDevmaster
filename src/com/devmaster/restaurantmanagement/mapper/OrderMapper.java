package com.devmaster.restaurantmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.devmaster.restaurantmanagement.model.OrderModel;

public class OrderMapper implements RowMapper<OrderModel> {

	@Override
	public OrderModel mapRow(ResultSet resultSet) {
		try {
			OrderModel order = new OrderModel();
			order.setOrderId(resultSet.getInt("OrderId"));
			order.setTableId(resultSet.getInt("TableId"));
			order.setTimeId(resultSet.getInt("TimeId"));
			return order;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
