package com.devmaster.restaurantmanagement.servlet.admin.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.model.AbstractModel;
import com.devmaster.restaurantmanagement.model.TimeModel;
import com.devmaster.restaurantmanagement.service.ITimeService;
import com.devmaster.restaurantmanagement.service.impl.TimeService;
import com.devmaster.restaurantmanagement.util.Constant;
import com.devmaster.restaurantmanagement.util.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/api-admin-times")
public class TimeAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITimeService timeService;
    
    public TimeAPI() {
    	timeService = new TimeService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		
		TimeModel timeModel = HttpUtil.of(request.getReader()).toModel(TimeModel.class);
		AbstractModel obj = new AbstractModel();
		String message = timeService.add(timeModel);
		if(message.contains(Constant.SUCCESS)) {
			obj.setCode(Constant.CODE_SUCCESS);
			obj.setMsg("Thêm thời gian thành công");
		} else {
			obj.setCode("999");
			obj.setMsg(message);
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), obj);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		
		TimeModel timeModel = HttpUtil.of(request.getReader()).toModel(TimeModel.class);
		AbstractModel obj = new AbstractModel();
		String message = timeService.update(timeModel);
		if(message.contains(Constant.SUCCESS)) {
			obj.setCode(Constant.CODE_SUCCESS);
			obj.setMsg("Cập nhật thời gian thành công");
		} else {
			obj.setCode("999");
			obj.setMsg(message);
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), obj);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		
		TimeModel timeModel = HttpUtil.of(request.getReader()).toModel(TimeModel.class);
		AbstractModel obj = new AbstractModel();
		String message = timeService.delete(timeModel.getTimeId());
		if(message.contains(Constant.SUCCESS)) {
			obj.setCode(Constant.CODE_SUCCESS);
			obj.setMsg("Xóa thời gian thành công");
		} else {
			obj.setCode("999");
			obj.setMsg(message);
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), obj);
	}

}
