package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import users.Customer;

public class ChangePhoneServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1841497290006540815L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); 
		String phone=new String(request.getParameter("phonenumber"));
		Customer user=(Customer) request.getSession().getAttribute("list");			
		user.setPhonenumber(phone);	
        UserDao dao=new UserDao();
		try {
			dao.changePhone(user.getAccount(), phone);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		response.sendRedirect("../users/security.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
