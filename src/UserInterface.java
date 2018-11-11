import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.ClassNotFoundException;
import java.io.Serializable;

// ---------->  All kinds of checks, use EXEPTION ??????????????

public class UserInterface implements Serializable {
	
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
		                   "Enter 0 to exit the course registration system.");
		
		
		do {
			System.out.printf("\nYour choice is: ");
			Scanner sc = new Scanner(System.in);
		    choice = sc.nextInt();
		
		    switch(choice) {
// Case 1: Add a student ======================================================================================================= 
		    case 1:
		    	System.out.printf("\n< Add a student >\n");
		    	System.out.printf("\nPlease enter the student information \n");
		    	System.out.printf("  Student ID: ");
			    String studentId_add = sc.next();
			    sc.nextLine();
			    System.out.printf("  Student Name: ");
			    String studentName_add = sc.nextLine();
			    System.out.printf("  Gender: ");
			    char gender_add = sc.next().charAt(0);
			    System.out.printf("  Nationality: ");
			    String nationality_add = sc.next();
			    System.out.printf("  School: ");
			    String schoolStu_add = sc.next();
			    System.out.printf("  Year: ");
			    Integer year_add = sc.nextInt();

			    boolean added_stu = addStudents(studentId_add, studentName_add, gender_add, nationality_add, 
						schoolStu_add, year_add);
			    if(added_stu)
			    	System.out.printf("\nStudent successfully added!\n");
			    else
			    	System.out.printf("Adding student failed, please check the information and try again.");
			    break;
// Case 2: Add a course ========================================================================================================
		    case 2:
		    	System.out.printf("\n< Add a course >\n");
		    	System.out.printf("\nPlease enter the course information \n");
		    	
		    	System.out.printf("  Course ID: ");
			    String courseId_add = sc.next();
			    sc.nextLine();
			    System.out.printf("  Course Name: ");
			    String courseName_add = sc.nextLine();
			    System.out.printf("  AU Credits: ");
			    Integer AUCredits_add = sc.nextInt();
			    sc.nextLine();
			    System.out.printf("  School: ");
			    String schoolCou_add = sc.nextLine();
			    
			    System.out.printf("  Number of course index: ");
				Integer indexListSize_add = sc.nextInt();
				ArrayList<Integer> indexList_add = new ArrayList<Integer>(indexListSize_add);
				for(int i=0; i<indexListSize_add;i++) {
				System.out.printf("    Index "+(i+1)+": ");
				indexList_add.add(sc.nextInt());
				}
				
				// lack the input of courseStructure(weightage), will be implemented in case 6.
				
			    System.out.println("  Course Component (Lecture, Tutorial, Lab): ");
			    System.out.printf("    This course has Lecture session? (Please enter Yes if it has, No if not) ");
			    boolean lec_add;
			    if(sc.next().equals("Yes"))
			    	lec_add = true;
			    else
			    	lec_add = false;
			    System.out.printf("    This course has Tutorial session? (Please enter Yes if it has, No if not) ");
			    boolean tut_add;
			    if(sc.next().equals("Yes"))
			    	tut_add = true;
			    else
			    	tut_add = false;
			    System.out.printf("    This course has Lab session? (Please enter Yes if it has, No if not) ");
			    boolean lab_add;
			    if(sc.next().equals("Yes"))
			    	lab_add = true;
			    else
			    	lab_add = false;
			    //System.out.printf(""+lec_add+tut_add+lab_add); 
			    boolean added_cou = addCourse(courseId_add, courseName_add, AUCredits_add, schoolCou_add, indexList_add, lec_add, tut_add, lab_add);
			    if(added_cou)
			    	System.out.printf("\nCourse successfully added!\n");
			    else
			    	System.out.printf("Adding course failed, please check the information and try again.");
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
	public static void printresult(File f) throws IOException, ClassNotFoundException {
		FileInputStream fi=new FileInputStream(f);
		ObjectInputStream oi=new ObjectInputStream(fi);
		ArrayList<Object> temp=new ArrayList<Object>();
		if (fi.available()>0)
		{while (fi.available()>0) {
			temp.add(oi.readObject());
		}
		for(int i=0;i<temp.size();i++) {
			System.out.println(((CourseIndex)(temp.get(i))).toString());
		}
		oi.close();}
		else System.out.println("empty file");
	}
	
	
	
	//  Case 1: Add a student 
	public static boolean addStudents(String studentId_add, String studentName_add, char gender_add, String nationality_add, 
			String school_add, Integer year_add) {
		
		// Create a new student object?? then add into file Students?? 
		SerializeFile sw=new SerializeFile("student1.txt");
		Students newStudent = new Students(studentId_add, studentName_add, gender_add, nationality_add, school_add, year_add);
		boolean added = sw.appendNew(newStudent);

		return added;
	}
	
	
//  Case 2: Add a course	
	public static boolean addCourse(String courseId_add, String courseName_add, Integer AUCredits_add, String schoolCou_add, ArrayList<Integer> indexGroupList_add, 
			boolean lec_add, boolean tut_add, boolean lab_add) {
		
		// Create a new course object?? then add into file Course??    ?????????/ should the infor about list, structure be completed??
		// Create a component first ->
		SerializeFile sw=new SerializeFile("course1.txt");
		CourseComponent component_add = new CourseComponent(lec_add, tut_add, lab_add);
		Course newCourse = new Course(courseId_add, courseName_add, AUCredits_add, schoolCou_add, indexGroupList_add, component_add);
		boolean added = sw.appendNew(newCourse);
		
		return added;		
//????		return true;
	}
	
	
//	Case 3: Register student for a course (include registering for Tutorial/Lab)
	public static boolean regiStuToCou(String studentId_regi, String courseId_regi) {
		
		Scanner sc = new Scanner(System.in);
		SerializeFile sw_cou = new SerializeFile("course1.txt");
		SerializeFile sw_stu = new SerializeFile("student1.txt");
		SerializeFile sw_ind = new SerializeFile("index1.txt");
//???????????????????????????????????????????????????????????????????????????????????//		
		Students studentregi_obj = (Students) sw_stu.read(studentId_regi, 's');
		System.out.printf(""+studentregi_obj);
		Course regi_course = (Course) sw_cou.read(courseId_regi, 'c'); 
		System.out.printf(""+regi_course);

		regi_course.viewIndexGroupList();                   

		do {
			System.out.printf("Please enter the index you want to register: ");		
			Integer regi_index = sc.nextInt();
			Integer regi_vacancy = checkVacancyAvailable(regi_index);	
			CourseIndex indexregi_obj = (CourseIndex) sw_ind.read(regi_index.toString(), 'i');  
			if(regi_vacancy!=-1) { 		                               // if (has vacancy) -> register (add record to corresponding files + update vacancy...)
				indexregi_obj.addStuToStuList(studentId_regi);  
				// sw_ind.fillArray(); ??????????????????????
				studentregi_obj.addIndexToIndexList(regi_index);
				
				indexregi_obj.updateVacancy();
				System.out.println("the updated vacancy is "+indexregi_obj.getVacancy());
				sw_ind.writeArray();
				sw_stu.writeArray();
			}
			else {                                   
//		 prompts Admin to choose 1. choose another index to check vacancy (just keep on the do while loop?)
//                               2. put into waitlist for this index (update file: waitlist)-> return false + words (exit loop)
//                               3. just exit (do not register for this course) -> return false + words (exit loop)
				System.out.println("Do you choose to:"+
			                       "  1. select another index to check vacancy."+
						           "  2. add into the waitlist for this index."+
			                       "  3. exit this registration.");
				System.out.printf("\n  Your choice is: ");
				int choice_regi = sc.nextInt();
				switch(choice_regi) {
				case 1:
					break;
				case 2:
					indexregi_obj.addToWaitlist(studentId_regi);
					studentregi_obj.addIndexToWaitlsit(regi_index);
					System.out.println("The student "+studentId_regi+" is added into waitlist for index "+regi_index);
					sw_ind.writeArray();
					sw_stu.writeArray();
					return false;
				case 3:
					System.out.println("Exit this registration.");
					return false;
				default:
					System.out.println("There is no this option.");
					return false;
				}
			}

		}while(true);
	
	}
	
	
//  Case 4: Check available slot in a class (vacancy in a class)
	public static Integer checkVacancyAvailable(Integer index_vacy) {
		
		                                                         // search to get the CourseIndex object by index_vacy
		SerializeFile sw=new SerializeFile("index1.txt");
		CourseIndex index_obj = (CourseIndex) sw.read(index_vacy.toString(), 'i');
		                                                         // object.getVacancy() return the vacancy available in that class
		Integer vacancy = index_obj.getVacancy();
		if(vacancy>0) {
			System.out.println("The vacancy available for index "+index_vacy+" is "+vacancy);
		    return vacancy;
		    }
		else {
			System.out.println("There is no vacancy available for index "+index_vacy);
			return -1;
			}
		
	}
	
	
//  Case 5: Print student list by lecture, tutorial or laboratory session for a course
	public static void printStuListByTutLab(Integer index_prinStuList) {
		
		System.out.println("Student list for tutotial or laboratory session");
		// search the CourseIndex object by this index_prinStuList from file CourseIndex
		SerializeFile sw=new SerializeFile("index1.txt");
		CourseIndex index_obj = (CourseIndex) sw.read(index_prinStuList.toString(), 'i');
		// object.getStudentList() -> get all student name/Id ?? in this index group i.e. lab/tutorial
		index_obj.printStudentList();
		// traverse and print the studentList
	}
	
	public static void printStuListByLec(String courseId_prinStuList) {
		
		System.out.println("Student list for lecture session");
		// search the Course object by this courseId_prinStuList from file Course
		SerializeFile sw_cou = new SerializeFile("course1.txt");
		SerializeFile sw_ind = new SerializeFile("index1.txt");
		Course course_obj = (Course) sw_cou.read(courseId_prinStuList, 'i');
		// object.getindexGroupList() -> get all index group belonging to this Course
		// for each index, call printStudentListByTutLab()?? 	
		for(int i=0; i<course_obj.getIndexGroupList().size(); i++) {
			CourseIndex index_obj = (CourseIndex) sw_ind.read(course_obj.getIndexGroupList().get(i).toString(),'i');
			index_obj.printStudentList();
		}	
	}
	
	
//  Case 6: Enter course assessment components weightage
	public static boolean enterCompoWeightage(double finalExam_entr, double quiz_entr, double assignment_entr, 
			double project_entr, double participation_entr) {
		
		// LOOP: (while (true) ?)                        
		// do a check of whether all entering added == 1 (100%)
		// if == 1 ->
		// find a Course object, object.addCouStructure()
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

