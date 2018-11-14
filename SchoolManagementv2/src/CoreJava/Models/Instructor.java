package CoreJava.Models;

public class Instructor {
	private int instructor_id;
	private String full_name;
	private String email;
	private String speciality;
	private int admin_role;
	private String pass;
	
	//overloaded constructors
	public Instructor() {
		instructor_id = 0;
		full_name = null;
		email = null;
		speciality = null;
		admin_role = 0;
		pass = null;
	}
	
	public Instructor(int id, String name, String email, String speciality, int role, String pass) {
		this.instructor_id = id;
		this.full_name = name;
		this.email = email;
		this.speciality = speciality;
		this.admin_role = role;
		this.pass = pass;
	}
	
	//setters
	public void setID(int id) {
		this.instructor_id = id;
	}
	public void setName(String name) {
		this.full_name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public void setAdminRole(int role) {
		this.admin_role = role;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	//getters
	public int getID() {
		return this.instructor_id;
	}
	public String getName() {
		return this.full_name;
	}
	public String getEmail() {
		return this.email;
	}
	public String getSpeciality() {
		return this.speciality;
	}
	public int getAdminRole() {
		return this.admin_role;
	}
	public String getPass() {
		return this.pass;
	}
}
