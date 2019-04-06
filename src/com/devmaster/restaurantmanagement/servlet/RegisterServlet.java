package com.devmaster.restaurantmanagement.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.model.UserModel;
import com.devmaster.restaurantmanagement.service.IUserService;
import com.devmaster.restaurantmanagement.service.impl.UserService;
import com.devmaster.restaurantmanagement.util.Constant;
import com.devmaster.restaurantmanagement.util.FormUtil;
import com.devmaster.restaurantmanagement.util.SessionUtil;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService userService;   
    public RegisterServlet() {
    	userService = new UserService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("view/register.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE_JSON);
		UserModel userModel = FormUtil.toModel(UserModel.class, request);
		if(userService.add(userModel)) {
			SessionUtil.getInstance().putValue(request, Constant.LOGINEDUSER, userModel);
			response.sendRedirect(request.getContextPath()+"/");
		}
		else {
			request.setAttribute("error", "Tài khoản đã tồn tại !");
			RequestDispatcher rd = request.getRequestDispatcher("view/register.jsp");
			rd.forward(request, response);
		}
	}

}
