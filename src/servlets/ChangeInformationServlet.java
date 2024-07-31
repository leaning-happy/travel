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

public class ChangeInformationServlet extends HttpServlet{
	/**
	 * 
	 */

	private static final long serialVersionUID = 784747557521406293L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out=response.getWriter();
		String sex=new String(request.getParameter("sex"));
		String age=new String(request.getParameter("age"));
		String name=new String(request.getParameter("name"));
		String write=new String(request.getParameter("write"));
		Customer user=(Customer) request.getSession().getAttribute("list");
		user.setAge(age);
		user.setName(name);
		user.setSex(sex);
		user.setWrite(write);
		UserDao dao=new UserDao();
		try {
			dao.changeOI(user.getAccount(), name, sex, age,write);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		out.print("<script>alert('信息修改成功');window.location.href='../users/user.jsp';</script>");
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}


