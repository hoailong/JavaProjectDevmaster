package com.devmaster.restaurantmanagement.util;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	//Nếu chưa từng khởi tạo SessionUtil thì tạo mới
	//Nếu đã có thì dùng cái đã có
	private static SessionUtil sessionUtil = null;
	
	public static SessionUtil getInstance() {
		if (sessionUtil == null) {
			sessionUtil = new SessionUtil();
			return sessionUtil;
		}
		return sessionUtil;
	}
	
	//Lưu thông tin người dùng đã login trong Session vào Attr có chứa key để dễ nhận biết
	public void putValue(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}
	
	//Lấy thông tin người dùng đã login trong Session từ key
	public Object getValue(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}
	
	//Xóa Attr chứa thông tin khi người dùng logout
	public void removeValue(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}
}
