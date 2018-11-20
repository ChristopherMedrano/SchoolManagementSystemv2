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

public class InstructorDAO implements InstructorDAOI {

	protected Connection conn = null;
	protected Statement st = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

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

		}
	}

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

	@Override
	public Instructor getInstructorByGmail(String email) {
		Instructor instructor = new Instructor();
		String query = "SELECT * FROM instructor WHERE email = ?";

		try {
			conn = oc.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
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
	
	public String validateUser(Instructor ins, String comparablePas) {
		//String query = "SELECT pass FROM student WHERE student_id = 1";
		boolean validation = (ins.getPass().equals(comparablePas) ? true : false);
		String role = null;
		
		if(validation && ins.getAdminRole() == 1) {
			role = "Admin";
		}else if (validation && ins.getAdminRole() == 0) {
			role = "Inststructor";
		}else {
			role = "Wrong credentials";
		}
		return role;
	}

}
