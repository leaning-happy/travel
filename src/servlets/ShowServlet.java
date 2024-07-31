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

public class ShowServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -880433521872950895L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
		String case1=new String(request.getParameter("case1"));
		String case2=new String(request.getParameter("case2"));
		if(case2.equals("0"))	session.setAttribute("rulex", case1);
		if(case1.equals("0"))   session.setAttribute("ruley", case2);
	    List<Scenery> list=new ArrayList<Scenery>();
	    SceneryDao dao=new SceneryDao();
	    if(!( (case2.equals ("0") )&&(case1.equals ("0") ) )){
	    try {
			list=dao.getinformationx((String) session.getAttribute("rulex"), (String) session.getAttribute("ruley"));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}}
	    if(list.isEmpty()) {
	    	session.setAttribute("search", null);
	    }
	    else {
	    session.setAttribute("search", list);}
		//out.print("<script>location.reload();</script>");//不可以使用这个，否则会导致页面不停重载，鼠标点击事件一直发生
		response.sendRedirect("../systems/showall.jsp");	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
