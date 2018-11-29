/**
 * 
 */
package CoreJava.JUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import CoreJava.DAO.AttendingDAO;
import CoreJava.DAO.SampleDB;
import CoreJava.DAO.StudentDAO;
import CoreJava.Models.Student;

/**
 * 
 * Tests the methods in the StudentDAO using JUnit 4
 * @author Chris Medrano
 *
 */
public class Test_DAO_Student {
	static StudentDAO studentDAO;
	static SampleDB testDB;
	
	/**
	 * 
	 * Sets up test database.
	 * Queries pulled from /src/CoreJava/Resources/populateData.sql
	 * Creates new StudentDAO object. 
	 * 
	 * @throws java.lang.Exception
	 * 
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testDB = new SampleDB();
		testDB.getQueryList().populateDB();
		studentDAO = new StudentDAO();
	}

	/**
	 * 
	 * Drops all tables from the sample database.
	 * 
	 * @throws java.lang.Exception
	 * 
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testDB.getDropStatements().dropDB();
	}
	
	/**
	 * Test getStudentByGmail(String email)
	 */	
	@Test
	public final void testGetStudentByGmail() {
		// expected result 
		Student expected = new Student(000, "Bairon Vasquez","b@gmail.com", 3.4, "111", -1);
		
		//	actual result 
		Student actual = studentDAO.getStudentByGmail("b@gmail.com");
		
		// result
		Assert.assertEquals(expected, actual);

	}
	
	/**
	 * Test validateUser(String passToValidate, String comparablePas)
	 */
	@Test
	public final void testValidateUser() {
		String comparablePas, passToValidate;
		
		// expected
		comparablePas = "111";
		
		// expected
		Student student = new Student(000, "Bairon Vasquez","b@gmail.com", 3.4, "111", -1);
		passToValidate = student.getPass();
		
		Assert.assertTrue(studentDAO.validateUser(passToValidate, comparablePas));
	}

}
