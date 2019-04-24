package com.devmaster.restaurantmanagement.model;

import java.sql.Date;

public class OrderModel {
	private int orderId;
	private int customerId;
	private Date dateOrder;
	private int timeId;
	private int numberPeople;
	private String request;
	private int status;

	public OrderModel() {

	}

	public OrderModel(int orderId, int customerId, Date dateOrder, int timeId, int numberPeople, String request,
			int status) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.dateOrder = dateOrder;
		this.timeId = timeId;
		this.numberPeople = numberPeople;
		this.request = request;
		this.status = status;
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

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
