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
import CoreJava.SystemInterfaces.CourseDAOI;

public class CourseDAO implements CourseDAOI {

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
	public List<Course> getAllCourses() {
		List<Course> courseList = new ArrayList<Course>();
		Course course = new Course();
		String query = "SELECT * FROM course";

		try {
			conn = oc.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				course = new Course(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				courseList.add(course);
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

		return courseList;
	}

	@Override
	public List<Course> getCourseByInstructor(int instructorID) {
		List<Course> instructorCourses = new ArrayList<Course>();
		Course course = new Course();
		String query = "SELECT course.COURSE_NAME FROM teaching LEFT JOIN course ON teaching.course_id = course.course_id WHERE instructor_id = ?";

		try {
			conn = oc.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, instructorID);
			rs = ps.executeQuery();
			while (rs.next()) {
				course = new Course();
				course.setCourseName(rs.getString(1));
				instructorCourses.add(course);
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
		return instructorCourses;
	}

}
