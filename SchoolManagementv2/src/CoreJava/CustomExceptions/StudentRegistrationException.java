package CoreJava.CustomExceptions;

/**
 * 
 * Custom Exception class that extends the Exception interface. This exception
 * should be thrown when a student fails to meet the minimum requirements for
 * class registration.
 * 
 * @author Christopher Medrano
 *
 */

public class StudentRegistrationException extends Exception {
	
	/**
	 * 
	 * Accepts a string parameter 
	 * and passes it to its parent using the super keyword
	 * 
	 * Terminates program after exception is thrown. 
	 * 
	 * @param message
	 */
	
	public StudentRegistrationException(String message) {
		super(message);
	}

}
