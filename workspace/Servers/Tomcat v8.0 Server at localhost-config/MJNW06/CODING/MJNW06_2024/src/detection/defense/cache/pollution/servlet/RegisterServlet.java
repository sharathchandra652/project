package detection.defense.cache.pollution.servlet;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import detection.defense.cache.pollution.Bean.Bean;
import detection.defense.cache.pollution.dao.SecurityDAO;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bean b = new Bean();
		b.setUname(request.getParameter("name"));
		b.setEmail(request.getParameter("email"));
		b.setPassword(request.getParameter("password"));
		b.setMobile(request.getParameter("mobile"));
		b.setAddress(request.getParameter("address"));
		InetAddress host = InetAddress.getLocalHost();
		b.setIpaddress(host.getHostAddress().trim());
		try {
			int i = new SecurityDAO().reg(b);
			if(i!=0) 
			{
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp?status=<font color=red>Request Send to Router for Checking and Accept</font>");
				rd.include(request, response);
			}
			else 
			{
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp?status=<font color=red>Faild to Register</font>");
				rd.include(request, response);
			}
		} catch (Exception e) {			
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp?status=<font color=red>Some Internal Error</font>");
			rd.include(request, response);
		}
	}
}