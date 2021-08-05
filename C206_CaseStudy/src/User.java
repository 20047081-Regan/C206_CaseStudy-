/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: A. Elizabeth
 * Student ID: 20020036
 * Class: W67L
 * Date/Time Last modified: ${currentDate:date('EEEE dd-MM-yyyy HH:mm')}
 */
public class User {
	
	private String name;
	private String email;
	private String password;	
	private String role;
	
	public User(String name, String email, String password, String role) {
		this.name = name;
		this.email = email;
		this.password = password;		
		this.role = role;
	}
	public User(String name, String password,String role) // edited by zane
	{
		this.name = name;
		this.password = password;
		this.role = role;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}

