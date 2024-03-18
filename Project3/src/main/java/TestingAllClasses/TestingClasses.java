package TestingAllClasses;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import Dao.CoursPerDepSem;
import Dao.CoursPerStud;
import Dao.StudPerCourseSem;
import Dao.StudPerDepSem;
import Dao.StudentPerSemester;
import Beans.Course;
import Beans.StudentRegistration;

public class TestingClasses {

    @Test
    public void testGetCoursesPerDepartmentAndSemester() {
        
    	CoursPerDepSem coursePerDepSem = new CoursPerDepSem();

        //  departmentId and semesterId
        String departmentId = "Dep1";
        String semesterId = "SEM1";

        // Call the method to get the list of courses
        List<Course> courses = coursePerDepSem.getCoursesPerDepartmentAndSemester(departmentId, semesterId);

        //Check if not null
        assertNotNull(courses);

        // Print all courses 
        for (Course course : courses) {
            System.out.println("Course ID: " + course.getCourseId());
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Course Name: " + course.getCourseName());
           
        }
        
       
    }
    
    @Test
    public void testGetCoursesPerStudent() {
        
        CoursPerStud coursesPerStudent = new CoursPerStud();

        // Provide sample student ID
        int studentId = 123; 

        //the method to get the list of courses
        List<Course> courses = coursesPerStudent.getCoursesPerStudent(studentId);

        // Check that the list is not null
        assertNotNull(courses);

      
        for (Course course : courses) {
            System.out.println("Course ID: " + course.getCourseId());
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Course Name: " + course.getCourseName());
          
        }

       
    }
    
    @Test
    public void testGetStudentsPerSemester() {
        
        StudentPerSemester studentPerSemester = new StudentPerSemester();

        //  semester ID
        String semesterId = "345"; 

        // Call the method to get the list of student registrations
        List<StudentRegistration> registrations = studentPerSemester.getStudentsPerSemester(semesterId);

        // Assert that the list is not null
        assertNotNull(registrations);

        // Print the retrieved student registrations (optional)
        for (StudentRegistration registration : registrations) {
            System.out.println("Registration ID: " + registration.getRegistrationId());
            System.out.println("Registration Code: " + registration.getRegistrationCode());
            System.out.println("Registration Date: " + registration.getRegistrationDate());
           
        }

    }
    
    @Test
    public void testGetStudentsPerCourseAndSemester() {
       
        StudPerCourseSem studPerCourseSem = new StudPerCourseSem();

        //  course code and semester ID
        String courseCode = "MATH101"; 
        String semesterId = "345"; 

       
        List<StudentRegistration> registrations = studPerCourseSem.getStudentsPerCourseAndSemester(courseCode, semesterId);

        //Check that list is not null
        assertNotNull(registrations);

        // Print the retrieved student registrations
        for (StudentRegistration registration : registrations) {
            System.out.println("Registration ID: " + registration.getRegistrationId());
            System.out.println("Registration Code: " + registration.getRegistrationCode());
            System.out.println("Registration Date: " + registration.getRegistrationDate());

        }

      
    }
    
    @Test
    public void testGetStudentsPerDepartmentAndSemester() {
        
        StudPerDepSem studPerDepSem = new StudPerDepSem();

        //  department ID and semester ID
        String departmentId = "DEPT001"; 
        String semesterId = "345"; 

        // Call the method to get the list of student registrations
        List<StudentRegistration> registrations = studPerDepSem.getStudentsPerDepartmentAndSemester(departmentId, semesterId);

        // Check if  the list is not null
        assertNotNull(registrations);

       
        for (StudentRegistration registration : registrations) {
            System.out.println("Registration ID: " + registration.getRegistrationId());
            System.out.println("Registration Code: " + registration.getRegistrationCode());
            System.out.println("Registration Date: " + registration.getRegistrationDate());
           
        }

    }
    
    
}
