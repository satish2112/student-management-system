package Pojo;

public class RegistrationPojo {
private String username;
private String email;
private String password;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public RegistrationPojo(String username, String email, String password) {
	super();
	this.username = username;
	this.email = email;
	this.password = password;
}
public RegistrationPojo() {
	super();
}
@Override
public String toString() {
	return "Registrationpojo [username=" + username + ", email=" + email + ", password=" + password + "]";
}

}
