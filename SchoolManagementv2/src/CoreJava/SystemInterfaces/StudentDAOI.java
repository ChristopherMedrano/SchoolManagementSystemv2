package CoreJava.SystemInterfaces;

import CoreJava.Models.Student;

public interface StudentDAOI {
	Student getStudentByGmail(String email);
}
