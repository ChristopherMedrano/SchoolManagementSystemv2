package CoreJava.Models;

public class Course {
	private int course_id;
	private String course_name;
	private double minimum_gpa;
	
	//overloaded constructors
	public Course() {
		this.course_id = 0;
		this.course_name = null;
		this.minimum_gpa = 0;
	}
	
	public Course(int id, String name, double gpa) {
		this.course_id = id;
		this.course_name = name;
		this.minimum_gpa = gpa;
	}
	
	//setters
	public void setID(int id) {
		this.course_id = id;
	}
	public void setCourseName(String name) {
		this.course_name = name;
	}
	public void setMinGpa(double gpa) {
		this.minimum_gpa = gpa;
	}
	
	//getters
	public int getID() {
		return this.course_id;
	}
	public String getCourseName() {
		return this.course_name;
	}
	public double getMinGpa() {
		return this.minimum_gpa;
	}
}
