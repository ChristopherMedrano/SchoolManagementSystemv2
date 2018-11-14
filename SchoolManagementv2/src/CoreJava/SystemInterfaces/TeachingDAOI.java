package CoreJava.SystemInterfaces;

import java.util.List;

import CoreJava.Models.Course;

public interface TeachingDAOI {
	int registerTeacherToCourse(int courseID, int instructorID);
	List<Course> getInstructorCourses();
}
