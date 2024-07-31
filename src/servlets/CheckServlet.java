package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SceneryDao;
import users.Scenery;

public class CheckServlet extends HttpServlet{
	/**
	 *进行景点搜索
	 */
	private static final long serialVersionUID = -5734148715589828560L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    List<Scenery> list=new ArrayList<Scenery>();
	    String case1=new String(request.getParameter("inf")) ;
	    SceneryDao dao=new SceneryDao();
	    try {
			list=dao.getinformationy(case1);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	    
	    if(list.isEmpty()) {
	    	session.setAttribute("search", null);
	    }
	    else {
	    session.setAttribute("search", list);}
	    session.setAttribute("rulex", "0");
	    session.setAttribute("ruley", "0");
	    response.sendRedirect("../systems/showall.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}


}
