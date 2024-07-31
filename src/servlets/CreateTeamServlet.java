package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeamDao;
import users.Team;

/**
 * Servlet implementation class CreateTeamServlet
 */
@WebServlet("/servlets/CreateTeamServlet")
public class CreateTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int maxnum=Integer.parseInt(request.getParameter("maxnum")); 
		String teamholder=request.getParameter("teamholder");
		String start=request.getParameter("startcon");
		String end=request.getParameter("endcon");
		String startdetial=request.getParameter("startdetialcon");
		String enddetial=request.getParameter("enddetialcon");
		String time=request.getParameter("starttime");
		Team team=new Team();
		team.setEnd(end);
		team.setEnddetial(enddetial);
		team.setMaxnum(maxnum);
		team.setStart(start);
		team.setStartdetial(startdetial);
		team.setTeamholder(teamholder);
		team.setTime(time);
		TeamDao teamDao=new TeamDao();
		try {
			teamDao.create(team,(String) request.getSession().getAttribute("account"));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		response.sendRedirect("../systems/teamhold.jsp");
		out.print("<script>alert('队伍创建成功')</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
