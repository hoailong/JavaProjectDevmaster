package com.devmaster.restaurantmanagement.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.model.UserModel;
import com.devmaster.restaurantmanagement.util.Constant;
import com.devmaster.restaurantmanagement.util.SessionUtil;

public class AuthorizationFilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//Lấy linh url,nếu vào mấy trang Admin thì filter
		String url = req.getRequestURI();
		System.out.println("Url: " + url);
		if (url.contains("/admin")) {
//			System.out.println("Truy cap: " + url);
			UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req,Constant.LOGINEDUSER);
//			System.out.println("Nguoi truy cap: " + userModel);
			if (userModel != null) {	
				//Nếu là Admin thì cho vào không thì cho ra trang chủ
				if (userModel.getGroupId() == 1) {
					chain.doFilter(request, response);
				} else if (userModel.getGroupId() == 2){
					res.sendRedirect(req.getContextPath()+"/");
				}
			} else {
				res.sendRedirect(req.getContextPath()+"/login");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
