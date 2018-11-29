package CoreJava.SystemInterfaces;

import CoreJava.DAO.OracleConnection;
import CoreJava.Models.Student;

/**
 * 
 * Interface for the StudentDAO
 * 
 * Contains OracleConnection object to interact with database.  
 * 
 * Contains methods: 
 * 	- getStudentByGmail(String email)
 * 
 * @author Chris Medrano
 *
 */
public interface StudentDAOI {
	OracleConnection oc = new OracleConnection();
	
	Student getStudentByGmail(String email);
}
