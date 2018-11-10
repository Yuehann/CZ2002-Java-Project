import java.util.ArrayList;
import java.util.Scanner;

// ---------->  All kinds of checks, use EXEPTION ??????????????

public class UserInterface {
	
//	public static int stuNo;   Need this for adding file or not?
	
	public static void main(String[] args) {
		
		int choice;
		
		System.out.println("Please select which function to implement:\n\n"+
		                   "1.  Add a student.\n"+
				           "2.  Add a course.\n"+
		                   "3.  Register student for a course (include registering for Tutorial/Lab).\n"+
		                   "4.  Check available slot in a class (vacancy in a class).\n"+
		                   "5.  Print student list by lecture, tutorial or laboratory session for a course.\n"+
		                   "6.  Enter course assessment components weightage.\n"+
		                   "7.  Enter coursework mark - inclusive of its components.\n"+
		                   "8.  Enter exam mark.\n"+
		                   "9.  Print course statistics.\n"+
		                   "10. Print student transcript.\n\n"+
		                   "Enter 0 to exit the course registration system.\n");
		System.out.printf("Your choice is: ");
		
		
		do {
			Scanner sc = new Scanner(System.in);
		    choice = sc.nextInt();
		
		    switch(choice) {
// Case 1: Add a student ======================================================================================================= 
		    case 1:
		    	System.out.printf("\n< Add a student >\n");
		    	System.out.printf("\nPlease enter the student information \n");
		    	System.out.printf("  Student ID: ");
			    String studentId_add = sc.next();
			    System.out.printf("  Student Name: ");
			    String studentName_add = sc.next();
			    System.out.printf("  Gender: ");
			    char gender_add = sc.next().charAt(0);
			    System.out.printf("  Nationality: ");
			    String nationality_add = sc.next();
			    System.out.printf("  School: ");
			    String school_add = sc.next();
			    System.out.printf("  Year: ");
			    Integer year_add = sc.nextInt();

			    boolean added = addStudents(studentId_add, studentName_add, gender_add, nationality_add, 
						school_add, year_add);
			    if(added)
			    	System.out.printf("\nStudent successfully added!\n");
			    else
			    	System.out.printf("Adding student failed, please check the information and try again.");
			    break;
// Case 2: Add a course ========================================================================================================
		    case 2:
		    	System.out.printf("\n< Add a course >\n");
		    	System.out.printf("\nPlease enter the course information \n");
		    	// The same implementation as case 1 -- add a student ?
		    	break;
// Case 3: Register student for a course (include registering for Tutorial/Lab) ================================================
		    case 3:
		    	System.out.printf("\n< Register student for a course (include registering for Tutorial/Lab) >\n");
		    	System.out.printf("\nStudent ID:");
			    String studentId_regi = sc.next();
			    System.out.printf("Course ID:");
			    String courseId_regi = sc.next();
			    boolean task = regiStuToCou(studentId_regi, courseId_regi);
			    if(task)
			    	System.out.printf("Successfully registered!\n"+
			                          "Student "+studentId_regi+" is registered in course "+courseId_regi+".");
			    else
				    System.out.printf("Registration failed, "+
			                          "please check the information and try again.\n");
			    break;
// Case 4: Check available slot in a class (vacancy in a class)	================================================================
		    case 4:
		    	System.out.printf("\n< Check available slot in a class (vacancy in a class) >\n");
		    	System.out.printf("Course Index:");
			    Integer index_vacy = sc.nextInt();
			    Integer vacancy = checkVacancyAvailable(index_vacy);
			    if(vacancy>0)
			    	System.out.printf("Vacancy checked!\n"+
			                          "Vacancy available for course index "+index_vacy+" is "+vacancy+".");
			    else
			    	System.out.println("There currently is no vacancy available for course index "+index_vacy+".");
			    break;
// Case 5: Print student list by lecture, tutorial or laboratory session for a course ==========================================
		    case 5:
		    	System.out.printf("\n< Print student list by lecture, tutorial or laboratory session for a course >\n");
                System.out.printf("\nPlease select printing student list by which session:\n"+
		    	                  "a. lecture session\n" + "b. tutorial/lab session\n"+"\nYour choice is: ");
                char choice_print = sc.next().charAt(0);
		    	
                switch(choice_print) {
		    	case 'a':
			    	System.out.printf("Please enter the Course ID for printing the Student List by lecture session: ");
			    	String courseId_prinStuList = sc.next();
			    	printStuListByLec(courseId_prinStuList);
			    	break;
		    	case 'b':
		    		System.out.printf("Please enter the Course Index for printing the Student List by tutorial/lab session: ");
		    		Integer index_prinStuList = sc.nextInt();
		    		printStuListByTutLab(index_prinStuList);
		    		break;
		    	default:
		    		break;
		    	}
		  
		    	break;
// Case 6: Enter course assessment components weightage ========================================================================
		    case 6:
		    	System.out.printf("\n< Enter course assessment components weightage >\n");
		    	System.out.printf("\nPlease enter course assessment component weightage:\n");
		    	System.out.printf("  Final Exam Weightage: ");
		    	double finalExam_entr = sc.nextDouble();
		    	System.out.printf("  Quiz Exam Weightage: ");
		    	double quiz_entr = sc.nextDouble();
		    	System.out.printf("  Assignment Weightage: ");
		    	double assignment_entr = sc.nextDouble();
		    	System.out.printf("  Project Weightage: ");
		    	double project_entr = sc.nextDouble();
		    	System.out.printf("  Participation Weightage: ");
		    	double participation_entr = sc.nextDouble();
		    	boolean entered = enterCompoWeightage(finalExam_entr, quiz_entr, assignment_entr, 
		    			project_entr, participation_entr);
		    	if(entered)
		    		System.out.println("The course assessment components weightage are successfully entered!"+
		    	                       "\n  Final Exam: "+finalExam_entr+"\n  Quiz: "+quiz_entr+"\n  Assignment: "+assignment_entr+
		    	                       "\n  Project: "+project_entr+"\n  Participation: "+participation_entr);
		    	else
		    		System.out.println("The entering failed, please check the information and try again.");
		    	break;
// Case 7: Enter coursework mark - inclusive of its components =================================================================
		    case 7:
		    	
		    	break;
// Case 8: Enter exam mark =====================================================================================================
		    case 8:
		    	
		    	break;
// Case 9: Print course statistics =============================================================================================
		    case 9:
		    	
		    	break;
// Case 10: Print student transcript =========================================================================================== 
		    case 10:
		    	
		    	break;
// Case EXIT & DEFAULT =========================================================================================================
		    case -1:
		    	break;
		    default:
		    	break;
		    }
		
		}while(choice!=-1);

	}

/*----------------------------------------- UserInterface Methods ---------------------------------------------*/
//  Case 1: Add a student 
	public static boolean addStudents(String studentId_add, String studentName_add, char gender_add, String nationality_add, 
			String school_add, Integer year_add) {
		
		// Create a new student object?? then add into file Students?? 
		
		Students newStudent = new Students(studentId_add, studentName_add, gender_add, nationality_add, school_add, year_add);
		
		
		return true;
	}
	
	
//  Case 2: Add a course	
	public static boolean addCourse(String courseID, String courseName, Integer AUCredits, String school, ArrayList<Integer> indexGroupList, 
			CourseStructure structure, CourseComponent component) {
		
		// Create a new course object?? then add into file Course??
		
		return true;
	}
	
	
//	Case 3: Register student for a course (include registering for Tutorial/Lab)
	public static boolean regiStuToCou(String studentId_regi, String courseId_regi) {
		
		// search to get the Course object by courseId
		// System.out.println()...all indexGroupList for this course object
		// DO WHILE LOOP:(true?)
		// Prompts Admin to input an index wanted
		// checkVacancyAvailable(index) -> tell whether can register or not
		// get the index object by searching db
		// if (has vacancy) -> register (add record to corresponding files + update vacancy...)
		// else (no vacancy) -> 
		//       prompts Admin to choose 1. choose another index to check vacancy (just keep on the do while loop?)
		//                               2. put into waitlist for this index (update file: waitlist)-> return false + words (exit loop)
		//                               3. just exit (do not register for this course) -> return false + words (exit loop)
		
		return true;
	}
	
	
//  Case 4: Check available slot in a class (vacancy in a class)
	public static Integer checkVacancyAvailable(Integer index_vacy) {
		
		// search to get the CourseIndex object by index_vacy
		// object.getVacancy() return the vacancy available in that class
		
		return 0;
	}
	
	
//  Case 5: Print student list by lecture, tutorial or laboratory session for a course
	public static void printStuListByTutLab(Integer index_prinStuList) {
		
		System.out.println("Student list for tutotial or laboratory session");
		// search the CourseIndex object by this index_prinStuList from file CourseIndex
		// object.getStudentList() -> get all student name/Id ?? in this index group i.e. lab/tutorial
		// traverse and print the studentList
	}
	
	public static void printStuListByLec(String courseId_prinStuList) {
		
		System.out.println("Student list for lecture session");
		// search the Course object by this courseId_prinStuList from file Course
		// object.getindexGroupList() -> get all index group belonging to this Course
		// for each index, call printStudentListByTutLab()?? 		
	}
	
	
//  Case 6: Enter course assessment components weightage
	public static boolean enterCompoWeightage(double finalExam_entr, double quiz_entr, double assignment_entr, 
			double project_entr, double participation_entr) {
		
		// LOOP: (while (true) ?)                        
		// do a check of whether all entering added == 1 (100%)
		// if == 1 ->
		// create a CourseStructure object, set all attributes
		// store the new object to the file Course->CourseComponent ??  -> EXIT LOOP
		// else ->  prompts to re-enter ?? () -> keep on LOOP ?
		//      ->  user choose to exit -> return false
		return true;
	}
	
	
//  Case 7: Enter coursework mark - inclusive of its components
	public static boolean enterCouWorkMark(String studentid, String courseid, String semYr, double finalExamGrd, 
			double quizGrd, double assignmentGrd, double projectGrd, double participationGrd) {
		
		// ????????????? depends on how we implement the StuCouGrade entity class, i.e. how we store this file ?????????????
		
		return true;
	}
	
	
//  Case 8: Enter exam mark
	public static boolean enterExamMark() {
		
		// ????????????? a part of coursework mark ????????????????//
		
		return true;
	}
//  Case 9: Print course statistics (coursePerformance)   //??????????????? StuCouGrade Class related ????????????????????//
	public static void printCouStatistics() {
		
	}
//  Case 10: Print student transcript
	public static void printTranscript() {
		
	}
}

