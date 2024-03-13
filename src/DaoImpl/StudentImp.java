package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.StudentDao;
import Pojo.RegistrationPojo;
import Pojo.SemesterPojo;
import Pojo.StudentPojo;
import Utility.ConnectionProvider;

public class StudentImp implements StudentDao {
Connection con=ConnectionProvider.getconnection();
PreparedStatement ps;
int i;
	@Override
	public boolean addstudent(StudentPojo s) {
		try {
			String sql="insert into studentdata values(?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1, s.getRollno());
			ps.setString(2, s.getName());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getAddress());
			ps.setString(5, s.getGender());
			ps.setInt(6, s.getContactno());
			ps.setString(7, s.getBranch());
			ps.setString(8, s.getPassword());
			i=ps.executeUpdate();
			if(i>0) {
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
	public boolean updatestudent(StudentPojo s1) {
		try {
			String sql="update studentdata set name=?, email=?, address=?,gender=?,cno=?,bname=? where rno=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,s1.getName());
			ps.setString(2,s1.getEmail());
			ps.setString(3,s1.getAddress());
			ps.setString(4,s1.getGender());
			ps.setInt(5,s1.getContactno());
			ps.setString(6,s1.getBranch());
			ps.setInt(7,s1.getRollno());

			i=ps.executeUpdate();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deletestudent(int rdelete) {
		try {
			String sql="delete from studentdata where rno= ?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, rdelete);
			ps.executeUpdate();
			return true;
//			System.out.println(i);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public StudentPojo getstudentdetails(int rnumber) {
		String lSql="SELECT * FROM studentdata where rno = ? ";
		try {
			ps=con.prepareStatement(lSql);
			ps.setInt(1, rnumber);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				StudentPojo lStudentpojo =new StudentPojo();
				lStudentpojo.setName(rs.getString("name"));
				lStudentpojo.setEmail(rs.getString("email"));
				lStudentpojo.setAddress(rs.getString("address"));
				lStudentpojo.setBranch(rs.getString("bname"));
				lStudentpojo.setRollno(rs.getInt("rno"));
				lStudentpojo.setContactno(rs.getInt("cno"));
				lStudentpojo.setGender(rs.getString("gender"));
				return lStudentpojo;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

	@Override
	public StudentPojo getstudentdetails(String email) {
		String lSql="SELECT * FROM studentdata where email = ? ";
		try {
			ps=con.prepareStatement(lSql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				StudentPojo lStudentpojo =new StudentPojo();
				lStudentpojo.setName(rs.getString("name"));
				lStudentpojo.setEmail(rs.getString("email"));
				lStudentpojo.setAddress(rs.getString("address"));
				lStudentpojo.setBranch(rs.getString("bname"));
				lStudentpojo.setRollno(rs.getInt("rno"));
				lStudentpojo.setContactno(rs.getInt("cno"));
				lStudentpojo.setGender(rs.getString("gender"));
				return lStudentpojo;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<SemesterPojo> getSudentMarks(int rno,int sem) {
		String lSql="SELECT * FROM semesterdata where rno = ? and sem =? ";
		List<SemesterPojo> lSemesterPojoList=new ArrayList<SemesterPojo>();
		try {
			ps=con.prepareStatement(lSql);
			ps.setInt(1, rno);
			ps.setInt(2, sem);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SemesterPojo lSemesterPojo =new SemesterPojo();
				lSemesterPojo.setRollno(rs.getInt(1));
				lSemesterPojo.setSem(rs.getInt(2));
				lSemesterPojo.setSubject(rs.getString(3));
				lSemesterPojo.setMarks(rs.getString(4));
				lSemesterPojo.setGrade(rs.getString(5));
				lSemesterPojoList.add(lSemesterPojo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lSemesterPojoList;
	}

}
