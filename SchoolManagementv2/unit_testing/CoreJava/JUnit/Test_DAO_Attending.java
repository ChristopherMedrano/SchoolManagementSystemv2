package CoreJava.JUnit;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import CoreJava.CustomExceptions.StudentRegistrationException;
import CoreJava.DAO.AttendingDAO;
import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import CoreJava.Models.Student;

/**
 * 
 * Tests the methods in the AttendingDAO using JUnit 4
 * @author Chris Medrano
 *
 */
public class Test_DAO_Attending {
	static AttendingDAO attendingDAO;
	//static SampleDB testDB;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		attendingDAO = new AttendingDAO();
		//testDB = new SampleDB();
		//testDB.getQueryList().populateDB();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//testDB.getDropStatements().dropDB();
	}
	
	/**
	 * Test registerStudentToCourse(student, course)
	 */	
	@Test
	public final void testRegisterStudentToCourse() throws StudentRegistrationException {
		Student student = new Student(1, "Bairon Vasquez","b@gmail.com", 3.4, "111", -1);
		Course course = new Course (1, "Science", 3.2);
		int attendingID;
		
		attendingID = attendingDAO.registerStudentToCourse(student, course);
		
		Assert.assertTrue(attendingID != 0);
	}
	
	/**
	 * Test StudentRegistrationException
	 */	
	@Test(expected = StudentRegistrationException.class)
	public final void testStudentRegistrationException() throws StudentRegistrationException {
		Student student = new Student(1, "Bairon Vasquez","b@gmail.com", 1.0, "111", -1);
		Course course = new Course (1, "Science", 3.2);
		
		attendingDAO.registerStudentToCourse(student, course);
	}
	
	/**
	 * Test getStudentCourse(int id)
	 */	
	@Test
	public final void testGetStudentCourse() {
		List<Attending> attendingCourses = null;
		
		attendingCourses = attendingDAO.getStudentCourse(1);
		
		Assert.assertNotNull(attendingCourses);
	}

}
