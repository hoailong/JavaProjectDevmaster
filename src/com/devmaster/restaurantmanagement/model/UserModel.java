package com.devmaster.restaurantmanagement.model;

public class UserModel {
	private int userId;
	private String userName;
	private String password;
	private String fullName;
	private int groupId;
	private int gender;
	private String phone;
	private String email;
	private String address;

	public UserModel() {

	}

	public UserModel(int userId, String userName, String password, String fullName, int groupId, int gender,
			String phone, String email, String address) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.groupId = groupId;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
