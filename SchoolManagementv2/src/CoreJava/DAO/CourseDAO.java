package CoreJava.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CoreJava.Models.Course;
import CoreJava.SystemInterfaces.CourseDAOI;

/**
 * This Data Access Object maps queries for the Course table to the database.
 * The Course table represents the courses.
 * 
 * Implements the CourseDAOI interface
 * 
 * @author Chris Medrano
 *
 */
public class CourseDAO extends AbstractDAO implements CourseDAOI {

	/**
	 * 
	 * Overrides CourseDAOI interface method This method queries the Course table in
	 * the database Selects all rows from Course table
	 * 
	 * @return List of all courses
	 * 
	 */
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

	/**
	 * 
	 * Overrides CourseDAOI interface method This method queries the database for
	 * all courses an Instructor is assigned to
	 * 
	 * @param int the ID of instructor used to query database
	 * @return List Courses the Instructor is assigned to
	 * 
	 */
	@Override
	public List<Course> getCourseByInstructor(int instructorID) {
		List<Course> instructorCourses = new ArrayList<Course>();
		Course course = new Course();
		String query = "SELECT course.COURSE_ID, course.COURSE_NAME, course.MINIMUN_GPA FROM teaching LEFT JOIN course ON teaching.course_id = course.course_id LEFT JOIN instructor on teaching.instructor_id = instructor.instructor_id WHERE teaching.instructor_id = ?";

		try {
			conn = oc.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, instructorID);
			rs = ps.executeQuery();
			while (rs.next()) {
				course = new Course(rs.getInt(1), rs.getString(2), rs.getDouble(3));
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
