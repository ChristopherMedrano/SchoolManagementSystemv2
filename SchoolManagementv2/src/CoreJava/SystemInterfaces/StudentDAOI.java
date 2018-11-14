package CoreJava.SystemInterfaces;

import CoreJava.Models.Student;

public interface StudentDAOI {
	Student getStudentByEmail(String email);
}
