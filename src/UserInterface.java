import java.util.ArrayList;
import java.util.Scanner;

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
// Case 1: Add a student 
		    case 1:
		    	System.out.printf("\nAdd a student - Please enter the student information \n");
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
			    System.out.printf("  Number of course index: ");
			    Integer indexListSize_add = sc.nextInt();
			    ArrayList<Integer> indexList_add = new ArrayList<Integer>(indexListSize_add);
				for(int i=0; i<indexListSize_add;i++) {
					System.out.printf("    Index "+(i+1)+": ");
					indexList_add.add(sc.nextInt());
				}
			    boolean added = addStudents(studentId_add, studentName_add, gender_add, nationality_add, 
						school_add, year_add, indexList_add);
			    if(added)
			    	System.out.printf("\nStudent successfully added!\n");
			    else
			    	System.out.printf("Adding student failed, please check the information and try again.");
			    break;
// Case 2: Add a course 
		    case 2:
		    	// The same implementation as case 1 -- add a student ?
		    	break;
// Case 3: Register student for a course (include registering for Tutorial/Lab) 
		    case 3:
		    	System.out.printf("Student ID:");
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
// Case 4: Check available slot in a class (vacancy in a class)	
		    case 4:
		    	System.out.printf("Course Index:");
			    Integer index_vacy = sc.nextInt();
			    Integer vacancy = checkVacancyAvailable(index_vacy);
			    if(vacancy>0)
			    	System.out.printf("Vacancy checked!\n"+
			                          "Vacancy available for course index "+index_vacy+" is "+vacancy+".");
			    else
			    	System.out.println("There currently is no vacancy available for course index "+index_vacy+".");
			    break;
// Case 5: Print student list by lecture, tutorial or laboratory session for a course 
		    case 5:
		    	
		    	break;
// Case 6: Enter course assessment components weightage 
		    case 6:
		    	
		    	break;
// Case 7: Enter coursework mark - inclusive of its components 
		    case 7:
		    	
		    	break;
// Case 8: Enter exam mark 
		    case 8:
		    	
		    	break;
// Case 9: Print course statistics 
		    case 9:
		    	
		    	break;
// Case 10: Print student transcript 
		    case 10:
		    	
		    	break;
// Case EXIT & DEFAULT 
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
			String school_add, Integer year_add, ArrayList<Integer> indexList_add) {
		
		// Create a new student object?? then add into file Students?? 
 
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
		// if (has vacancy) -> register (add record to corresponding files)
		// else (no vacancy) -> 
		//       prompts Admin to choose 1. choose another index to check vacancy (just keep on the do while loop?)
		//                               2. put into waitlist for this index -> return false + words (exit loop)
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
	public static void enterCompoWeightage() {
		
	}
	
	
//  Case 7: Enter coursework mark - inclusive of its components
//  Case 8: Enter exam mark
//  Case 9: Print course statistics
//  Case 10: Print student transcript
}

