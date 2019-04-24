package com.devmaster.restaurantmanagement.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.service.IFoodGroupService;
import com.devmaster.restaurantmanagement.service.impl.FoodGroupService;
import com.devmaster.restaurantmanagement.util.Constant;

@WebServlet("/admin-foodgroups")
public class FoodGroupsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static IFoodGroupService foodGroupService;   
    
    public FoodGroupsServlet() {
    	foodGroupService = new FoodGroupService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		String searchName = request.getParameter("searchName");
		if (searchName != null) {
			request.setAttribute("searchName", searchName);
			request.setAttribute("foodgroups", foodGroupService.findByName(searchName));
		} else {
			request.setAttribute("foodgroups", foodGroupService.findAll());
		}
		request.setAttribute(Constant.PAGEACTIVE, 32);
		RequestDispatcher rd = request.getRequestDispatcher("admin/foodgroups.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
