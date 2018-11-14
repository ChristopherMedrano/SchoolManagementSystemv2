package CoreJava.CustomExceptions;

public class StudentRegistrationException extends Exception{
	
	public StudentRegistrationException(String message) {
		//accepts a string parameter and 
		//passes it to its parent using the super keyword 
		super(message);
	}
	
	

}
