package com.devmaster.restaurantmanagement.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.model.OrdersModel;
import com.devmaster.restaurantmanagement.model.TimeModel;
import com.devmaster.restaurantmanagement.service.IOrdersService;
import com.devmaster.restaurantmanagement.service.ITimeService;
import com.devmaster.restaurantmanagement.service.impl.OrdersService;
import com.devmaster.restaurantmanagement.service.impl.TimeService;
import com.devmaster.restaurantmanagement.util.Constant;
import com.devmaster.restaurantmanagement.util.FormUtil;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITimeService timeService;
    private IOrdersService ordersService;
    
    public OrderServlet() {
    	timeService = new TimeService();
    	ordersService = new OrdersService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(Constant.PAGEACTIVE, 3);
		List<TimeModel> listTime = timeService.findAll();
		request.setAttribute("listTime", listTime);
		RequestDispatcher rd = request.getRequestDispatcher("/view/order.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.CHARACTER_ENCODING);
		response.setContentType(Constant.CONTENT_TYPE);
		OrdersModel ordersModel = FormUtil.toModel(OrdersModel.class, request);
		String msg = "";
		if (ordersService.insert(ordersModel)) {
			msg = "Cảm ơn, yêu cầu đặt bàn của bạn đang chờ đợi để được xác nhận. "
					+ "Chúng tôi sẽ liên hệ với bạn trong thời gian sớm nhất có thể. "
					+ "Nếu có bất kỳ khó khăn nào trong lúc đặt bàn,"
					+ "bạn có thể liên hệ trực tiếp với chúng tôi qua Hotline: 0969543024.";
		}
		else {
			msg = "Đặt bàn không thành công!";
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("/trang-chu");
		rd.forward(request, response);
		/*response.sendRedirect(request.getContextPath());*/
	}

}
