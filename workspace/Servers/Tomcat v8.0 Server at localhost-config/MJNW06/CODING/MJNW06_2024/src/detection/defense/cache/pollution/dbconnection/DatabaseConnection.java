package detection.defense.cache.pollution.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public Connection getConnection(){
		Connection con=null;
        try{
        	Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/cache";
            con=DriverManager.getConnection(url,"root","root");
            System.out.println("Data base---->"+con);
        }catch(Exception e)
         {
             e.printStackTrace();
         }
        return con;
    }
}
