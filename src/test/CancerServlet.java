package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devmaster.restaurantmanagement.dao.impl.OrderDAO;

@WebServlet("/Cancer")
public class CancerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CancerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int idTable = Integer.parseInt(request.getParameter("tableId"));
		int idTime = Integer.parseInt(request.getParameter("timeId"));
		OrderDAO orderDao = new OrderDAO();
		orderDao.delete(idTable, idTime);
		
		request.setAttribute("message", "Hủy thành công!");
		
		RequestDispatcher rd = request.getRequestDispatcher("/Order");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
