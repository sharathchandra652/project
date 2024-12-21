package detection.defense.cache.pollution.servlet;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import detection.defense.cache.pollution.Bean.Bean;
import detection.defense.cache.pollution.dao.SecurityDAO;

@WebServlet("/IntrestServlet_pc")
public class IntrestServlet_pc extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String len = request.getParameter("interest");
		System.out.println(len.length());
		System.out.println("URL--->"+request.getRequestURI()+"?"+len);
		HttpSession session = request.getSession();
		int uid = (Integer)session.getAttribute("uid");
		InetAddress host = InetAddress.getLocalHost();
		String str[] =  len.split("|");
		System.out.println("Packets--->%"+str+"%");
		int no_packets = str.length;
		
		Bean b = new Bean();
		if(len.length()<=10) 
		{
			b.setUid(uid);
			b.setIpaddress(host.getHostAddress().trim());
			b.setUrl(request.getRequestURI()+"?"+len);
			b.setPackets(str);
			b.setNpackets(str.length);
			b.setRouter("Router R1");
			b.setStatus("in active");
			b.setStatus1("active");
			b.setAddress(len);
			 try {
				int i = new SecurityDAO().pcIntrest(b);
				if(i!=0) 
				{
					RequestDispatcher rd = request.getRequestDispatcher("interest_pc.jsp?status=Request Send to Router");
					rd.include(request, response);
				}
				else 
				{
					RequestDispatcher rd = request.getRequestDispatcher("interest_pc.jsp?status=<font color=red>Faild to Send</font>");
					rd.include(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				RequestDispatcher rd = request.getRequestDispatcher("interest_pc.jsp?status=<font color=red>Some Internal Error/font>");
				rd.include(request, response);
			}
			
		}
		else if (len.length()>10 && len.length()<=20) 
		{
			b.setUid(uid);
			b.setIpaddress(host.getHostAddress().trim());
			b.setUrl(request.getRequestURI()+"?"+len);
			b.setPackets(str);
			b.setNpackets(str.length);
			b.setRouter("Router R2");
			b.setStatus("FLA");
			b.setStatus1("FLA");
			b.setAddress(len);
			 try {
				int i = new SecurityDAO().pcIntrest(b);
				if(i!=0) 
				{
					RequestDispatcher rd = request.getRequestDispatcher("interest_pc.jsp?status=<font color=red>FLA Detected Please Wait for Defence in Router</font>");
					rd.include(request, response);
				}
				else 
				{
					RequestDispatcher rd = request.getRequestDispatcher("interest_pc.jsp?status=<font color=red>Faild to Send</font>");
					rd.include(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				RequestDispatcher rd = request.getRequestDispatcher("interest_pc.jsp?status=<font color=red>Some Internal Error/font>");
				rd.include(request, response);
			}
		}
		else 
		{
			b.setUid(uid);
			b.setIpaddress(host.getHostAddress().trim());
			b.setUrl(request.getRequestURI()+"?"+len);
			b.setPackets(str);
			b.setNpackets(str.length);
			b.setRouter("Router R3");
			b.setStatus("in active");
			b.setStatus1("active");
			b.setAddress(len);
			 try {
				int i = new SecurityDAO().pcIntrest(b);
				if(i!=0) 
				{
					RequestDispatcher rd = request.getRequestDispatcher("interest_pc.jsp?status=<font color=red>Request Send to Router</font>");
					rd.include(request, response);
				}
				else 
				{
					RequestDispatcher rd = request.getRequestDispatcher("interest_pc.jsp?status=<font color=red>Faild to Send</font>");
					rd.include(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				RequestDispatcher rd = request.getRequestDispatcher("interest_pc.jsp?status=<font color=red>Some Internal Error/font>");
				rd.include(request, response);
			}
		}
	}
}