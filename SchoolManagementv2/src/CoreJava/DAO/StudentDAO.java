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
				student.setID(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setGpa(rs.getDouble(4));
				student.setPass(rs.getString(5));
				student.setRole(rs.getInt(6));
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

	public boolean validateUser(String passToValidate, String comparablePas) {
		//String query = "SELECT pass FROM student WHERE student_id = 1";
		boolean validation = (passToValidate.equals(comparablePas) ? true : false);

		return validation;
	}

}
