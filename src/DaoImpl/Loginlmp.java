package DaoImpl;

import java.sql.*;

import Dao.LoginDao;
import Utility.ConnectionProvider;

public class Loginlmp implements LoginDao {
	
	@Override
	public boolean Userlogin(String uname,String password) {
		boolean f=false;
		try {
			//use getConnection method 
			Connection con=ConnectionProvider.getconnection();
			
			//Create a query
			String q="Select * from studentdata where email=? and password=?";
			
			//Create a Statement
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setString(1,uname);
			pstmt.setString(2,password);
			ResultSet rs=pstmt.executeQuery();
			f=rs.next();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean Userchangepassword(String name, String pass) {
		// TODO Auto-generated method stub
		try {
			//use getConnection method 
			Connection con=ConnectionProvider.getconnection();
			
			//Create a query
			String q="update student set Spassword=? where Sname=?";
			
			//Create a Statement
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setString(1,name);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return false;
	}

	@Override
	public boolean AdminLogin(String email,String password) {
		
		try {
		Connection con=ConnectionProvider.getconnection();
		String q="select * from admin Where email=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(q);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			return true;
			}
		else {
			return false;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean Adminchangepassword(String oldpass, String newpass) {
		// TODO Auto-generated method stub
		return false;
	}
}
