package com.devmaster.restaurantmanagement.model;

public class TableModel {
	private int tableId;
	private String name;
	private int maxPeople;
	private int status;

	public TableModel() {
	}

	public TableModel(int tableId, String name, int maxPeople, int status) {
		this.tableId = tableId;
		this.name = name;
		this.maxPeople = maxPeople;
		this.status = status;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
