package detection.defense.cache.pollution.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import detection.defense.cache.pollution.Bean.Bean;
import detection.defense.cache.pollution.dbconnection.DatabaseConnection;

public class ViewDAO extends DatabaseConnection {
	Connection con = null;
	ArrayList<Bean> al = new ArrayList<Bean>();
	PreparedStatement ps = null;
	ResultSet rs = null;
	public ViewDAO() {
		con = getConnection();
	}
	public ArrayList<Bean> routerViewNewPCRequest()throws Exception
	{
		ps = con.prepareStatement("select uid,uname,email,mobile,ipaddress,address from userdetails where status='in active'");
		rs = ps.executeQuery();
		while (rs.next()) {
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setUname(rs.getString(2));
			b.setEmail(rs.getString(3));
			b.setMobile(rs.getString(4));
			b.setIpaddress(rs.getString(5));
			b.setAddress(rs.getString(6));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> routerViewAcceptedPC()throws Exception
	{
		ps = con.prepareStatement("select uid,uname,email,mobile,ipaddress,address from userdetails where status='active'");
		rs = ps.executeQuery();
		while (rs.next()) {
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setUname(rs.getString(2));
			b.setEmail(rs.getString(3));
			b.setMobile(rs.getString(4));
			b.setIpaddress(rs.getString(5));
			b.setAddress(rs.getString(6));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> pcViewNewContent(int uid)throws Exception {
		ps = con.prepareStatement("select fid,ipaddress,url,npackets,router,status,data from interest where pcid=?");
		ps.setInt(1, uid);
		rs = ps.executeQuery();
		while (rs.next()) {
			Bean b = new Bean();
			b.setFid(rs.getInt(1));
			b.setIpaddress(rs.getString(2));
			b.setUrl(rs.getString(3));
			b.setNpackets(rs.getInt(4));
			b.setRouter(rs.getString(5));
			b.setStatus(rs.getString(6));
			b.setAddress(rs.getString(7));
			al.add(b);
		}
		return al;
	} 
	public ArrayList<Bean> routerViewIntrestRequest()throws Exception {
		ps = con.prepareStatement("select fid,ipaddress,url,npackets,router,time,pcid from interest where status='in active'");
		rs = ps.executeQuery();
		while (rs.next()) {
			Bean b = new Bean();
			b.setFid(rs.getInt(1));
			b.setIpaddress(rs.getString(2));
			b.setUrl(rs.getString(3));
			b.setNpackets(rs.getInt(4));
			b.setRouter(rs.getString(5));
			b.setAddress(rs.getString(6));
			b.setUid(rs.getInt(7));
			al.add(b);
		}
		return al;
	} 
	public ArrayList<Bean> routerViewFLA()throws Exception {
		ps = con.prepareStatement("select fid,ipaddress,url,npackets,router,time,pcid from interest where status='FLA'");
		rs = ps.executeQuery();
		while (rs.next()) {
			Bean b = new Bean();
			b.setFid(rs.getInt(1));
			b.setIpaddress(rs.getString(2));
			b.setUrl(rs.getString(3));
			b.setNpackets(rs.getInt(4));
			b.setRouter(rs.getString(5));
			b.setAddress(rs.getString(6));
			b.setUid(rs.getInt(7));
			al.add(b);
		}
		return al;
	} 
	public ArrayList<Bean> routerViewNoDetection()throws Exception {
		int i = 0;
		int j = 0;
		ps = con.prepareStatement("SELECT COUNT(status1) FROM interest WHERE status1='FLA'");
		rs = ps.executeQuery();
		if (rs.next()) {
			i = rs.getInt(1);
		}
		
		ps = con.prepareStatement("SELECT COUNT(status) FROM interest WHERE status='Recovered'");
		rs = ps.executeQuery();
		if (rs.next()) {
			j = rs.getInt(1);
		}
		
		Bean b = new Bean();
		b.setUid(i);
		b.setFid(j);
		al.add(b);
		return al;
	}
}