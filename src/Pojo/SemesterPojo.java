package Pojo;

public class SemesterPojo {
	private int rollno;
	private int sem;
	private String subject;
	private String marks ;
	private String grade;
	
	public SemesterPojo(int rollno, int sem, String subject, String marks, String grade) {
		super();
		this.rollno = rollno;
		this.sem = sem;
		this.subject = subject;
		this.marks = marks;
		this.grade = grade;
	}
	public SemesterPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return " [rollno=" + rollno + ", sem=" + sem + ", subject=" + subject + ", marks=" + marks
				+ ", grade=" + grade + "]";
	}	

}
