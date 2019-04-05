package com.devmaster.restaurantmanagement.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.service.IUserGroupService;
import com.devmaster.restaurantmanagement.service.IUserService;
import com.devmaster.restaurantmanagement.service.impl.UserGroupService;
import com.devmaster.restaurantmanagement.service.impl.UserService;

@WebServlet("/admin-users")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService;
	private IUserGroupService userGroupService;

	public UsersServlet() {
		userService = new UserService();
		userGroupService = new UserGroupService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		String url = "";
		if (type != null) {
			if (type.equals("delete")) {
				
			} else {
				request.setAttribute("roles", userGroupService.findAll());
				if (type.equals("edit")) {
					int id = Integer.parseInt(request.getParameter("id"));
					request.setAttribute("user", userService.findUserById(id));
					url = "admin/edituser.jsp";
				} else if (type.equals("add")) {
					url = "admin/edituser.jsp";
				}
			}
		} else {
			request.setAttribute("admins", userService.findUserByRole(1));
			request.setAttribute("customers", userService.findUserByRole(2));
			url = "admin/users.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
