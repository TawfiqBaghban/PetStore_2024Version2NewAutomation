package api.payload;

public class User {
	
/*		Creating variables according to swagger, then we create getters and setters methods for these variables.
 		Getter and Setter in Java are methods used to access and set the values of an object's attributes.
 		Now we have to refer to this POJO class in the EndPoints classes.
*/
	int id;
	String username;
	String firstname;
	String lastname;
	String email;
	String password;
	String phone;
	int userStatus=0;
	
	public int getId() {			//	this will return the value of variable.
		return id;
	}
	public void setId(int id) {		//	takes one parameter and assign it to variable.
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	
	
	

}
