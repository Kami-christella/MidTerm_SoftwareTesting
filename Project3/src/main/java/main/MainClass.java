package main;

import java.sql.Date;
import java.util.List;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Dao.AUDao;
import Dao.AcUnitDao;
import Dao.CoursPerDepSem;
import Dao.CoursPerStud;
import Dao.CourseDao;
import Dao.SemesterDao;
import Dao.StudPerCourseSem;
import Dao.StudPerDepSem;
import Dao.StudentDAO;
import Dao.StudentPerSemester;
import Dao.StudentRegDao;
import Dao.TeacherDao;


import Beans.AcademicUnit;
import Beans.AcademicUnitType;
import Beans.Course;
import Beans.Student;
import Beans.StudentRegistration;
import Beans.Teacher;
import Beans.Semester;



public class MainClass {
	public static void main(String[] args) {
//		 String dbUrl="jdbc:mysql://localhost:3306/school";
//	        String username="root";
//	        String passwd="Auca@2023";
	
		 boolean conditon = true;
	     int id;
	     String firstname;
	     String lastname;
	     String cname;
	     String lecturer;
	     int cid;
	    String dateOfBirth;

	    Student sd = new Student();
	     StudentDAO dao = new StudentDAO();
	     
	    
	     

	     String response;

		 while(conditon){
	            System.out.println("==============================");
	            System.out.println("Enter Number of your choice");
	            System.out.println("1.Register Student ");
	              System.out.println("2.Register Academic Unit ");
	                System.out.println("3.Register Semester");
	                  System.out.println("4.Register Course ");
	                  System.out.println("5.Register Academic Unit ");
	                  System.out.println("6.Register Student Registration ");
	                  System.out.println("7.Register Teacher ");
		              System.out.println("8.List of students per Semester");
		              System.out.println("9.List Students per Department and Semester  ");
		              System.out.println("9.List Students per Course and Semester  ");
		              System.out.println("10.List Courses per department and Semester");
		              System.out.println("11.List Courses per Student");
		            
	                  
		                  try (Scanner sc = new Scanner(System.in)) {
	                     int choice=sc.nextInt();
	                     switch(choice){
	                         case 1:
	                             try{
//	                                 System.out.print("Enter Student ID: ");
//	                               id = sc.nextInt();
	                               System.out.println("Enter First Name: ");
	                               firstname = sc.next();
	                               System.out.println("Enter Last Name: ");
	                               lastname = sc.next();
	                               System.out.println("Enter dateOfBirth: ");
	                               dateOfBirth = sc.next();
	                               
//	                        
	                               sd.setFirstName(firstname);
	                               sd.setLastname(lastname);
	                               sd.setDateOfBirth(dateOfBirth);
	                               dao.saveStudent(sd);
	                               System.out.println("Student recorded successfully!!!");
	                               
	                                        
	                                    } catch(Exception ex){
	                                        ex.printStackTrace();
	                                    }
	                             break;
	                         case 2:
	                        	  try{
		                                 System.out.print("Enter Academic Id: ");
		                              String acId=sc.next();
		                               System.out.println("Enter Academic Code: ");
		                              String acCode = sc.next();
		                               System.out.println("Enter Academic Name: ");
		                              String acName = sc.next();
		                               System.out.println("Enter Academic type(Choose:PROGRAMME, FACULTY, DEPARTMENT) ");
		                               String acType = sc.next();
		                               AcademicUnitType type =AcademicUnitType.valueOf(acType);
		                               
		                               AcademicUnit au= new AcademicUnit();
		                      	     AUDao audao = new AUDao();
		                      	     
		                      	     au.setAcademicId(acId);
		                      	     au.setAcademicCode(acCode);
		                      	     au.setAcademicName(acName);
		                      	     au.setType(type);
		                               
		                              
		                               audao.saveAcademicUnit(au);
		                              
		                               
		                                        
		                                    } catch(Exception ex){
		                                        ex.printStackTrace();
		                                    }
	                        	 break;
	                         case 3:
	                        	 try{
	                                 System.out.print("Enter Semester Id: ");
	                              String semId=sc.next();
	                               System.out.println("Enter Semester name: ");
	                              String semName = sc.next();
	                               System.out.println("Enter Starting Date Format(YYYY-MM-DD): ");
	                              String startdate = sc.next();
	                              Date stDate= (Date) new SimpleDateFormat("YYYY-MM-DD:").parse(startdate);
	                               System.out.println("Enter End date Format(YYYY-MM-DD):");
	                               String enddate = sc.next();
	                               Date endDate= (Date) new SimpleDateFormat("YYYY-MM-DD:").parse(enddate);
	                               
	                               Semester sm= new Semester();
	                      	     SemesterDao smdao = new SemesterDao();
	                      	     
	                      	     sm.setSemesterId(semId);
	                      	     sm.setSemesterName(semName);
	                      	     sm.setStartingDate(stDate);
	                      	     sm.setEndDate(endDate);
	                      	     
	                      	   smdao.saveSemester(sm);
	                              
	                               
	                                        
	                                    } catch(Exception ex){
	                                        ex.printStackTrace();
	                                    }
	                        	 break;
	                         case 4:	                        	
	                        	 try{
	                                 System.out.print("Enter Course Id: ");
	                              int courseId=sc.nextInt();
	                               System.out.println("Enter Course Code: ");
	                              String coursecode = sc.next();
	                               System.out.println("Enter course name ");
	                              String Coursename = sc.next();
	                             
	                               Course sm= new Course();
	                      	     CourseDao smdao = new CourseDao();
	                      	     
	                      	     sm.setCourseId(courseId);
	                      	     sm.setCourseCode(coursecode);
	                      	     sm.setCourseName(Coursename);
	                      	     
	                      	   smdao.saveCourse(sm);
	                           
                                 } catch(Exception ex){
                                     ex.printStackTrace();
                                 }
	                      	    break;
	         
	                         case 5:
	                        	
	                        	 try{
	                                 System.out.print("Enter Academic Id: ");
	                                 String acId=sc.next();
	                               System.out.println("Enter Academic Code: ");
	                              String acCode = sc.next();
	                               System.out.println("Enter Academic name ");
	                              String acName = sc.next();
	                              
	                              AcademicUnit au=new AcademicUnit();
	                              AcUnitDao audao=new AcUnitDao();
	                             
	                              
	                      	     
	                      	     au.setAcademicId(acId);
	                      	     au.setAcademicCode(acCode);
	                      	     au.setAcademicName(acName);
	                      	     
	                      	   audao.saveAcUnit(au);
	                           
                                 } catch(Exception ex){
                                     ex.printStackTrace();
                                 }
	                        	 
	                      	  
	                      	    break;
	                       
                             case 6:
                     		 try{
                                 System.out.print("Enter Registration Code: ");
                              String regcode=sc.next();
                               System.out.println("Enter registration Date(YYYY-MM-DD): ");
                              String regDate = sc.next();
                              Date stDate= (Date) new SimpleDateFormat("YYYY-MM-DD:").parse(regDate);
                             
                              StudentRegistration sr=new StudentRegistration();
                              StudentRegDao srdao=new StudentRegDao();
                               
                              sr.setRegistrationCode(regcode);
                              sr.setRegistrationDate(stDate);
                      	     
                              srdao.saveStudentRegistration(sr);
                      	      
                                    } catch(Exception ex){
                                        ex.printStackTrace();
                                    }
                        	 break; 
                        	 
                             case 7:
                         		 try{
                                     System.out.print("Enter First Name:");
                                  String fname=sc.next();
                                   System.out.println("Enter Last Name:");
                                  String lname = sc.next();
                                  System.out.println("Enter qualification:");
                                  String qual = sc.next();
                                  
                                  Teacher td=new Teacher();
                                  TeacherDao tdao=new TeacherDao();
                                 
                                td.setFirstName(fname);
                                td.setLastName(lname);
                                td.setQualification(qual);
                                   
                                tdao.saveTeacher(td);
                          	      
                                        } catch(Exception ex){
                                            ex.printStackTrace();
                                        }
                            	 break;
           	 
                             case 8:
                            	    try {
                            	        System.out.print("Enter Semester id:");
                            	        String semId = sc.next();
                            	        
                            	        StudentPerSemester srdao = new StudentPerSemester();
                            	        List<StudentRegistration> studentsPerSemester = srdao.getStudentsPerSemester(semId);

                            	        // Print the list of students
                            	        for (StudentRegistration registration : studentsPerSemester) {
                            	            System.out.println("Student ID: " + registration.getStudent().getStudentId());
                            	            System.out.println("Student Name: " + registration.getStudent().getFirstName() + " " + registration.getStudent().getLastname());
                            	            // Add more details if needed
                            	        }
                            	    } catch(Exception ex) {
                            	        ex.printStackTrace();
                            	    }
                            	    break;
                             case 9:
                            	    try {
                            	        System.out.print("Enter Department ID:");
                            	        String departmentId = sc.next();
                            	        System.out.print("Enter Semester ID:");
                            	        String semesterId = sc.next();
                            	        
                            	        StudPerDepSem spdsDao = new StudPerDepSem();
                            	        List<StudentRegistration> studentsPerDepartmentAndSemester = spdsDao.getStudentsPerDepartmentAndSemester(departmentId, semesterId);

                            	        // Codes to list Students
                            	        for (StudentRegistration registration : studentsPerDepartmentAndSemester) {
                            	            System.out.println("Student ID: " + registration.getStudent().getStudentId());
                            	            System.out.println("Student Name: " + registration.getStudent().getFirstName() + " " + registration.getStudent().getLastname());
                            	            
                            	        }
                            	    } catch(Exception ex) {
                            	        ex.printStackTrace();
                            	    }
                            	    break;

                             case 10:
                            	    try {
                            	        System.out.print("Enter Course Code:");
                            	        String courseCode = sc.next();
                            	        System.out.print("Enter Semester ID:");
                            	        String semesterId = sc.next();
                            	        
                            	        StudPerCourseSem spcsDao = new StudPerCourseSem();
                            	        List<StudentRegistration> studentsPerCourseAndSemester = spcsDao.getStudentsPerCourseAndSemester(courseCode, semesterId);

                            	        // Print the list of students
                            	        for (StudentRegistration registration : studentsPerCourseAndSemester) {
                            	            System.out.println("Student ID: " + registration.getStudent().getStudentId());
                            	            System.out.println("Student Name: " + registration.getStudent().getFirstName() + " " + registration.getStudent().getLastname());
                            	           
                            	        }
                            	    } catch(Exception ex) {
                            	        ex.printStackTrace();
                            	    }
                            	    break;
                             case 11:
                            	    try {
                            	        System.out.print("Enter Department ID:");
                            	        String departmentId = sc.next();
                            	        System.out.print("Enter Semester ID:");
                            	        String semesterId = sc.next();
                            	        
                            	        CoursPerDepSem cpdsDao = new CoursPerDepSem();
                            	        List<Course> coursesPerDepartmentAndSemester = cpdsDao.getCoursesPerDepartmentAndSemester(departmentId, semesterId);

                            	        // Printing the list of courses per department and semester
                            	        for (Course course : coursesPerDepartmentAndSemester) {
                            	            System.out.println("Course ID: " + course.getCourseId());
                            	            System.out.println("Course Code: " + course.getCourseCode());
                            	            System.out.println("Course Name: " + course.getCourseName());
                            	           
                            	        }
                            	    } catch(Exception ex) {
                            	        ex.printStackTrace();
                            	    }
                            	    break;
                            
                             case 12:
                            	    try {
                            	        System.out.print("Enter Student ID:");
                            	        int studentId = sc.nextInt();
                            	        
                            	        CoursPerStud cpsDao = new CoursPerStud();
                            	        List<Course> coursesPerStudent = cpsDao.getCoursesPerStudent(studentId);

                            	        // Print the list of courses per student
                            	        for (Course course : coursesPerStudent) {
                            	            System.out.println("Course ID: " + course.getCourseId());
                            	            System.out.println("Course Code: " + course.getCourseCode());
                            	            System.out.println("Course Name: " + course.getCourseName());
                            	           
                            	        }
                            	    } catch(Exception ex) {
                            	        ex.printStackTrace();
                            	    }
                            	    break;


                             

	                     
}}}}}
	

