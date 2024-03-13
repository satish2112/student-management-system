package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.TeacherDao;

import Pojo.SemesterPojo;
import Pojo.StudentPojo;
import Pojo.TeacherPojo;
import Utility.ConnectionProvider;

public class TeacherImp implements TeacherDao {

	public boolean addteacher(TeacherPojo p) {
		try {
			Connection con = ConnectionProvider.getconnection();
			String sql = "insert into teacherdata values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p.getId());
			pstmt.setString(2, p.getName());
			pstmt.setString(3, p.getGender());
			pstmt.setString(4, p.getEmail());
			pstmt.setString(5, p.getCoures());
			pstmt.setString(6, p.getPassword());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateteacher(TeacherPojo o) {
		try {
			Connection con = ConnectionProvider.getconnection();
			String sql = "update Teacherdata set name=?,gender=?,email=?,coures=?  where tid=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, o.getName());
			pstmt.setString(2, o.getGender());
			pstmt.setString(3, o.getEmail());
			pstmt.setString(4, o.getCoures());
			pstmt.setInt(5, o.getId());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteteacher(int tdelete) {
		try {
			Connection con = ConnectionProvider.getconnection();
			String sql = "delete from teacherdata where tid= ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, tdelete);
			if (pstmt.executeUpdate() == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	boolean f = false;

	public boolean Teacherlogin(String email, String password) {
		try {
			Connection con = ConnectionProvider.getconnection();
			String q = "Select * from teacherdata where email=? and password=?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, email);
			pstmt.setNString(2, password);
			ResultSet rs = pstmt.executeQuery();
			f = rs.next();
			if (f) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public TeacherPojo getTeacherdetails(String email) {
		String lSql = "SELECT * FROM teacherdata where email = ? ";
		try {
			Connection con = ConnectionProvider.getconnection();
			PreparedStatement ps = con.prepareStatement(lSql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				TeacherPojo po = new TeacherPojo();
				po.setName(rs.getString("name"));
				po.setId(rs.getInt("tid"));
				po.setEmail(rs.getString("email"));
				po.setCoures(rs.getString("coures"));
				po.setGender(rs.getString("gender"));
				return po;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean addStudenMarsk(SemesterPojo lSemesterPojo) {
		try {
			Connection con = ConnectionProvider.getconnection();
			String sql = "insert into Semesterdata values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, lSemesterPojo.getRollno());
			pstmt.setInt(2, lSemesterPojo.getSem());
			pstmt.setString(3, lSemesterPojo.getSubject());
			pstmt.setString(4, lSemesterPojo.getMarks());
			pstmt.setString(5, lSemesterPojo.getGrade());
			int i = pstmt.executeUpdate();
			if (i == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean updatSemMarks(SemesterPojo pSemesterPojo, String subject) {
		try {
			Connection con = ConnectionProvider.getconnection();
			String sql = "update Semesterdata set sem=?,subject=?,marks=?,grade=?  where rno=? and subject = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pSemesterPojo.getSem());
			pstmt.setString(2, pSemesterPojo.getSubject());
			pstmt.setString(3, pSemesterPojo.getMarks());
			pstmt.setString(4, pSemesterPojo.getGrade());
			pstmt.setInt(5, pSemesterPojo.getRollno());
			pstmt.setString(6, subject);
			int i = pstmt.executeUpdate();
			if (i == 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteSemMarks(int pRno,String subject) {
		try {
			Connection con = ConnectionProvider.getconnection();
			String sql = "delete from Semesterdata where rno= ? and subject=? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pRno);
			pstmt.setString(1, subject);
			int i = pstmt.executeUpdate();
			if (i == 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public SemesterPojo getSemMakrs(int rnum,String subject) {
		String lSql = "SELECT * FROM semesterdata where rno = ? and subject=? ";
		try {
			Connection con = ConnectionProvider.getconnection();
			PreparedStatement pstmt = con.prepareStatement(lSql);
			pstmt.setInt(1, rnum);
			pstmt.setString(2, subject);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				SemesterPojo spojo = new SemesterPojo();
				spojo.setSem(rs.getInt("sem"));
				spojo.setSubject(rs.getString("subject"));
				spojo.setMarks(rs.getString("marks"));
				spojo.setGrade(rs.getString("grade"));
				spojo.setRollno(rs.getInt("rno"));
				return spojo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public SemesterPojo searchBySubject(int rno, String Subject) {
		// TODO Auto-generated method stub
		SemesterPojo spojo = null;
		try {
			String sql = "select * from semesterdata where rno=? and subject=? ";
			Connection con = ConnectionProvider.getconnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, rno);
			ps.setString(2, Subject);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				spojo = new SemesterPojo();
				spojo.setRollno(rs.getInt(1));
				spojo.setSem(rs.getInt(2));
				spojo.setSubject(rs.getString(3));
				spojo.setMarks(rs.getString(4));
				spojo.setGrade(rs.getString(5));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return spojo;
	}

}
