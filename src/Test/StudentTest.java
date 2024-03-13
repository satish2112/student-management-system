package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DaoImpl.Loginlmp;
import DaoImpl.StudentImp;
import Pojo.RegistrationPojo;
import Pojo.SemesterPojo;
import Pojo.StudentPojo;

public class StudentTest {
	public static StudentPojo LogingUser;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentImp simpl = new StudentImp();
		boolean loop = true;
		Loginlmp limpl = new Loginlmp();
		System.out.println("--------->Student Login<---------");
		while (loop) {
			System.out.println("1.Login");
			System.out.println("2.LogOut");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:

				System.out.println("Enter Email:");
				String uname = sc.next();
				System.out.println("Enter Password:");
				String pass = sc.next();
				if (limpl.Userlogin(uname, pass)) {
					System.out.println("Login Successful");
					StudentPojo lStudentPojo = simpl.getstudentdetails(uname);
					LogingUser = lStudentPojo;
					System.out.println(lStudentPojo.toString());
//					while (loop) {
					System.out.println("1. Enter semester : ");
					int num = sc.nextInt();
					List<SemesterPojo> lSemesterPojoList = simpl.getSudentMarks(LogingUser.getRollno(), num);
					lSemesterPojoList.forEach((i) -> {
						System.out.println(i.toString());
						System.out.println();
					});
//						switch(num){
//							case 1:
//							
//						}				
//					}
				} else {
					System.out.println("something went wrong");
				}
				break;

			case 2:
				System.out.println("-----------<>" + LogingUser.getName() + " Logout Successfully" + "<>-----------");
				LogingUser = null;
				loop = false;
				break;
			}
		}
	}
}
