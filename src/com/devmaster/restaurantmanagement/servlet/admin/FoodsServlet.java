package com.devmaster.restaurantmanagement.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.service.IFoodGroupService;
import com.devmaster.restaurantmanagement.service.IFoodService;
import com.devmaster.restaurantmanagement.service.impl.FoodGroupService;
import com.devmaster.restaurantmanagement.service.impl.FoodService;
import com.devmaster.restaurantmanagement.util.Constant;

@WebServlet("/admin-foods")
public class FoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static IFoodGroupService foodGroupService;   
    private static IFoodService foodService;   
    
    public FoodsServlet() {
    	foodGroupService = new FoodGroupService();
    	foodService = new FoodService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		String searchName = request.getParameter("searchName");
		String groupCode = request.getParameter("groupCode");
		request.setAttribute("foodgroups", foodGroupService.findAll());
		if (searchName != null || groupCode != null) {
			request.setAttribute("searchName", searchName);
			request.setAttribute("groupCode", groupCode);
			System.out.println("searchName: " + searchName);
			System.out.println("groupCode: " + groupCode);
			request.setAttribute("foods", foodService.findByNameAndCode(searchName, groupCode));
		} else {
			request.setAttribute("foods", foodService.findAll());
		}
		request.setAttribute(Constant.PAGEACTIVE, 31);
		RequestDispatcher rd = request.getRequestDispatcher("admin/foods.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
