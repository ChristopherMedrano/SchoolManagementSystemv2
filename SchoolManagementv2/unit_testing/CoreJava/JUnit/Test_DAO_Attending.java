package CoreJava.JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CoreJava.DAO.AttendingDAO;
import CoreJava.DAO.SampleDB;
import CoreJava.Models.Course;

public class Test_DAO_Attending {
	static AttendingDAO attendingDAO;
	static SampleDB testDB;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		attendingDAO = new AttendingDAO();
		testDB = new SampleDB();
		
		testDB.getQueryList().populateDB();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testDB.getDropStatements().dropDB();
	}

	@Test
	public final void testRegisterStudentToCourse() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetStudentCourse() {
//		Course expectedCourse = new Course(2, "Earth Science", 2.4);
//		Course actualCourse = attendingDAO.getStudentCourse(3);
//		
//		assertEquals(expectedCourse,actualCourse);
		fail("Not yet implemented"); // TODO
		
	}

}
