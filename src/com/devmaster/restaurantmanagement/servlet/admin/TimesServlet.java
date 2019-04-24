package com.devmaster.restaurantmanagement.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.service.ITimeService;
import com.devmaster.restaurantmanagement.service.impl.TimeService;
import com.devmaster.restaurantmanagement.util.Constant;

@WebServlet("/admin-times")
public class TimesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ITimeService timeService;   
    
    public TimesServlet() {
    	timeService = new TimeService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		request.setAttribute("times", timeService.findAll());
		request.setAttribute(Constant.PAGEACTIVE, 33);
		RequestDispatcher rd = request.getRequestDispatcher("admin/times.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
