package Dao;

import Pojo.RegistrationPojo;
import Pojo.StudentPojo;

public interface StudentDao {
	boolean addstudent(StudentPojo s);
	boolean updatestudent(StudentPojo s);
	boolean deletestudent(int rdelete);
	StudentPojo getstudentdetails(int rnumber );
	StudentPojo getstudentdetails(String email);
}
