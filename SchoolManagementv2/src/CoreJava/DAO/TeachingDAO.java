package CoreJava.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CoreJava.Models.Teaching;
import CoreJava.SystemInterfaces.TeachingDAOI;

public class TeachingDAO extends AbstractDAO implements TeachingDAOI {

	@Override
	public int registerTeacherToCourse(int courseID, int instructorID) {
		String query = "INSERT INTO teaching (COURSE_ID, INSTRUCTOR_ID) VALUES(?, ?)";
		String idQuery = "SELECT \"ISEQ$$_88373\".CURRVAL FROM TEACHING";
		int recordID = 0, result = 0;

		try {
			conn = oc.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, courseID);
			ps.setInt(2, instructorID);
			result = ps.executeUpdate();

			if (result == 1) {
				st = conn.createStatement();
				rs = st.executeQuery(idQuery);
				if (rs.next()) {
					recordID = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			this.dispose();
		}

		return recordID;
	}

	@Override
	public List<Teaching> getInstructorsCourses() {
		List<Teaching> instructorCourses = new ArrayList<Teaching>();
		Teaching teaching = null;
		String query = "SELECT course.COURSE_NAME, course.MINIMUN_GPA, INSTRUCTOR.FULL_NAME, INSTRUCTOR.EMAIL FROM TEACHING LEFT JOIN INSTRUCTOR ON TEACHING.INSTRUCTOR_ID = INSTRUCTOR.INSTRUCTOR_ID LEFT JOIN course ON teaching.COURSE_ID = course.COURSE_ID";

		try {
			conn = oc.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				teaching = new Teaching(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(4));
				instructorCourses.add(teaching);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			this.dispose();
		}

		return instructorCourses;
	}

}
