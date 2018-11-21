package CoreJava.MainEntryPoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import CoreJava.CustomExceptions.InvalidInputException;
import CoreJava.CustomExceptions.StudentRegistrationException;
import CoreJava.DAO.AttendingDAO;
import CoreJava.DAO.CourseDAO;
import CoreJava.DAO.InstructorDAO;
import CoreJava.DAO.StudentDAO;
import CoreJava.DAO.TeachingDAO;
import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import CoreJava.Models.Instructor;
import CoreJava.Models.Student;
import CoreJava.Models.Teaching;

public class MainEntryClass {
	// Session ONE
//	public static void main(String[] args) throws ClassNotFoundException, IOException, StudentRegistrationException {
//		StudentDAO studentDAO = new StudentDAO();
//		InstructorDAO instructorDAO = new InstructorDAO();
//		CourseDAO courseDAO = new CourseDAO();
//		Student student = new Student();
//		List<Instructor> instructorList = new ArrayList<Instructor>();
//
//		System.out.println("Get student by email");
//		student = studentDAO.getStudentByGmail("b@gmail.com");
//		System.out.println(student.getName() + " " + student.getEmail());
//
//		System.out.println("\nValidate student password");
//		System.out.println(studentDAO.validateUser(student.getPass(), "111"));
//
//		System.out.println("\nGet all instructors");
//		instructorList = instructorDAO.getAllInstructors();
//		for (Instructor i : instructorList) {
//			System.out.println(i.getName() + " " + i.getSpeciality());
//		}
//
//		System.out.println("\nGet Instructor by email");
//		Instructor instructor = instructorDAO.getInstructorByGmail("mark@gmail.com");
//		System.out.println(instructor.getName() + " " + instructor.getEmail());
//
//		System.out.println("\nValidate instructor role");
//		System.out.println(instructorDAO.validateUser(instructor, "666"));
//
//		System.out.println("\nList of all courses");
//		List<Course> courseList = new ArrayList<Course>();
//		courseList = courseDAO.getAllCourses();
//		for (Course c : courseList) {
//			System.out.println(c.getCourseName() + " " + c.getMinGpa());
//		}
//
//		System.out.println("\nList of courses by Instructor ID");
//		courseList = courseDAO.getCourseByInstructor(3);
//		for (Course c : courseList) {
//			System.out.println(c.getCourseName());
//		}
//
//		System.out.println("\nRegister Student to Course");
//		int test = 0;
//		Course course = new Course(1, "Math", 2.1);
//		AttendingDAO attendingDAO = new AttendingDAO();
//		System.out.println("Student info: " + student.getName() + " " + student.getGpa());
//		System.out.println("course info: " + " " + course.getID() + " " + course.getCourseName() + " " + course.getMinGpa());
//		test = attendingDAO.registerStudentToCourse(student, course);
//		System.out.println("Result: " + test);
//
//		System.out.println("\nCourses a Student is registered to: ");
//		courseList = attendingDAO.getStudentCourse(3);
//		for (Course c : courseList) {
//			System.out.println(c.getCourseName());
//		}
//
//		System.out.println("\nAssign instructor to course: ");
//		TeachingDAO teachingDAO = new TeachingDAO();
//		int teachingDAOResult = 0;
//		teachingDAOResult = teachingDAO.registerTeacherToCourse(1, 2);
//		System.out.println(teachingDAOResult);
//
//		System.out.println("\nGet Instructors Courses");
//		List<Teaching> getInstructorCourses = new ArrayList<Teaching>();
//		getInstructorCourses = teachingDAO.getInstructorCourses();
//		for (Teaching i : getInstructorCourses) {
//			System.out.println(i.getName());
//		}
//
//	}
//    ================================================================================================================================
//    =====================================================     Seperator      =======================================================
//    ================================================================================================================================
    public void allIntructors() throws ClassNotFoundException, IOException {
    	InstructorDAO insDAO = new InstructorDAO();
        
        List<Instructor> allIns = insDAO.getAllInstructors();
        System.out.printf("\nInstructors:\n======================================================================\n");
        System.out.printf("%-3s INTRUCTOR NAME \t INSTRUCTOR EMAIL \t INSTRUCTOR SPECIALITY\n","ID");
        
        //altered some method names to match
        for(Instructor insAGN : allIns) {
            System.out.printf("%-3s %-20s %-23s %s\n",insAGN.getID(),  insAGN.getName(), insAGN.getEmail(), insAGN.getSpeciality());
        }
        
    }
    
    public void allCourse() throws ClassNotFoundException, IOException {
        CourseDAO coDAO = new CourseDAO();
        
        List<Course> allCo = coDAO.getAllCourses();
        System.out.printf("\nCourses:\n===============================================\n");
        System.out.printf("%-3s COURSE NAME \t MINIMUN GPA\n", "ID");
        
        //changed some method names to match
        for(Course coAGN : allCo) {
            System.out.printf("%-3s %-20s %s\n",coAGN.getID(),  coAGN.getCourseName(), coAGN.getMinGpa());
        }
        
    }
    
    public void allCoursesWithInstructor() {
        TeachingDAO teaDAO = new TeachingDAO();
        List<Teaching> teaList = teaDAO.getInstructorsCourses(); //FIXED TYPO in method name
        System.out.printf("COURSE NAME \t COURSE MINIMUN GPA \t INSTRUCTOR NAME \t INSTRUCTOR EMAIL\n\n");
        for(Teaching teaAGN : teaList) {
            System.out.printf("%-16s %-23s %-23s %s\n", teaAGN.getCourseName(), teaAGN.getMinGpa(), 
                    teaAGN.getName(), teaAGN.getEmail());
        }
    }
    
    public void StudentCourses(List<Attending> attList) {
        int counter = 1;
        System.out.printf("\nMy Classes:\n");
        System.out.printf("%-3s COURSE NAME \t INTRUCTOR NAME \t INSTRUCTOR EMAIL\n", "#");
        for(Attending att : attList) {
            System.out.printf("%-3s %-20s %-23s %s\n", counter, att.getCourseName(), att.getFullName(), att.getEmail());
            counter++;
            
        }
    }
    
    public void allCourses(List<Course> coList) {
        int counter = 1;
        System.out.printf("\nAll Courses:\n");
        System.out.printf("%-3s COURSE NAME \t MINIMUN GPA\n", "ID");
        for(Course co : coList) {
            System.out.printf("%-3s %-20s %s\n", counter, co.getCourseName(), co.getMinGpa());
            counter++;
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException, IOException, StudentRegistrationException, InputMismatchException {
        boolean quit = false;
        Scanner reader = new Scanner(System.in);
        MainEntryClass mainObj = new MainEntryClass();
        int InsOrStu = -1;
        Instructor ins = null;  InstructorDAO insDAO = null;   String insROLE = "";
        
        
        Student stu = null;     StudentDAO stuDAO = null;
        
        Course co = null;       CourseDAO coDAO = null;
        
        Attending att = null;   AttendingDAO attDAO = null;
        
        Teaching tea = null;    TeachingDAO teaDAO = null;
        
        String email = "";
        String password = "";
        while(!quit) {
            System.out.println("Are you a(n)\n1. Instructor \n2. Student \n3. quit \nPlease, enter 1, 2 or 3 \n");
            
            try {
            	InsOrStu = reader.nextInt();
            }catch (InputMismatchException e){
            	throw new InvalidInputException("Enter 1, 2, or 3");
            }
            
            if(InsOrStu == 1) {
                boolean logout = false;
                while(!logout) {
                    System.out.println("Enter Your Email:\n");
                    email = reader.next();
                    System.out.println("Enter Your Password:\n");
                    password = reader.next();
                    insDAO = new InstructorDAO();
                    ins = insDAO.getInstructorByGmail(email);
                    
                    insROLE = insDAO.validateUser(ins, password);
                    
                    if("Admin".equals(insROLE)) {
                        teaDAO = new TeachingDAO();
                        mainObj.allCoursesWithInstructor();
                        String out = "-1";
                        while(!out.equals("2")) {
                            System.out.printf("\n\n");
                            System.out.println("1. Assign Instructor to Course");
                            System.out.println("2. Logout");
                            out = reader.next();  
                            
                            if(out.equals("1")) {
                                int instructor_id = -1;
                                int course_id = -1;
                                mainObj.allIntructors();
                                System.out.println("\nWhat Instructor?\n");                     
                                try {
                                	instructor_id = reader.nextInt();
                                }catch (InputMismatchException e){
                                	throw new InvalidInputException("Enter instructor id");
                                }
                                
                                mainObj.allCourse();
                                System.out.println("\nWhich Course?\n");
                                
                                try {
                                	course_id = reader.nextInt();
                                }catch (InputMismatchException e){
                                	throw new InvalidInputException("Enter course id");
                                }
                                
                                int assignId =  teaDAO.registerTeacherToCourse(course_id, instructor_id);
                                if(assignId != -1) {
                                    System.out.println("\n -->Instructor Assigned<--\nNew Record Id: "+ assignId+"\n");
                                }
                                mainObj.allCoursesWithInstructor();
                            }
                        }
                        System.out.printf("\n\n");
                        logout = true;
                    }else if("Instructor".equals(insROLE)) {
                        coDAO = new CourseDAO();
                        List<Course> coList = coDAO.getCourseByInstructor(ins.getID());
                        System.out.printf("COURSE NAME \t COURSE MINIMUN GPA\n");
                        for(Course insCO : coList) {
                            System.out.printf("%s \t\t %s\n", insCO.getCourseName(), insCO.getMinGpa());
                        }
                        String out = "-1";
                        while(!out.equals("1")) {
                            System.out.println("1. Logout");
                            out = reader.next();  
                        }
                        ins = null;
                        logout = true;
                    }else if("Wrong Credentials".equals(insROLE)) {
                        System.out.println(insROLE);
                        continue;
                    }
                
                }
                
            }else if(InsOrStu == 2) {
                stuDAO = new StudentDAO();
                attDAO = new AttendingDAO();
                boolean logout = false;
                while(!logout) {
                    System.out.println("Enter Your Email:\n");
                    email = reader.next();
                    System.out.println("Enter Your Password:\n");
                    password = reader.next();
                    
                    List<Attending> attList = null;
                    stu = stuDAO.getStudentByGmail(email);
                    
                    if(stu != null && stu.getRole() == -1 && stuDAO.validateUser(stu.getPass(), password)) {
                        
                        String classesTo = "";
                        while(!classesTo.equals("2")) {
                            attList = attDAO.getStudentCourse(stu.getID());
                            mainObj.StudentCourses(attList);
                            System.out.printf("\n1. Register to Class");
                            System.out.printf("\n2. Logout\n");
                            classesTo = reader.next();
                            if(classesTo.equals("1")) {
                                coDAO = new CourseDAO();
                                attDAO = new AttendingDAO();
                                List<Course> coList = coDAO.getAllCourses();
                                mainObj.allCourses(coList);
                                System.out.println("\nWhich Course?\n");
                                try {
                                	int course_idForStudent = reader.nextInt();
                                	attDAO.registerStudentToCourse(stu, coList.get(course_idForStudent - 1));
                                    classesTo = "";
                                }catch (InputMismatchException e){
                                	throw new InvalidInputException("Enter course id");
                                }
                            }
                        }
                        logout = true;
                    }else {
                        System.out.printf("\nWrong Credentials\n");
                        continue;
                    }
                }
                
            }else if(InsOrStu == 3) {
                quit = true;
            }
        }
        
    }
}
