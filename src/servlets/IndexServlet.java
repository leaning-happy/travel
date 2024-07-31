package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SceneryDao;
import users.Scenery;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
	    String case1=new String(request.getParameter("case1"));
	    case1= new String(case1.getBytes("ISO8859-1"), "UTF-8");
	    //System.out.println(URLDecoder.decode(request.getParameter("case1"),"utf-8"));
	    //System.out.println(case1);
	    List<Scenery> list=new ArrayList<Scenery>();
	    List<Scenery> listx=new ArrayList<Scenery>();
	    SceneryDao dao=new SceneryDao();
	    try {
			list=dao.getinformationb(case1);
			listx=dao.getinformationz();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	    request.getSession().setAttribute("scenery_list", list);
	    request.getSession().setAttribute("hot_list", listx);
		response.sendRedirect("../systems/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
