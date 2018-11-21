package CoreJava.Models;

/**
 * 
 * Student class for Student object holds:
 * student_id
 * full_name
 * email
 * gpa
 * pass
 * student_role
 * 
 * @author Chris Medrano
 *
 */
public class Student {
	private int student_id;
	private String full_name;
	private String email;
	private double gpa;
	private String pass;
	private int student_role;
	
	/**
	 * This is a constructor for the student class
	 * Accepts no parameters, initializes variables to null or 0
	 * 
	 */
	public Student() {
		student_id = 0;
		full_name = null;
		email = null;
		gpa = 0;
		pass = null;
		student_role = 0;
	}
	
	/**
	 * 
	 * Class overloaded constructor for the Student 
	 * @param id	Unique Database identifier
	 * @param name	The full name of the student
	 * @param email	Student’s current school email	
	 * @param gpa	Student’s current GPA
	 * @param pass	Student’s password in order to login
	 * @param role	Defines the role of a student. Separates any students from being an instructor. 
	 * 				This field always takes a value of -1
	 * 
	 */
	public Student(int id, String name, String email, double gpa, String pass, int role) {
		this.student_id = id;
		this.full_name = name;
		this.email = email;
		this.gpa = gpa;
		this.pass = pass;
		this.student_role = role;
	}
	
	/*
	 * Setters 
	 */
	/**
	 * Sets student id
	 * @param id
	 */
	public void setID(int id) {
		this.student_id = id;
	}
	
	/**
	 * Sets student full name
	 * @param name
	 */
	public void setName(String name) {
		this.full_name = name;
	}
	
	/**
	 * Sets student email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Sets student GPA
	 * @param gpa
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	/**
	 * Sets student password
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/**
	 * Sets int student role 
	 * @param role
	 */
	public void setRole(int role) {
		this.student_role = role;
	}
	
	/*
	 * Getters
	 */
	
	/**
	 * Returns int student id
	 * @return
	 */
	public int getID() {
		return this.student_id;
	}
	
	/**
	 * Returns String student full name
	 * @return
	 */
	public String getName() {
		return this.full_name;
	}
	
	/**
	 * Returns String student email
	 * @return
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Returns Double student gpa
	 * @return
	 */
	public double getGpa() {
		return this.gpa;
	}
	
	/**
	 * Returns String student password
	 * @return
	 */
	public String getPass() {
		return this.pass;
	}
	
	/**
	 * Returns int student role
	 * @return
	 */
	public int getRole() {
		return this.student_role;
	}
}
