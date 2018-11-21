package CoreJava.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import CoreJava.Models.Instructor;
import CoreJava.Models.Student;
import CoreJava.SystemInterfaces.InstructorDAOI;

/**
 * This Data Access Object maps queries for the Instructor table to the database.
 * The Instructor table represents the instructors for courses. 
 * 
 * Implements the InstructorDAOI interface
 * 
 * @author Chris Medrano
 *
 */
public class InstructorDAO implements InstructorDAOI {
	
	/*
	 * These objects are used to connect and query the database 
	 */
	protected Connection conn = null;
	protected Statement st = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	/**
	 * 
	 * This method looks for open connections to the database. 
	 * Any open connections are closed.
	 * 
	 * @param 	none
	 * @return 	none
	 *  
	 */
	public void dispose() {
		try {
			if (!rs.equals(null)) {
				if (!rs.isClosed())
					rs.close();
			}
			if (!ps.equals(null)) {
				if (!ps.isClosed())
					ps.close();
			}
			if (!conn.equals(null)) {
				if (!conn.isClosed())
					conn.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (NullPointerException e) {
			//ignore
		}
	}

	/**
	 * 
	 * Overrides InstructorDAOI interface method
	 * This method queries the Instructor table in the database
	 * Selects all rows from Instructor table
	 * 
	 * @return instructorList	an array list of instructors
	 * 
	 */
	@Override
	public List<Instructor> getAllInstructors() {
		List<Instructor> instructorList = new ArrayList<Instructor>();
		String query = "SELECT * FROM instructor";

		try {
			conn = oc.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				Instructor instructor = new Instructor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getString(6));
				instructorList.add(instructor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			this.dispose();
		}

		return instructorList;
	}

	/**
	 * 
	 * Overrides InstructorDAOI interface method
	 * This method queries the database for an instructor using their email address
	 * 
	 * @param	email		email address of the instructor
	 * @return 	instructor 	the instructor that matches the queried email address 
	 * 
	 */
	@Override
	public Instructor getInstructorByGmail(String email) {
		Instructor instructor = new Instructor();
		String query = "SELECT * FROM instructor WHERE email = ?";

		try {
			conn = oc.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email.toLowerCase()); //lower case email format to match database
			rs = ps.executeQuery();
			if (rs.next()) {
				instructor = new Instructor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			this.dispose();
		}

		return instructor;
	}
	
	/**
	 * 
	 * Compares the entered password to the password from the database to validate the user.
	 * 
	 * @param 	ins					the instructor who is being validated
	 * @param 	comparablePas		the password used to compare to the database
	 * @return	role				roles are admin / instructor / or wrong credentials
	 * 
	 */
	public String validateUser(Instructor ins, String comparablePas) {
		String role = null;
		
		try {
			boolean validation = (ins.getPass().equals(comparablePas) ? true : false);
			
			if(validation && ins.getAdminRole() == 1) {
				role = "Admin";
			}else if (validation && ins.getAdminRole() == 0) {
				role = "Instructor";
			}else {
				role = "Wrong Credentials"; //role is wrong credentials if incorrect password
			}
			
		}catch (NullPointerException e) {
			role = "Wrong Credentials"; //role is wrong credentials if no email found in database
		}

		return role;
	}

}
