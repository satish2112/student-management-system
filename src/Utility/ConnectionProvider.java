package Utility;

import java.sql.*;

public class ConnectionProvider {

	
	public static Connection getconnection()
	{
		Connection con=null;
		try {
			
				//Load the Driver
				Class.forName("com.mysql.jdbc.Driver");
				
				//Creating a Connection
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BasicDB?autoReconnect=true&useSSL=false","root","root");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	
		
	}
}
