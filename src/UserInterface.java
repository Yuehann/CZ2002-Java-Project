import java.util.Scanner;

public class UserInterface {
	
	public static void main(String[] args) {
		
		int choice;
		
		System.out.println("Please select which function to inplement:\n\n"+
		                   "1. Register student to a course.\n"+
		                   "2. Check vacancy available for a course index.\n");
		
		
		do {
			Scanner sc = new Scanner(System.in);
		    choice = sc.nextInt();
		
		    switch(choice) {
		    case 1:
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
			    
		    case 2:
		    	System.out.printf("Course Index:");
			    Integer index_vacy = sc.nextInt();
			    Integer vacancy = checkVacancyAvailable(index_vacy);
		    }
		
		}while(choice!=-1);

	}
	
	public static Integer checkVacancyAvailable(Integer index) {
		
		
		return 0;
	}
	
	public static boolean regiStuToCou(String studentId, String courseId) {
		
		
		
		return true;
	}
}

