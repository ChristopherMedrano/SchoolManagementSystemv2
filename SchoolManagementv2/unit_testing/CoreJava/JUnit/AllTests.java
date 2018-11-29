package CoreJava.JUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Test_DAO_Attending.class, Test_DAO_Course.class, Test_DAO_Instructor.class, Test_DAO_Student.class,
		Test_DAO_Teaching.class })
public class AllTests {

}
