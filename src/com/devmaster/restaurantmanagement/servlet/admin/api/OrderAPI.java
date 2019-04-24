package com.devmaster.restaurantmanagement.servlet.admin.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.model.AbstractModel;
import com.devmaster.restaurantmanagement.model.OrderModel;
import com.devmaster.restaurantmanagement.service.IOrderService;
import com.devmaster.restaurantmanagement.service.impl.OrderService;
import com.devmaster.restaurantmanagement.util.Constant;
import com.devmaster.restaurantmanagement.util.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-admin-orders"})
public class OrderAPI extends HttpServlet{

	private static final long serialVersionUID = 8748296142481732693L;
	private IOrderService orderService;
	
	public OrderAPI() {
		orderService = new OrderService();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		OrderModel OrderModel = HttpUtil.of(request.getReader()).toModel(OrderModel.class);
		AbstractModel obj = new AbstractModel();
		String message = orderService.add(OrderModel);
		if(message.contains(Constant.SUCCESS)) {
			obj.setCode(Constant.CODE_SUCCESS);
			obj.setMsg("Thêm món thành công");
		} else {
			obj.setCode("999");
			obj.setMsg(message);
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), obj);*/
	}
	
	//sửa
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		OrderModel OrderModel = HttpUtil.of(request.getReader()).toModel(OrderModel.class);
		AbstractModel obj = new AbstractModel();
		String message = orderService.update(OrderModel);
		if(message.contains(Constant.SUCCESS)) {
			obj.setCode(Constant.CODE_SUCCESS);
			obj.setMsg("Cập nhật order thành công");
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
		OrderModel OrderModel = HttpUtil.of(request.getReader()).toModel(OrderModel.class);
		AbstractModel obj = new AbstractModel();
		String message = orderService.delete(OrderModel.getOrderId());
		if(message.contains(Constant.SUCCESS)) {
			obj.setCode(Constant.CODE_SUCCESS);
			obj.setMsg("Xóa order thành công");
		} else {
			obj.setCode("999");
			obj.setMsg(message);
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), obj);
	}
}
