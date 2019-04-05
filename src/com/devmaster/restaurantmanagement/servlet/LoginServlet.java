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
import com.devmaster.restaurantmanagement.util.SessionUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService userService;   
    public LoginServlet() {
    	userService = new UserService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		HttpSession session = request.getSession();
		session.invalidate();*/
		RequestDispatcher rd = request.getRequestDispatcher("View/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userName");
		String pass = request.getParameter("password");
		
		UserModel  user=  userService.findUser(username, pass);
		if (user != null) {
			SessionUtil.getInstance().putValue(request, Constant.LOGINEDUSER, user);
			if (user.getGroupId() == 1) {
				response.sendRedirect(request.getContextPath()+"/admin");
			}
			else {
				response.sendRedirect(request.getContextPath()+"/");
			}
		}
		else {
			request.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng !");
			RequestDispatcher rd = request.getRequestDispatcher("View/login.jsp");
			rd.forward(request, response);
		}
	}

}
