package com.devmaster.restaurantmanagement.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.model.FoodGroupModel;
import com.devmaster.restaurantmanagement.model.FoodModel;
import com.devmaster.restaurantmanagement.service.IFoodGroupService;
import com.devmaster.restaurantmanagement.service.IFoodService;
import com.devmaster.restaurantmanagement.service.impl.FoodGroupService;
import com.devmaster.restaurantmanagement.service.impl.FoodService;
import com.devmaster.restaurantmanagement.util.Constant;

@WebServlet("/thuc-don")
public class ThucDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFoodGroupService foodGroupService;
	private IFoodService foodService;

	public ThucDonServlet() {
		this.foodGroupService = new FoodGroupService();
		this.foodService = new FoodService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(Constant.PAGEACTIVE, 2);
		String groupCode = request.getParameter("code");
		String url = "";
		List<FoodGroupModel> listFoodGroup = foodGroupService.findAll();
		List<FoodModel> listFood = new ArrayList<FoodModel>();
		if (groupCode == null) {
			
			for (FoodGroupModel foodGroupModel : listFoodGroup) {
				for (FoodModel foodModel : foodService.findTop(foodGroupModel.getCode())) {
					listFood.add(foodModel);
				}
			}
			url = "view/thucdon.jsp";
		}
		else {
			listFood = foodService.findByCode(groupCode);
			String groupName = "";
			for (FoodGroupModel foodGroupModel : listFoodGroup) {
				if (foodGroupModel.getCode().equals(groupCode)) {
					groupName = foodGroupModel.getName();
					break;
				}
			}
			request.setAttribute("groupCode", groupCode);
			request.setAttribute("groupName", groupName);
			url = "view/thucdonchitiet.jsp";
		}
		request.setAttribute("listFood", listFood);
		request.setAttribute("listFoodGroup", listFoodGroup);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
