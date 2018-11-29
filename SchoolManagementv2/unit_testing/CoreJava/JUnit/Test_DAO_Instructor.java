/**
 * 
 */
package CoreJava.JUnit;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import CoreJava.DAO.InstructorDAO;
import CoreJava.Models.Instructor;

/**
 * 
 * Tests the methods in the InstructorDAO using JUnit 4
 * @author Chris Medrano
 *
 */
public class Test_DAO_Instructor {
	static InstructorDAO instructorDAO;
	//static SampleDB testDB;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//testDB = new SampleDB();
		//testDB.getQueryList().populateDB();
		instructorDAO = new InstructorDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//testDB.getDropStatements().dropDB();
	}

	/**
	 * Test method for getAllInstructors()
	 */
	@Test
	public final void testGetAllInstructors() {
		List<Instructor> instructorList = null;
		
		instructorList = instructorDAO.getAllInstructors();
		
		Assert.assertNotNull(instructorList);
	}

	/**
	 * Test method for getInstructorByGmail(String email)
	 */
	@Test
	public final void testGetInstructorByGmail() {
		//expected
		Instructor expected = new Instructor(3, "mark","mark@gmail.com", "important", 1, "666");
		
		//actual
		Instructor actual = instructorDAO.getInstructorByGmail("mark@gmail.com");
		
		//result
		Assert.assertEquals(expected.getEmail(), actual.getEmail());
		
	}

	
	/**
	 * Test method for validateUser(Instructor instructor, String comparablePas)
	 */
	@Test
	public final void testValidateUser() {
		Instructor instructor = new Instructor(3, "mark", "mark@gmail.com", "important", 1, "666");
		String comparablePas = "666";
		String role;
		
		role = instructorDAO.validateUser(instructor, comparablePas);
		
		Assert.assertTrue(role.equals("Admin") || role.equals("Instructor") || role.equals("Wrong Credentials"));
	}
}
