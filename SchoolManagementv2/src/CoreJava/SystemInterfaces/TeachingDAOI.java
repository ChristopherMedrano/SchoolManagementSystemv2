package CoreJava.SystemInterfaces;

import java.util.List;

import CoreJava.DAO.OracleConnection;
import CoreJava.Models.Course;
import CoreJava.Models.Teaching;

/**
 * 
 * Interface for the TeachingDAO
 * 
 * Contains OracleConnection object to interact with database.  
 * 
 * Contains methods: 
 * 	- registerTeacherToCourse(int courseID, int instructorID)
 * 	- getInstructorsCourses()
 * 
 * @author Chris Medrano
 *
 */
public interface TeachingDAOI {
	OracleConnection oc = new OracleConnection();
	
	int registerTeacherToCourse(int courseID, int instructorID);
	List<Teaching> getInstructorsCourses();
}
