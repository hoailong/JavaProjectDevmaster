package com.devmaster.restaurantmanagement.servlet.admin.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.model.AbstractModel;
import com.devmaster.restaurantmanagement.model.UserModel;
import com.devmaster.restaurantmanagement.service.IUserService;
import com.devmaster.restaurantmanagement.service.impl.UserService;
import com.devmaster.restaurantmanagement.util.Constant;
import com.devmaster.restaurantmanagement.util.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-admin-user"})
public class UserAPI extends HttpServlet {

	private static final long serialVersionUID = 6054870653997423601L;
	private IUserService userService;
	
	public UserAPI() {
		userService = new UserService();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		UserModel userModel = HttpUtil.of(request.getReader()).toModel(UserModel.class);
		AbstractModel obj = new AbstractModel();
		if(userService.add(userModel)) {
			obj.setCode(Constant.CODE_SUCCESS);
		}
		else {
			obj.setCode("999");
			obj.setMsg("Username đã tồn tại !");
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), obj);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		UserModel userModel = HttpUtil.of(request.getReader()).toModel(UserModel.class);
		AbstractModel obj = new AbstractModel();
		if(userService.update(userModel)) {
			obj.setCode(Constant.CODE_SUCCESS);
		}
		else {
			obj.setCode("999");
			obj.setMsg("Username đã tồn tại !");
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), obj);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		UserModel userModel = HttpUtil.of(request.getReader()).toModel(UserModel.class);
		userService.delete(userModel.getUserId());
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}
