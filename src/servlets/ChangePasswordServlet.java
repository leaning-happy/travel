package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import users.Customer;

public class ChangePasswordServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6459790251831149811L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out=response.getWriter();
		String omail=new String(request.getParameter("opassword"));
		String mail=new String(request.getParameter("password"));
		Customer user=(Customer) request.getSession().getAttribute("list");
		if(user.getPassword().equals(omail)) {
		user.setPassword(mail);		
        UserDao dao=new UserDao();
		try {
			dao.changePW(user.getAccount(), mail);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		out.print("<script>alert('密码修改成功');window.location.href='../users/security.jsp';</script>");}
		else {
			out.print("<script>alert('初始密码错误');window.location.href='../users/security.jsp';</script>");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}