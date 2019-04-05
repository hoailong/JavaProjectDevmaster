package com.devmaster.restaurantmanagement.dao.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IUserDAO;
import com.devmaster.restaurantmanagement.mapper.UserMapper;
import com.devmaster.restaurantmanagement.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public List<UserModel> findAll() {
		String sql = "Select * from tblUser";
		List<UserModel> list = query(sql, new UserMapper());
		return list;
	}

	@Override
	public List<UserModel> findByGroupId(int groupId) {
		String sql = "Select * from tblUser where GroupId = ?";
		List<UserModel> list = query(sql, new UserMapper(), groupId);
		return list;
	}

	@Override
	public UserModel findByUserNameAndPassword(String username, String pass) {
		String sql = "Select * from tblUser where UserName = ? and Password = ?";
		List<UserModel> user = query(sql, new UserMapper(), username, pass);
		return user.isEmpty() ? null : user.get(0);
	}

	@Override
	public UserModel findByUserName(String username) {
		String sql = "Select * from tblUser where UserName = ?";
		List<UserModel> user = query(sql, new UserMapper(), username);
		return user.isEmpty() ? null : user.get(0);
	}

	@Override
	public UserModel findById(int id) {
		String sql = "Select * from tblUser where UserId = ?";
		List<UserModel> user = query(sql, new UserMapper(), id);
		return user.isEmpty() ? null : user.get(0);
	}

	@Override
	public void insert(UserModel userModel) {
		String sql = "Insert into tblUser(UserName,Password,FullName,GroupId,Phone,Email) values(?,?,?,?,?,?)";
		udl(sql, userModel.getUserName(), userModel.getPassword(), userModel.getFullName(), 
				userModel.getGroupId(), userModel.getPhone(), userModel.getEmail());
	}

	@Override
	public void update(UserModel userModel) {
		StringBuilder sb = new StringBuilder("Update tblUser Set ");
		sb.append("UserName = ?, Password = ?, FullName = ?, GroupId = ?, Phone = ?, Email = ?");
		sb.append(" Where UserId = ?");
		String sql = sb.toString();
		udl(sql, userModel.getUserName(), userModel.getPassword(), userModel.getFullName(), 
				userModel.getGroupId(), userModel.getPhone(), userModel.getEmail(), userModel.getUserId());
	}

	@Override
	public void delete(int id) {
		String sql = "Delete from tblUser Where UserId = ?";
		udl(sql, id);
	}

}
