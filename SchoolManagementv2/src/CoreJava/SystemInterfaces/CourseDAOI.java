package CoreJava.SystemInterfaces;

import java.util.List;

import CoreJava.DAO.OracleConnection;
import CoreJava.Models.Course;

/**
 * Interface for the CourseDAO
 * 
 * Contains OracleConnection object to interact with database.  
 * 
 * Contains methods: 
 * 	- getAllCourses()
 * 	- getCourseByInstructor(int instructorID)
 * 
 * 
 * @author Chris Medrano
 *
 */
public interface CourseDAOI {
	OracleConnection oc = new OracleConnection();
	
	List<Course> getAllCourses();
	List<Course> getCourseByInstructor(int instructorID);
}
