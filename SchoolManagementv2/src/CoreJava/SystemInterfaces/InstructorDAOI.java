package CoreJava.SystemInterfaces;

import java.util.List;

import CoreJava.Models.Instructor;

public interface InstructorDAOI {
	List<Instructor> getAllInstructors();
	Instructor getInstructorByEmail(String email);
}
