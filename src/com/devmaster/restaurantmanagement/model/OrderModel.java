package com.devmaster.restaurantmanagement.model;

public class OrderModel {
	private int orderId;
	private int tableId;
	private int timeId;
	private int userId;

	public OrderModel() {
	}

	public OrderModel(int orderId, int tableId, int timeId, int userId) {
		this.orderId = orderId;
		this.tableId = tableId;
		this.timeId = timeId;
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getTimeId() {
		return timeId;
	}

	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
