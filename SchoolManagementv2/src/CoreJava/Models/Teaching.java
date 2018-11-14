package CoreJava.Models;

public class Teaching {
	private String course_name;
	private double minimum_gpa;
	private String full_name;
	private String email;
	
	//overloaded constructors
	public Teaching() {
		this.course_name = null;
		this.minimum_gpa = 0;
		this.full_name = null;
		this.email = null;
	}
	
	public Teaching(String cName, double gpa, String fName, String email) {
		this.course_name = cName;
		this.minimum_gpa = gpa;
		this.full_name = fName;
		this.email = email;
	}
	
	
	//setters
	public void setCourseName(String name) {
		this.course_name = name;
	}
	public void setMinGpa(double gpa) {
		this.minimum_gpa = gpa;
	}
	public void setName(String name) {
		this.full_name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//getters
	public String getCourseName() {
		return this.course_name;
	}
	public double getMinGpa() {
		return this.minimum_gpa;
	}
	public String getName() {
		return this.full_name;
	}
	public String getEmail() {
		return this.email;
	}
}
