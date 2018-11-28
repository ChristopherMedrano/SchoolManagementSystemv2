/**
 * 
 */
package CoreJava.JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CoreJava.DAO.AttendingDAO;
import CoreJava.DAO.SampleDB;
import CoreJava.DAO.StudentDAO;

/**
 * @author Students
 *
 */
public class Test_DAO_Student {
	static StudentDAO studentDAO;
	static SampleDB testDB;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testDB = new SampleDB();
		testDB.getQueryList().populateDB();
		studentDAO = new StudentDAO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testDB.getDropStatements().dropDB();
	}
	
	/**
	 * Test getStudentByGmail(String email);
	 */
	@Test
	public final void test() {
		fail("Not yet implemented"); // TODO
	}

}
