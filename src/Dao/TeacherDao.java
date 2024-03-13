package Dao;

import Pojo.TeacherPojo;

public interface TeacherDao {
	boolean addteacher(TeacherPojo p);
	boolean updateteacher(TeacherPojo o);
	boolean deleteteacher(int tdelete);
	boolean Teacherlogin(String email, String password);
	TeacherPojo getTeacherdetails(String email);
	
}
