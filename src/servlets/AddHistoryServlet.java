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

import dao.HistoryDao;
import dao.SceneryDao;
import users.Scenery;

/**
 * Servlet implementation class AddHistoryServlet
 */
@WebServlet("/servlets/AddHistoryServlet")
public class AddHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out=response.getWriter();
	    String name=new String(request.getParameter("name"));
	    String case1=new String(request.getParameter("case1"));
	    name= new String(name.getBytes("ISO8859-1"), "UTF-8");
	    HistoryDao history=new HistoryDao();
	    if(request.getSession().getAttribute("account")!=null) {
	    	history.addhistory(name,(String) request.getSession().getAttribute("account"));
	    	List<Scenery> listl=new ArrayList<Scenery>();
			SceneryDao sceneryDao=new SceneryDao();
			try {
				listl=sceneryDao.getlikescenery((String) request.getSession().getAttribute("account"));
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			request.getSession().setAttribute("recommend_list",listl);
			if("0".equals(case1)) {
		    	out.print("<script>alert('浏览纪录添加成功');"
		    			+ "window.location.href='../systems/index.jsp'</script>");
			}
			else {
		    	out.print("<script>alert('浏览纪录添加成功');"
		    			+ "window.location.href='../systems/showall.jsp'</script>");
			}
	    }
	    else {
	    response.sendRedirect("../systems/index.jsp");
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
