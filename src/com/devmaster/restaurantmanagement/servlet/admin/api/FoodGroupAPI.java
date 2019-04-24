package com.devmaster.restaurantmanagement.servlet.admin.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.model.AbstractModel;
import com.devmaster.restaurantmanagement.model.FoodGroupModel;
import com.devmaster.restaurantmanagement.service.IFoodGroupService;
import com.devmaster.restaurantmanagement.service.impl.FoodGroupService;
import com.devmaster.restaurantmanagement.util.Constant;
import com.devmaster.restaurantmanagement.util.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/api-admin-foodgroups")
public class FoodGroupAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IFoodGroupService foodGroupService;
    
    public FoodGroupAPI() {
    	foodGroupService = new FoodGroupService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		
		FoodGroupModel foodGroupModel = HttpUtil.of(request.getReader()).toModel(FoodGroupModel.class);
		AbstractModel obj = new AbstractModel();
		if (foodGroupService.add(foodGroupModel)) {
			obj.setCode(Constant.CODE_SUCCESS);
			obj.setMsg("Thêm mới nhóm thực đơn thành công!");
		} else {
			obj.setCode("999");
			obj.setMsg("Lỗi cmnr !");
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), obj);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		
		FoodGroupModel foodGroupModel = HttpUtil.of(request.getReader()).toModel(FoodGroupModel.class);
		AbstractModel obj = new AbstractModel();
		if (foodGroupService.update(foodGroupModel)) {
			obj.setCode(Constant.CODE_SUCCESS);
			obj.setMsg("Cập nhật nhóm thực đơn thành công!");
		} else {
			obj.setCode("999");
			obj.setMsg("Lỗi cmnr !");
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), obj);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		
		FoodGroupModel foodGroupModel = HttpUtil.of(request.getReader()).toModel(FoodGroupModel.class);
		AbstractModel obj = new AbstractModel();
		foodGroupService.delete(foodGroupModel.getId());
			obj.setCode(Constant.CODE_SUCCESS);
			obj.setMsg("Xóa nhóm thực đơn thành công!");
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), obj);
	}

}
