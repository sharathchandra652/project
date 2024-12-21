package detection.defense.cache.pollution.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import detection.defense.cache.pollution.dao.SecurityDAO;

@WebServlet("/AcceptNewPCServlet_router")
public class AcceptNewPCServlet_router extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		if(uid!=0) 
		{
			try {
				int i = new SecurityDAO().routerAcceptNewPC(uid);
				if(i!=0) 
				{
					RequestDispatcher rd = request.getRequestDispatcher("registerPC_router.jsp?status=Activated Successfully");
					rd.include(request, response);
				}
				else 
				{
					RequestDispatcher rd = request.getRequestDispatcher("registerPC_router.jsp?status=<font color=red>Faild to Active</font>");
					rd.include(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				RequestDispatcher rd = request.getRequestDispatcher("registerPC_router.jsp?status=<font color=red>Some Internal Error</font>");
				rd.include(request, response);
			}
		}
		else 
		{
			RequestDispatcher rd = request.getRequestDispatcher("registerPC_router.jsp?status=<font color=red>In valid UID</font>");
			rd.include(request, response);
		}
	}
}
