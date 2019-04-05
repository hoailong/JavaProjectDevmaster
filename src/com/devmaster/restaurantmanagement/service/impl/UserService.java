package com.devmaster.restaurantmanagement.service.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IUserDAO;
import com.devmaster.restaurantmanagement.dao.impl.UserDAO;
import com.devmaster.restaurantmanagement.model.UserModel;
import com.devmaster.restaurantmanagement.service.IUserService;

public class UserService implements IUserService {
	private IUserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}

	@Override
	public UserModel findUser(String username, String pass) {
		return userDAO.findByUserNameAndPassword(username, pass);
	}

	@Override
	public boolean checkContain(String username) {
		return (userDAO.findByUserName(username) != null);
	}

	@Override
	public boolean add(UserModel userModel) {
		if (checkContain(userModel.getUserName())) {
			return false;
		}
		userDAO.insert(userModel);
		return true;
	}

	@Override
	public List<UserModel> findUserByRole(int groupId) {
		return userDAO.findByGroupId(groupId);
	}

	@Override
	public UserModel findUserById(int id) {
		return userDAO.findById(id);
	}

	@Override
	public boolean update(UserModel userModel) {
		if (checkContain(userModel.getUserName())) {
			return false;
		}
		userDAO.update(userModel);
		return true;
	}

	@Override
	public void delete(int id) {
		userDAO.delete(id);
	}

}
