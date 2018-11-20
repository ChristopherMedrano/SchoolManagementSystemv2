package CoreJava.SystemInterfaces;

import java.util.List;

import CoreJava.DAO.OracleConnection;
import CoreJava.Models.Course;

public interface CourseDAOI {
	OracleConnection oc = new OracleConnection();
	
	List<Course> getAllCourses();
	List<Course> getCourseByInstructor(int instructorID);
}
