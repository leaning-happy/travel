package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeamDao;
import users.Customer;
import users.Team;
@WebServlet("/servlets/CheckTeamServlet")
public class CheckTeamServlet  extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6864759249623887334L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		List<Team> list=new ArrayList<Team>();
		TeamDao teamdao=new TeamDao();
		Customer user=(Customer) request.getSession().getAttribute("list");
		if(user==null) {
			out.write("<script>alert('请先登录');window.location.href='../systems/teamhold.jsp'</script>");
		}
		else {
			try {
				list=teamdao.getteam(user.getAccount());
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			request.getSession().setAttribute("teamlist",list);
			response.sendRedirect("../users/schedule.jsp");
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}