import java.util.Scanner;

public class UserInterface {
	
	public static void main(String[] args) {
		
		int choice;
		
		System.out.println("Please select which function to inplement:"+
		                   "1. Register student to a course.");
		
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.printf("Student ID:");
			String studentId = sc.nextLine();
			System.out.printf("Course ID:");
			String courseId = sc.nextLine();
			boolean task = regiStuToCou(studentId, courseId);
			if(task)
				System.out.println("Successfully registered!");
			else
				System.out.printf("Registration failed, "
						+ "please check the information and try again.\n");
			break;
		}

	}
	
	public boolean regiStuToCou(String studentId, String courseId) {
		
		return true;
	}
}

