package com.devmaster.restaurantmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.devmaster.restaurantmanagement.model.OrderModel;

public class OrderMapper implements RowMapper<OrderModel>{

	@Override
	public OrderModel mapRow(ResultSet resultSet) {
		try {
			OrderModel order = new OrderModel();
			order.setOrderId(resultSet.getInt("OrderId"));
			order.setCustomerId(resultSet.getInt("CustomerId"));
			order.setDateOrder(resultSet.getDate("DateOrder"));
			order.setTimeId(resultSet.getInt("TimeId"));
			order.setNumberPeople(resultSet.getInt("NumberPeople"));
			order.setRequest(resultSet.getString("Request"));
			order.setStatus(resultSet.getInt("Status"));
			return order;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
