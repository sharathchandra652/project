package detection.defense.cache.pollution.servlet;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import detection.defense.cache.pollution.Bean.Bean;
import detection.defense.cache.pollution.dao.SecurityDAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	static String packets; 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email =  request.getParameter("email");
		String password = request.getParameter("password");
		InetAddress host = InetAddress.getLocalHost();
		System.out.println("Host--->"+host);
		System.out.println("Host--->"+host.getHostAddress().trim());
		String str[] =  email.split("|");
		System.out.println("Packets--->%"+str+"%");
		System.out.println("URL--->"+request.getRequestURI());
		
		int uid = 0;
		String uname = null;
		String mail = null;
		
		if(email.equalsIgnoreCase("router@gmail.com")&&password.equalsIgnoreCase("router")) 
		{
			RequestDispatcher rd = request.getRequestDispatcher("RouterHome.jsp?status=<font color=white>Welcome Router</font>");
			rd.include(request, response);
		}
		else  
		{
			try {
				ArrayList<Bean> al = new SecurityDAO().pcLogin(email,password);
				for(Bean b : al) 
				{
					uid = b.getUid();
					uname = b.getUname();					
					mail = b.getEmail();
				}
				if(!al.isEmpty()) 
				{
					HttpSession session = request.getSession();
					session.setAttribute("uid", uid);
					session.setAttribute("uname", uname);
					session.setAttribute("email", email);
					RequestDispatcher rd = request.getRequestDispatcher("PCHome.jsp?status=<font color=white>Welcome "+uname+"</font>");
					rd.include(request, response);
					
				}
				else 
				{
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp?status=<font color=red>Invalid Email and Password</font>");
					rd.include(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp?status=<font color=red>Some Internal Error</font>");
				rd.include(request, response);
			}
		}
	}
}