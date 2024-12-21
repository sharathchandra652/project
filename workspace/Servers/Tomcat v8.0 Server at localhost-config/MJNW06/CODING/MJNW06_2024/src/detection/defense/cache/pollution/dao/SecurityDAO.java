package detection.defense.cache.pollution.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import detection.defense.cache.pollution.Bean.Bean;
import detection.defense.cache.pollution.dbconnection.DatabaseConnection;

public class SecurityDAO extends DatabaseConnection {
	Connection con = null;
	ArrayList<Bean> al = new ArrayList<Bean>();
	PreparedStatement ps = null;
	int i = 0;
	ResultSet rs = null;
	public SecurityDAO() {
		con = getConnection();
	}
	
	public int reg(Bean b)throws Exception {
		ps = con.prepareStatement("insert into userdetails(uname,email,password,mobile,address,ipaddress,status)values(?,?,?,?,?,?,'in active')");
		ps.setString(1, b.getUname());
		ps.setString(2, b.getEmail());
		ps.setString(3, b.getPassword());
		ps.setString(4, b.getMobile());
		ps.setString(5, b.getAddress());
		ps.setString(6, b.getIpaddress());
		i = ps.executeUpdate();
		return i;
	}
	
	public int routerAcceptNewPC(int uid)throws Exception {
		ps = con.prepareStatement("update userdetails set status='active' where uid=?");
		ps.setInt(1, uid);
		i = ps.executeUpdate();
		return i;
	}
	
	public ArrayList<Bean> pcLogin(String email,String pasword)throws Exception {
		ps = con.prepareStatement("select uid,uname,email from userdetails where email=? and password=? and status='active'");
		ps.setString(1, email);
		ps.setString(2, pasword);
		rs = ps.executeQuery();
		while (rs.next()) {
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setUname(rs.getString(2));
			b.setEmail(rs.getString(3));
			al.add(b);
		}
		return al;
	}
	public int pcIntrest(Bean b)throws Exception {
		ps = con.prepareStatement("insert into interest(pcid,ipaddress,url,packets,npackets,router,status,status1,data)values(?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, b.getUid());
		ps.setString(2, b.getIpaddress());
		ps.setString(3, b.getUrl());
		ps.setString(4, b.getPackets().toString());
		ps.setInt(5, b.getNpackets());
		ps.setString(6, b.getRouter());
		ps.setString(7, b.getStatus());
		ps.setString(8, b.getStatus1());
		ps.setString(9, b.getAddress());
		i = ps.executeUpdate();
		return i;
	}
	
	public int routerAcceptInterest(int fid)throws Exception {
		ps = con.prepareStatement("update interest set status='active' where fid=?");
		ps.setInt(1, fid);
		i = ps.executeUpdate();
		return i;
	}
	
	public int routerDefence(int fid)throws Exception {
		ps = con.prepareStatement("update interest set status='Recovered' where fid=?");
		ps.setInt(1, fid);
		i = ps.executeUpdate();
		return i;
	}
}