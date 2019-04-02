package com.devmaster.restaurantmanagement.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.dao.impl.OrderDAO;
import com.devmaster.restaurantmanagement.model.OrderModel;

@WebServlet("/Order3")
public class OrderServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderServlet3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int idTable = Integer.parseInt(request.getParameter("tableId"));
		int idTime = Integer.parseInt(request.getParameter("timeId"));
		
		OrderDAO orderDao = new OrderDAO();
		OrderModel orderModel = new OrderModel();
		orderModel.setTableId(idTable);
		orderModel.setTimeId(idTime);
		
		orderDao.insert(orderModel);
		
		request.setAttribute("tableId", idTable);
		request.setAttribute("timeId", idTime);
		
		RequestDispatcher rd = request.getRequestDispatcher("/View/order3.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
