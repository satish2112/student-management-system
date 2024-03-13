package Pojo;

public class StudentPojo {
	private int rollno;
	private String name;
	private String email;
	private String address ;
	private String gender;
	private int contactno;
	private String branch;
	private String password;

	public StudentPojo(int rollno, String name, String email,String password, String address, String gender, int contactno,
			String branch) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.contactno = contactno;
		this.branch = branch;
		this.password=password;
	}
	public StudentPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getContactno() {
		return contactno;
	}

	public void setContactno(int contactno) {
		this.contactno = contactno;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "StudentPojo [rollno=" + rollno + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", gender=" + gender + ", contactno=" + contactno + ", branch=" + branch + ", password=" + password
				+ "]";
	}

}
