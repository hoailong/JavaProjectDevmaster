package com.devmaster.restaurantmanagement.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.model.FoodGroupModel;
import com.devmaster.restaurantmanagement.service.IFoodGroupService;
import com.devmaster.restaurantmanagement.service.IFoodService;
import com.devmaster.restaurantmanagement.service.impl.FoodGroupService;
import com.devmaster.restaurantmanagement.service.impl.FoodService;

@WebServlet("/thuc-don-chinh")
public class ThucDonChinhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFoodGroupService foodGroupService;
	private IFoodService foodService;

	public ThucDonChinhServlet() {
		this.foodGroupService = new FoodGroupService();
		this.foodService = new FoodService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodGroupModel> listFoodGroup = foodGroupService.findAll();
		/*for (FoodGroupModel foodGroupModel : listFoodGroup) {
			request.setAttribute(foodGroupModel.getCode(), foodService.findTop(foodGroupModel.getCode()));
		}*/
		request.setAttribute("listFood", foodService.findTop(listFoodGroup.get(0).getCode()));
		request.setAttribute("listFoodGroup", listFoodGroup);
		RequestDispatcher rd = request.getRequestDispatcher("View/thucdon.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
