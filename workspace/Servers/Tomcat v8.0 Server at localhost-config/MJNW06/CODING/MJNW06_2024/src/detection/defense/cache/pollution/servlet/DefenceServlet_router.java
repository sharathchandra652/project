package detection.defense.cache.pollution.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import detection.defense.cache.pollution.dao.SecurityDAO;
import detection.defense.cache.pollution.dbconnection.DatabaseConnection;

@WebServlet("/DefenceServlet_router")
public class DefenceServlet_router extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fid = Integer.parseInt(request.getParameter("fid"));
		PreparedStatement ps = null;
		Connection con = new DatabaseConnection().getConnection();
		String checkPopularity = null;
		String[] packets = null;
		if(fid!=0) 
		{
			try {
				ps = con.prepareStatement("select data from interest where fid=?");
				ps.setInt(1, fid);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) 
				{
					checkPopularity = rs.getString(1);
				}
				int suspeciouscontent = checkPopularity.length();
				if(suspeciouscontent==0)
				{
					RequestDispatcher rd = request.getRequestDispatcher("FLADetection_router.jsp?status=<font color=red>Suspecious Content Still Available</font>");
					rd.include(request, response);
				}
				else {
				int i = new SecurityDAO().routerDefence(fid);
				if(i!=0) 
				{
					RequestDispatcher rd = request.getRequestDispatcher("FLADetection_router.jsp?status=Restore Data Successfully");
					rd.include(request, response);
				}
				else 
				{
					RequestDispatcher rd = request.getRequestDispatcher("FLADetection_router.jsp?status=<font color=red>Faild to Active</font>");
					rd.include(request, response);
				}
				}
			} catch (Exception e) {
				e.printStackTrace();
				RequestDispatcher rd = request.getRequestDispatcher("FLADetection_router.jsp?status=<font color=red>Some Internal Error</font>");
				rd.include(request, response);
			}
		}
		else 
		{
			RequestDispatcher rd = request.getRequestDispatcher("FLADetection_router.jsp?status=<font color=red>Fid not capture</font>");
			rd.include(request, response);
		}
	}
}