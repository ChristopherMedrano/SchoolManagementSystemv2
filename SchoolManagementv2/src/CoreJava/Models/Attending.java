package CoreJava.Models;

public class Attending {
	private String course_name;
	private String full_name;
	private String email;
	
	//setters
	public void setCourseName(String name) {
		this.course_name = name;
	}
	public void setFullName(String name) {
		this.full_name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//getters
	public String getCourseName() {
		return this.course_name;
	}
	public String getFullName() {
		return this.full_name;
	}
	public String getEmail() {
		return this.email;
	}
	
	//overloaded constructors
	public Attending() {
		this.course_name = null;
		this.full_name = null;
		this.email = null;
	}
	
	public Attending(String courseName, String fullName, String email) {
		this.course_name = courseName;
		this.full_name = fullName;
		this.email = email;
	}
	
}
