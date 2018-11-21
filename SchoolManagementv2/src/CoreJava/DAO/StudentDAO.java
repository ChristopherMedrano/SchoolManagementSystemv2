package CoreJava.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CoreJava.Models.Student;
import CoreJava.SystemInterfaces.StudentDAOI;

/**
 * This Data Access Object maps queries for the Student table to the database.
 * The Student table represents the students. 
 * 
 * Implements the StudentDAOI interface
 * 
 * @author Chris Medrano
 *
 */
public class StudentDAO implements StudentDAOI {
	OracleConnection oc = new OracleConnection();
	
	protected Connection conn = null;
	protected Statement st = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	
	public void dispose() {
		try {
			if(!rs.equals(null)) {
				if(!rs.isClosed()) rs.close();
			}
			if(!ps.equals(null)) {
				if(!ps.isClosed()) ps.close();
			}
			if(!conn.equals(null)) {
				if(!conn.isClosed()) conn.close();
			}
		}catch(SQLException e) {
			System.out.println(e);
		}catch(NullPointerException e) {
			
		}
	}
	
	/**
	 * 
	 * Overrides StudentDAOI interface method
	 * This method queries the database for a student using their email address
	 * 
	 * @param	email		email address of the student
	 * @return 	student 	the student that matches the queried email address 
	 * 
	 */
	@Override
	public Student getStudentByGmail(String email) {
		Student student = new Student();
		String query = "SELECT * FROM student WHERE email = ?";
		
		try {
			conn = oc.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			this.dispose();
		}
		
		return student;
	}

	/**
	 * 
	 * Compares the entered password to the password from the student object to validate the user.
	 * 
	 * @param 	passToValidate		the password from student object
	 * @param 	comparablePas		the password entered by user
	 * @return	validation			boolean result if student is validated
	 * 
	 */
	public boolean validateUser(String passToValidate, String comparablePas) {

		boolean validation = (passToValidate.equals(comparablePas) ? true : false);

		return validation;
	}

}
