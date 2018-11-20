package CoreJava.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import CoreJava.Models.Course;
import CoreJava.Models.Teaching;
import CoreJava.SystemInterfaces.TeachingDAOI;

public class TeachingDAO implements TeachingDAOI {

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

	public TeachingDAO() {

	}

	@Override
	public int registerTeacherToCourse(int courseID, int instructorID) {
		String query = "INSERT INTO teaching (COURSE_ID, INSTRUCTOR_ID) VALUES(?, ?)";
		int rs = 0;

		try {
			conn = oc.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, courseID);
			ps.setInt(2, instructorID);
			rs = ps.executeUpdate();

		} catch (SQLException e) {
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		} finally {
			this.dispose();
		}

		return rs;
	}

	@Override
	public List<Teaching> getInstructorsCourses() {
		List<Teaching> instructorCourses = new ArrayList<Teaching>();
		Teaching teaching = null;
		String query = "SELECT DISTINCT TEACHING.INSTRUCTOR_ID, INSTRUCTOR.FULL_NAME FROM TEACHING LEFT JOIN INSTRUCTOR ON TEACHING.INSTRUCTOR_ID = INSTRUCTOR.INSTRUCTOR_ID ORDER BY TEACHING.INSTRUCTOR_ID ASC";
		
		try {
			conn = oc.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				teaching = new Teaching();
				teaching.setName(rs.getString(2));
				instructorCourses.add(teaching);
			}

		} catch (SQLException e) {
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		} finally {
			this.dispose();
		}

		
		
		return instructorCourses;
	}

}
