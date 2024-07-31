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

public class RegServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5802253709447666901L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();		
		String account=request.getParameter("account"); 
		String password=request.getParameter("password");
		String phone="";
		if(request.getParameter("phone")!="") {
		phone=request.getParameter("phone");}
		String name=request.getParameter("zname");
		String sex=request.getParameter("sex");
		String age=request.getParameter("age");
		String mail=request.getParameter("email");
		Customer user = new Customer();
		user.setAccount(account);
		user.setPassword(password);
		user.setName(name);
		user.setMail(mail);
		user.setSex(sex);
		user.setAge(age);
		UserDao userDao=new UserDao();
		user.setPhonenumber(phone);
		try {
			if(userDao.userIsExist(account)){	
			    userDao.reg(user);
				request.setAttribute("ok", "1");
				response.setHeader("refresh","5;URL=../users/login.jsp");}
			else{
				out.print("<script>alert('ע��ʧ��(�û����Ѵ���)!');window.navigate('../users/reg.jsp');</script>");
				//response.sendRedirect("reg.jsp");
				}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}		
			out.flush();
			out.close();			
		}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}