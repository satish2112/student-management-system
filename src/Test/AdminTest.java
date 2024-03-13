package Test;

import java.util.*;

import Dao.TeacherDao;
import DaoImpl.Loginlmp;
import DaoImpl.StudentImp;
import DaoImpl.TeacherImp;
import Pojo.StudentPojo;
import Pojo.TeacherPojo;

public class AdminTest {

	public static void main(String[] args) {
		System.out.println("------------>Admin<-------------");
		admin();
	}
		public static void admin() {
			Scanner sc=new Scanner(System.in);
			Loginlmp l=new Loginlmp();
			StudentImp simp=new StudentImp();
			TeacherImp timp=new TeacherImp();
			System.out.println("1.AdminLogIn");
			while(true) {
	//			System.out.println("1.AdminLogIn");
				int choice=sc.nextInt();
				switch(choice) {
				case 1:
					 System.out.println("Enter Email ID:");
					 String email=sc.next();
					 String reg="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
						boolean f=email.matches(reg);
						if(!f) {
						System.out.println("Email is not valid");
						break;
						}
					 System.out.println("Enter Password:");
					 String password=sc.next();
					 if(l.AdminLogin(email, password)) {
						 System.out.println("---------------Login successfully-----------------");
						 while(true) {
							 System.out.println("1.Add Student");
							 System.out.println("2.Update Student");
							 System.out.println("3.Delete Student");
							 System.out.println("4.Add Teacher");
							 System.out.println("5.Update Teacher");
							 System.out.println("6.Delete Teacher");
							
							 
							 int num=sc.nextInt();
							 switch(num) {
							 case 1:
								 System.out.println("Enter Student Rollno:");
								 int rollno=sc.nextInt();
								 sc.nextLine();
								 System.out.println("Enter Student Name:");
								 String name=sc.nextLine();
								 
								 System.out.println("Enter Student Email:");
								 String email1=sc.nextLine();
								 
								 System.out.println("Enter Student Password:");
								 String passw=sc.nextLine();
								 
								 System.out.println("Enter Student Address:");
								 String  address=sc.nextLine();
								 
								 System.out.println("Enter Student Gender:");
								 String gender=sc.nextLine();
	
								 System.out.println("Enter Student Contactno:");
								 int contact=sc.nextInt();
								 sc.nextLine();
								 
								 System.out.println("Enter Student Brach:");
								 String branch=sc.nextLine();
								 
								StudentPojo s=new StudentPojo(rollno, name, email1,passw, address, gender, contact, branch);
							
								if(simp.addstudent(s)) {
									System.out.println("------------->Student Added Successfully<---------------");
								}
								else {
									System.out.println("---------------->Student Not Added<---------------");
								}
	///							 System.out.println("<----------------------------------->");
								 break;
								 
							 case 2:
								 System.out.println("Enter Existing Rollno:");
								 int rnew=sc.nextInt();
								 StudentPojo lStudentpojo= simp.getstudentdetails(rnew);
								 if(lStudentpojo==null) {
									 System.out.println("------->This Rollno Not Present<-------");
	//								 System.out.println();
									 break;
								 }
								 else {
									 System.out.println(lStudentpojo.toString());
								}
								 sc.nextLine();
								 System.out.println("Enter Updated Name:");
								 String nnew=sc.nextLine();
								 
								 System.out.println("Enter updated Email:");
								 String enew=sc.nextLine();
								
								 System.out.println("Enter Updated Address:");
								 String anew=sc.nextLine();
								 
								 System.out.println("Enter Updated Gender:");
								 String gnew=sc.nextLine();
								 
								 System.out.println("Enter Updated Contactno:");
								 int cnew=sc.nextInt();
								 
								 sc.nextLine();
								 System.out.println("Enter Updated Branch:");
								 String bnew=sc.nextLine();
								 
								 StudentPojo s1=new StudentPojo(rnew, nnew,"", enew,anew, gnew, cnew, bnew);
								 
								 boolean b=simp.updatestudent(s1);
								 if(b) {
									 System.out.println("<---------------Updated Successfully---------------->");
								 }
								 else {
									 System.out.println("No rows were updated---------------->");
									 }
								 break;
							
							 case 3:
								 System.out.println("Enter Rollno You Want To Delete:");
								 int rdelete=sc.nextInt();
								 lStudentpojo= simp.getstudentdetails(rdelete);
								 if(lStudentpojo==null) {
									 System.out.println("------->This Rollno Not Present<-------");
	//								 System.out.println();
									 break;
								 }
								 else {
									 System.out.println(lStudentpojo.toString());
									 System.out.println("------------<>Student Deleted Successfully<>------------");
								}
								 simp.deletestudent(rdelete);
								break;
								
							 case 4:
								 System.out.println("Enter Teacher Id:");
								 int tid=sc.nextInt();
								 sc.nextLine();
								 
								 System.out.println("Enter Teacher Name:");
								 String tname=sc.nextLine();
								 
								 System.out.println("Enter Teacher Gender:");
								 String tgender=sc.nextLine();
								 
								 System.out.println("Enter Teacher Email:");
								 String temail=sc.nextLine();
								 
								 System.out.println("Enter Teacher coures:");
								 String tcoures=sc.nextLine();

								 System.out.println("Enter Teacher Password:");
								 String tpassword=sc.nextLine();
								 
								 TeacherPojo p=new TeacherPojo(tid, tname, tgender, temail, tcoures,tpassword);
								 boolean a=timp.addteacher(p);
								 if(a) {
									 System.out.println("------------->Teacher Added Successfully<--------------->");
								 }
								 else {
									 System.out.println("------------->Teacher Details Not Added<--------------->");
								 }
								 break;
							 case 5:
								 System.out.println("Enter Existing Teacher Id You Want To Update:");
								 int uid=sc.nextInt();
								 sc.nextLine();
								 
								 System.out.println("Enter Teacher Name:");
								 String uname=sc.nextLine();
								 
								 System.out.println("Enter Teacher Gender:");
								 String ugender=sc.nextLine();
								 
								 System.out.println("Enter Teacher Email:");
								 String uemail=sc.nextLine();
								 
								 System.out.println("Enter Teacher coures:");
								 String ucoures=sc.nextLine();
								 
								 TeacherPojo o=new TeacherPojo(uid, uname, ugender, uemail, ucoures,"");
								 if(timp.updateteacher(o)) {
									 System.out.println("------------>Updated Successfully<-------------");
								 }
								 else {
									 System.out.println("------------->No rows were updated<--------------");
								 }
								 break;
							 case 6:
								 System.out.println("Enter T_id You Want To Delete:");
								 int tdelete=sc.nextInt();
								 if(timp.deleteteacher(tdelete)) {
									 System.out.println("-------------->Delete Successfully<---------------");
								 }
								 else {
									 System.out.println("---------------->No rows were Delete1<----------------");
								 }
								 break;
							 }
						 }
					 }
					 else {
						 System.out.println("Email/Password Invalid!");
					 }
					break;
				}
			}
		}
}
