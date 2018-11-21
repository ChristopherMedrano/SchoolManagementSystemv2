package CoreJava.CustomExceptions;

import java.util.InputMismatchException;

public class InvalidInputException extends InputMismatchException{

	public InvalidInputException(String message) {
		System.out.println("Invalid input: " + message + "\nExiting program");
		System.exit(0);
	}
}
