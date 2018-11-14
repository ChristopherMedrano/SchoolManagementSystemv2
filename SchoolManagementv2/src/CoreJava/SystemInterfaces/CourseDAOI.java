package CoreJava.SystemInterfaces;

import java.util.List;

import CoreJava.Models.Course;

public interface CourseDAOI {
	
	List<Course> getAllCourses();
	List<Course> getCourseByInstructor();
}
