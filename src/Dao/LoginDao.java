package Dao;

public interface LoginDao {
	boolean Userlogin(String uname,String password);
	boolean Userchangepassword(String name,String pass);
	boolean AdminLogin(String email,String password);
	boolean Adminchangepassword(String oldpass,String newpass);
	
}
