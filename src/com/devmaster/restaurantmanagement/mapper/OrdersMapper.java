package com.devmaster.restaurantmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.devmaster.restaurantmanagement.model.OrdersModel;

public class OrdersMapper implements RowMapper<OrdersModel>{

	@Override
	public OrdersModel mapRow(ResultSet resultSet) {
		try {
			OrdersModel orders = new OrdersModel();
			orders.setOrderId(resultSet.getInt("OrderId"));
			orders.setCustomerId(resultSet.getInt("CustomerId"));
			orders.setDateOrder(resultSet.getString("DateOrder"));
			orders.setTimeId(resultSet.getInt("TimeId"));
			orders.setNumberPeople(resultSet.getInt("NumberPeople"));
			orders.setRequest(resultSet.getString("Request"));
			return orders;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
