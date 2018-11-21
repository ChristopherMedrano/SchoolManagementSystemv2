package CoreJava.SystemInterfaces;

import java.util.List;

import CoreJava.DAO.OracleConnection;
import CoreJava.Models.Instructor;

/**
 * 
 * Interface for the InstructorDAO
 * 
 * Contains OracleConnection object to interact with database.  
 * 
 * Contains methods: 
 * 	- getAllInstructors()
 * 	- getInstructorByGmail(String email)
 * 
 * @author Chris Medrano
 *
 */
public interface InstructorDAOI {
	OracleConnection oc = new OracleConnection();
	
	List<Instructor> getAllInstructors();
	Instructor getInstructorByGmail(String email);
}
