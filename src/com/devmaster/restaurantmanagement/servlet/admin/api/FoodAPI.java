package com.devmaster.restaurantmanagement.servlet.admin.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.model.AbstractModel;
import com.devmaster.restaurantmanagement.model.FoodModel;
import com.devmaster.restaurantmanagement.service.IFoodService;
import com.devmaster.restaurantmanagement.service.impl.FoodService;
import com.devmaster.restaurantmanagement.util.Constant;
import com.devmaster.restaurantmanagement.util.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-admin-foods"})
public class FoodAPI extends HttpServlet{

	private static final long serialVersionUID = 8748296142481732693L;
	private IFoodService foodService;
	
	public FoodAPI() {
		foodService = new FoodService();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		FoodModel foodModel = HttpUtil.of(request.getReader()).toModel(FoodModel.class);
		AbstractModel obj = new AbstractModel();
		String message = foodService.add(foodModel);
		if(message.contains(Constant.SUCCESS)) {
			obj.setCode(Constant.CODE_SUCCESS);
			obj.setMsg("Thêm món thành công");
		} else {
			obj.setCode("999");
			obj.setMsg(message);
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), obj);
	}
	
	//sửa
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		FoodModel foodModel = HttpUtil.of(request.getReader()).toModel(FoodModel.class);
		AbstractModel obj = new AbstractModel();
		String message = foodService.update(foodModel);
		if(message.contains(Constant.SUCCESS)) {
			obj.setCode(Constant.CODE_SUCCESS);
			obj.setMsg("Cập nhật món thành công");
		} else {
			obj.setCode("999");
			obj.setMsg(message);
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), obj);
	}
	
	//xóa
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		FoodModel foodModel = HttpUtil.of(request.getReader()).toModel(FoodModel.class);
		AbstractModel obj = new AbstractModel();
		String message = foodService.delete(foodModel.getFoodId());
		if(message.contains(Constant.SUCCESS)) {
			obj.setCode(Constant.CODE_SUCCESS);
			obj.setMsg("Xóa món thành công");
		} else {
			obj.setCode("999");
			obj.setMsg(message);
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), obj);
	}
}
