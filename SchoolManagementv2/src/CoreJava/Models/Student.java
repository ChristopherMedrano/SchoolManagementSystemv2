package CoreJava.Models;

public class Student {
	private int student_id;
	private String full_name;
	private String email;
	private double gpa;
	private String pass;
	private int student_role;
	
	//overloaded constructors
	public Student() {
		student_id = 0;
		full_name = null;
		email = null;
		gpa = 0;
		pass = null;
		student_role = 0;
	}
	
	public Student(int id, String name, String email, double gpa, String pass, int role) {
		this.student_id = id;
		this.full_name = name;
		this.email = email;
		this.gpa = gpa;
		this.pass = pass;
		this.student_role = role;
	}
	
	//setters
	public void setID(int id) {
		this.student_id = id;
	}
	public void setName(String name) {
		this.full_name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setRole(int role) {
		this.student_role = role;
	}
	
	//getters
	public int getID() {
		return this.student_id;
	}
	public String getName() {
		return this.full_name;
	}
	public String getEmail() {
		return this.email;
	}
	public double getGpa() {
		return this.gpa;
	}
	public String getPass() {
		return this.pass;
	}
	public int getRole() {
		return this.student_role;
	}
}
