package CoreJava.SystemInterfaces;

import java.util.List;

import CoreJava.DAO.OracleConnection;
import CoreJava.Models.Course;
import CoreJava.Models.Teaching;

public interface TeachingDAOI {
	OracleConnection oc = new OracleConnection();
	int registerTeacherToCourse(int courseID, int instructorID);
	List<Teaching> getInstructorsCourses();
}
