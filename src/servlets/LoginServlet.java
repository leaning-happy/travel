package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SceneryDao;
import dao.UserDao;
import users.Customer;
import users.Scenery;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3535656831747710539L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String account=new String(request.getParameter("acount"));
		String pwd=new String(request.getParameter("password"));
//		String type=new String(req.getParameter("type"));
//		System.out.println(type);
		Customer user=new Customer();
		user.setAccount(account);
		user.setPassword(pwd);
		UserDao dao=new UserDao();
		boolean isLogin;
		try {
			isLogin=dao.login(user);
			if(isLogin){
				response.sendRedirect("../systems/index.jsp");
				List<Scenery> listl=new ArrayList<Scenery>();
				SceneryDao sceneryDao=new SceneryDao();
				listl=sceneryDao.getlikescenery(account);
				request.getSession().setAttribute("recommend_list",listl);
				request.getSession().setAttribute("account", account);
				request.getSession().setAttribute("name", dao.readname(account));
				request.getSession().setAttribute("list", dao.Dsql(account));
			}else{
				out.print("<script>alert('’À∫≈ªÚ√‹¬Î¥ÌŒÛ');window.location.href='../users/login.jsp';</script>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}