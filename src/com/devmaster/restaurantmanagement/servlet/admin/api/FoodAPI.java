package com.devmaster.restaurantmanagement.servlet.admin.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.model.FoodModel;
import com.devmaster.restaurantmanagement.service.IFoodService;
import com.devmaster.restaurantmanagement.service.impl.FoodService;
import com.devmaster.restaurantmanagement.util.Constant;
import com.devmaster.restaurantmanagement.util.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-admin-food"})
public class FoodAPI extends HttpServlet{

	private static final long serialVersionUID = 8748296142481732693L;
	private IFoodService foodService;
	
	public FoodAPI() {
		foodService = new FoodService();
	}
	//thêm
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		FoodModel foodModel = HttpUtil.of(request.getReader()).toModel(FoodModel.class);
		foodService.save(foodModel);
		
		//chuyển từ object về json
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), foodModel);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	//sửa
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	//xóa
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
