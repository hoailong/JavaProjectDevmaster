package com.devmaster.restaurantmanagement.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.dao.impl.TableDAO;
import com.devmaster.restaurantmanagement.model.TableModel;

@WebServlet("/Order")
public class OrderServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderServlet1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TableDAO tblDao = new TableDAO();
		
		List<TableModel> listTbl = tblDao.findAll();
		
		request.setAttribute("listTable", listTbl);
		
		RequestDispatcher rd = request.getRequestDispatcher("/View/order.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
