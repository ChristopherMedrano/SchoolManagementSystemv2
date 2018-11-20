package CoreJava.SystemInterfaces;

import java.util.List;

import CoreJava.DAO.OracleConnection;
import CoreJava.Models.Instructor;

public interface InstructorDAOI {
	OracleConnection oc = new OracleConnection();
	
	List<Instructor> getAllInstructors();
	Instructor getInstructorByGmail(String email);
}
