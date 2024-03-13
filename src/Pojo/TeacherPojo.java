package Pojo;

public class TeacherPojo {
	private int id;
	private String name;
	private String gender;
	private String email;
	private String coures;
	private String Password;
	
	public TeacherPojo(int id, String name, String gender, String email, String coures, String password) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.coures = coures;
		Password = password;
	}
	
	public TeacherPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCoures() {
		return coures;
	}
	public void setCoures(String coures) {
		this.coures = coures;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String toString() {
		return "TeacherPojo [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", coures="
				+ coures + ", Password=" + Password + "]";
	}
	
}
