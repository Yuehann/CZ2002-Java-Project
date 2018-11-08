import java.util.Scanner;

public class UserInterface {
	
	public static void main(String[] args) {
		
		int choice;
		
		System.out.println("Please select which function to implement:\n\n"+
		                   "1.  Add a student.\n"+
				           "2.  Add a course.\n"+
		                   "3.  Register student for a course (include registering for Tutarial/Lab).\n"+
		                   "4.  Check available slot in a class (vacancy in a class).\n"+
		                   "5.  Print student list by lecture, tutorial or laboratory session for a course.\n"+
		                   "6.  Enter course assessment components weightage.\n"+
		                   "7.  Enter coursework mark - inclusive of its components.\n"+
		                   "8.  Enter exam mark.\n"+
		                   "9.  Print course statistics.\n"+
		                   "10. Print student transcript.\n\n"+
		                   "Enter 0 to exit the course registration system.\n");
		System.out.println("Your choice is: ");
		
		
		do {
			Scanner sc = new Scanner(System.in);
		    choice = sc.nextInt();
		
		    switch(choice) {
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
         /*---------------------------------------------------------------------------------------------------- */				    
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
		 /*---------------------------------------------------------------------------------------------------- */
		    case -1:
		    	break;
		    default:
		    	break;
		    }
		
		}while(choice!=-1);

	}
	
	public static Integer checkVacancyAvailable(Integer index_vacy) {
		
		
		return 0;
	}
	
	public static boolean regiStuToCou(String studentId_regi, String courseId_regi) {
		
		// search to get the course object by courseId
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
}

