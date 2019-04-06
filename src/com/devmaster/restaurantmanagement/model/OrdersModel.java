package com.devmaster.restaurantmanagement.model;

public class OrdersModel {
	private int orderId;
	private int customerId;
	private String dateOrder;
	private int timeId;
	private int numberPeople;
	private String request;

	public OrdersModel() {

	}

	public OrdersModel(int orderId, int customerId, String dateOrder, int timeId, int numberPeople, String request) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.dateOrder = dateOrder;
		this.timeId = timeId;
		this.numberPeople = numberPeople;
		this.request = request;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}

	public int getTimeId() {
		return timeId;
	}

	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}

	public int getNumberPeople() {
		return numberPeople;
	}

	public void setNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

}
