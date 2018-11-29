/**
 * 
 */
package CoreJava.JUnit;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import CoreJava.DAO.CourseDAO;
import CoreJava.Models.Course;


/**
 * 
 * Tests the methods in the CourseDAO using JUnit 4
 * @author Chris Medrano
 *
 */
public class Test_DAO_Course {
	//static SampleDB testDB;
	static CourseDAO courseDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		courseDAO = new CourseDAO();
		//testDB = new SampleDB().getQueryList().populateDB();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//testDB.getDropStatements().dropDB();
	}

	/**
	 * Test method for getAllCourses()
	 */
	@Test
	public final void testGetAllCourses() {
		List<Course> courseList = null;
		
		courseList = courseDAO.getAllCourses();
		
		Assert.assertNotNull(courseList);
	}

	/**
	 * Test method for getCourseByInstructor(int)
	 */
	@Test
	public final void testGetCourseByInstructor() {
		List<Course> instructorCourses = null;
		
		instructorCourses = courseDAO.getCourseByInstructor(1);
		
		Assert.assertNotNull(instructorCourses);
	}

}
