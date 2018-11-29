/**
 * 
 */
package CoreJava.JUnit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CoreJava.DAO.InstructorDAO;
import CoreJava.DAO.SampleDB;
import CoreJava.DAO.StudentDAO;
import CoreJava.Models.Instructor;


/**
 * @author Chris Medrano
 *
 */
public class Test_DAO_Instructor {
	static InstructorDAO instructorDAO;
	static SampleDB testDB;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testDB = new SampleDB();
		testDB.getQueryList().populateDB();
		instructorDAO = new InstructorDAO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testDB.getDropStatements().dropDB();
	}

	/**
	 * Test method for {@link CoreJava.DAO.InstructorDAO#getAllInstructors()}.
	 */
	@Test
	public final void testGetAllInstructors() {
		List<Instructor> instructorList = null;
		
		instructorList = instructorDAO.getAllInstructors();
		
		Assert.assertNotNull(instructorList);
	}

	
	
	/**
	 * Test method for {@link CoreJava.DAO.InstructorDAO#getInstructorByGmail(java.lang.String)}.
	 */
	@Test
	public final void testGetInstructorByGmail() {
		//expected
		Instructor expected = new Instructor(3, "mark","mark@gmail.com", "important", 1, "666");
		
		//actual
		Instructor actual = instructorDAO.getInstructorByGmail("mark@gmail.com");
		
		//result
		Assert.assertEquals(expected, actual);
		
	}

	
	/**
	 * Test method for {@link CoreJava.DAO.InstructorDAO#validateUser(CoreJava.Models.Instructor, java.lang.String)}.
	 */
	@Test
	public final void testValidateUser() {
		Instructor instructor = new Instructor();
		String comparablePas = null;
		String role;
		
		role = instructorDAO.validateUser(instructor, comparablePas);
		
		Assert.assertTrue(role.equals("Admin") || role.equals("Instructor"));
	}

}
