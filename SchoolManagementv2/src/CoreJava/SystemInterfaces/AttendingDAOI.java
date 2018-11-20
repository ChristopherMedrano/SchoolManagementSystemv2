package CoreJava.SystemInterfaces;

import java.util.List;

import CoreJava.CustomExceptions.StudentRegistrationException;
import CoreJava.DAO.OracleConnection;
import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import CoreJava.Models.Student;

/**
 * Interface for the AttendingDAO
 * 
 * Contains OracleConnection object to interact with database.  
 * 
 * Contains methods: 
 * 	- registerStudentToCourse
 * 	- getStudentCourse
 * 
 * 
 * @author Chris Medrano
 *
 */
public interface AttendingDAOI {
	OracleConnection oc = new OracleConnection();
	
	int registerStudentToCourse(Student student, Course course) throws StudentRegistrationException;
	List<Attending> getStudentCourse(int studentID);
	
	
}
