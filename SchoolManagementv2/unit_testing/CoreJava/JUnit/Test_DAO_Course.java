/**
 * 
 */
package CoreJava.JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CoreJava.DAO.AttendingDAO;
import CoreJava.DAO.CourseDAO;
import CoreJava.DAO.SampleDB;
import CoreJava.Models.Course;
import CoreJava.Models.Instructor;


/**
 * @author Chris Medrano
 *
 */
public class Test_DAO_Course {
	static SampleDB testDB;
	static CourseDAO courseDAO;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		courseDAO = new CourseDAO();
		testDB = new SampleDB().getQueryList().populateDB();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testDB.getDropStatements().dropDB();
	}

	

	/**
	 * Test method for {@link CoreJava.DAO.CourseDAO#getAllCourses()}.
	 */
	@Test
	public final void testGetAllCourses() {
		List<Course> courseList = null;
		
		courseList = courseDAO.getAllCourses();
		
		Assert.assertNotNull(courseList);
	}

	/**
	 * Test method for {@link CoreJava.DAO.CourseDAO#getCourseByInstructor(int)}.
	 */
	@Test
	public final void testGetCourseByInstructor() {
		List<Course> instructorCourses = null;
		
		instructorCourses = courseDAO.getCourseByInstructor(1);
		
		Assert.assertNotNull(instructorCourses);
	}

}
