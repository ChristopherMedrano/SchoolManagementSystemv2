/**
 * 
 */
package CoreJava.JUnit;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import CoreJava.DAO.TeachingDAO;
import CoreJava.Models.Teaching;

/**
 * 
 * Tests the methods in the TeachingDAO using JUnit 4
 * @author Chris Medrano
 *
 */
public class Test_DAO_Teaching {
	static TeachingDAO teachingDAO;
	//static SampleDB testDB;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		teachingDAO = new TeachingDAO();
		//testDB = new SampleDB();
		//testDB.getQueryList().populateDB();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//testDB.getDropStatements().dropDB();
	}

	/**
	 * Test method for registerTeacherToCourse(int, int)
	 */
	@Test
	public final void testRegisterTeacherToCourse() {
		int courseID, instructorID;
		courseID = 1;
		instructorID = 1;
		
		Assert.assertTrue(teachingDAO.registerTeacherToCourse(courseID, instructorID) != 0);
	}

	/**
	 * Test method for getInstructorsCourses()
	 */
	@Test
	public final void testGetInstructorsCourses() {
		List<Teaching> instructorCourses;
		
		instructorCourses = teachingDAO.getInstructorsCourses();
		
		Assert.assertNotNull(instructorCourses);
	}

}
