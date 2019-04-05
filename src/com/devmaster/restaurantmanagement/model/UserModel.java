package com.devmaster.restaurantmanagement.model;

public class UserModel {
	private int userId;
	private String userName;
	private String password;
	private String fullName;
	private int groupId;
	private String phone;
	private String email;

	public UserModel() {

	}

	public UserModel(int userId, String userName, String password, String fullName, int groupId,
			String phone, String email) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.groupId = groupId;
		this.phone = phone;
		this.email = email;
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

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userName=" + userName + ", password=" + password + ", fullName="
				+ fullName + ", groupId=" + groupId + ", phone=" + phone + ", email=" + email + "]";
	}



}
