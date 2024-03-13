package Test;

import java.util.Scanner;

import DaoImpl.TeacherImp;
import Pojo.StudentPojo;
import Pojo.TeacherPojo;
import Pojo.SemesterPojo;

public class TeacherTest {
	public static TeacherPojo LogingUser;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TeacherImp timp = new TeacherImp();

		boolean loop = true;
		System.out.println("--------->Teacher Login<---------");
		while (true) {
			System.out.println("1.Login");
//			System.out.println("2.LogOut");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Email:");
				String uname = sc.next();
				System.out.println("Enter Password:");
				String pass = sc.next();
				if (timp.Teacherlogin(uname, pass)) {
					LogingUser = timp.getTeacherdetails(uname);
					System.out.println("----------->"+LogingUser.getName()+" Login Successful"+"<-------------");
					 while(loop) {
						 System.out.println("1.Add Student Sem Marks");
						 System.out.println("2.Update Student Sem Marks");
						 System.out.println("3.Delete Student Sem Marks");
						 System.out.println("4.Search Student Sem Wise Marks");
						 System.out.println("5.LogOut");
						 int num=sc.nextInt();
						 switch(num) {
						 case 1:
							 System.out.println("Enter Student Rollno:");
							 int lRollno=sc.nextInt();
							 
							 System.out.println("Enter Student lSem:");
							 int lSem=sc.nextInt();
							 sc.nextLine();
							 
							 System.out.println("Enter subject:");
							 String lSubject=sc.nextLine();
							 
							 System.out.println("Enter Student marks:");
							 String lMarks=sc.nextLine();
							 
							 System.out.println("Enter Student grade:");
							 String  lGrade=sc.nextLine();
							 
							 
							 SemesterPojo lSemesterdata=new SemesterPojo(lRollno, lSem, lSubject, lMarks, lGrade);
						
							if(timp.addStudenMarsk(lSemesterdata)) {
								System.out.println("------------->Student Marks Added Successfully<---------------");
							}
							else {
								System.out.println("---------------->Student Marks Not Added<---------------");
							}
///							 System.out.println("<----------------------------------->");
							 break;
							
						 case 2:
							 System.out.println("Enter Existing Rollno:");
							 int urno=sc.nextInt();
							 SemesterPojo spojo;
							 spojo =timp.getSemMakrs(urno,LogingUser.getCoures());
							 if(spojo==null) {
								 System.out.println("------->This Rollno Not Present<-------");
								 break;
							 }
							 else {
								 System.out.println(spojo.toString());
							}
							 sc.nextLine();
							 System.out.println("Enter Updated Sem:");
							 int usem=sc.nextInt();
							 sc.nextLine();

							 System.out.println("Enter Updated subject:");
							 String usubject=sc.nextLine();
							 
							 System.out.println("Enter Updated Marks:");
							 String umarks=sc.nextLine();
							 
							 System.out.println("Enter Updated Grade:");
							 String ugrade=sc.nextLine();
							 SemesterPojo poj=new SemesterPojo(urno, usem, LogingUser.getCoures(), umarks, ugrade);
							boolean a=timp.updatSemMarks(poj,LogingUser.getCoures());
							if(a) {
								System.out.println("---------------->Marks Updated Successfully<-----------------");
							}
							else {
								System.out.println("------------>Marks Not Updated<------------");
							}
							break;
						 case 3:
								System.out.println("Enter Rollno You Want To Delete:");
								 int rdelete=sc.nextInt();
								 SemesterPojo pojo;
								 pojo =timp.getSemMakrs(rdelete,LogingUser.getCoures());
								 if(pojo==null) {
									 System.out.println("------->This Rollno Not Present<-------");
									 break;
								 }
								 else {
									 System.out.println(pojo.toString());
								}
								 timp.deleteSemMarks(rdelete,LogingUser.getCoures());
								break;
						case 4:
							System.out.println("Enter rollno : ");
							int rno=sc.nextInt();
							SemesterPojo t=timp.searchBySubject(rno,LogingUser.getCoures());
							if(t!=null)
							{
								System.out.println(t.toString());
							}
						else
							{
							System.out.println("Enter Subject is not available");
							}
							break;
						case 5:
								System.out.println("------>"+LogingUser.getName()+" Logout Successfully"+"<------");
								LogingUser=null;
								loop=false;
								break;
						 }
					 }
					
				} else {
					System.out.println("Something Went Wrong");
				}
				break;
			}
		}
	}

}

