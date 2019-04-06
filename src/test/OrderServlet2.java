package test;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.dao.impl.OrderDAO;
import com.devmaster.restaurantmanagement.dao.impl.TimeDAO;
import com.devmaster.restaurantmanagement.model.OrderModel;
import com.devmaster.restaurantmanagement.model.TimeModel;

@WebServlet("/Order2")
public class OrderServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int idTable = Integer.parseInt(request.getParameter("tableId"));
		
		TimeDAO timeDao = new TimeDAO();
		List<TimeModel> listTime = timeDao.findAll();
		OrderDAO orderDao = new OrderDAO();
		List<OrderModel> listOrder = orderDao.findAll();
		
		request.setAttribute("idTable", idTable);
		request.setAttribute("listTable", listTime);
		request.setAttribute("listOrder", listOrder);
		
		RequestDispatcher rd = request.getRequestDispatcher("/View/order2.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
