package detection.defense.cache.pollution.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import detection.defense.cache.pollution.dao.SecurityDAO;

@WebServlet("/ActiveInterestServlet_router")
public class ActiveInterestServlet_router extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fid = Integer.parseInt(request.getParameter("fid"));
		if(fid!=0) 
		{
			try {
				int i = new SecurityDAO().routerAcceptInterest(fid);
				if(i!=0) 
				{
					RequestDispatcher rd = request.getRequestDispatcher("acceptRequest_router.jsp?status=Activated Successfully");
					rd.include(request, response);
				}
				else 
				{
					RequestDispatcher rd = request.getRequestDispatcher("acceptRequest_router.jsp?status=<font color=red>Faild to Active</font>");
					rd.include(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				RequestDispatcher rd = request.getRequestDispatcher("acceptRequest_router.jsp?status=<font color=red>Some Internal Error</font>");
				rd.include(request, response);
			}
		}
		else 
		{
			RequestDispatcher rd = request.getRequestDispatcher("acceptRequest_router.jsp?status=<font color=red>Fid not capture</font>");
			rd.include(request, response);
		}
	}
}
