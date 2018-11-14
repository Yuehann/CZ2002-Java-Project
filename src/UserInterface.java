import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class UserInterface {
	int checkbit=0;
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Scanner sc =new Scanner(System.in);
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
	choice = sc.nextInt();

 switch(choice) {
//Case 1: Add a student ======================================================================================================= 
 case 1:
 	System.out.printf("\n< Add a student >\n");
 	System.out.printf("\nPlease enter the student information \n");
 	System.out.printf("  Student ID: ");
	    String studentId_add = sc.next().toUpperCase();
	    	if (checkexists(studentId_add,"student.txt")) {
	    		System.out.println("Student already exists!");
	    		break;
	    	} 
	    	sc.nextLine();
	    System.out.printf("  Student Name: ");
	    String studentName_add = sc.nextLine().toUpperCase();
	    char gender_add;
	    do {
	    System.out.print("  Gender: ");
	    gender_add = sc.next().toUpperCase().charAt(0);
	    	if (gender_add!='M'&&gender_add!='F') {
	    		System.out.println("Invalid gender!");
	    	}
	    	}while(gender_add!='M'&&gender_add!='F');
	    
	    System.out.printf("  Nationality: ");
	    String nationality_add = sc.next().toUpperCase();
	    System.out.printf("  School: ");
	    String schoolStu_add = sc.next().toUpperCase();
	    System.out.printf("  Year: ");
	    Integer year_add = sc.nextInt();

	    boolean added_stu = addStudents(studentId_add, studentName_add, gender_add, nationality_add, 
				schoolStu_add, year_add);
	    if(added_stu) {
	    	System.out.printf("\nStudent successfully added!\n");
	    	System.out.println("Here's the total list: ");
	    	printStudentList();
	    }
	    else
	    	System.out.printf("Adding student failed, please check the information and try again.");
	    break;
//Case 2: Add a course ========================================================================================================
 case 2:
	 int indexsc;
 	System.out.printf("\n< Add a course >\n");
 	System.out.printf("\nPlease enter the course information \n");
 	
 	System.out.println("  Course ID: ");
	    String courseId_add = sc.next().toUpperCase();
    	if (checkexists(courseId_add,"course.txt")) {
    		System.out.println("Course already exists!");
    		break;
    	} 
    	sc.nextLine();
	    System.out.printf("  Course Name: ");
	    String courseName_add = sc.nextLine().toUpperCase();
	    Integer AUCredits_add;
	    do {
	    System.out.printf("  AU Credits (smaller than 5): ");
	    AUCredits_add = sc.nextInt();
	    	if ((AUCredits_add)>=5||AUCredits_add<=0) {
	    		System.out.println("Invalid AUCredit entry!");
	    	}}while(AUCredits_add>=5||AUCredits_add<=0);
	    
	    sc.nextLine();
	    System.out.printf("  School: ");
	    String schoolCou_add = sc.nextLine().toUpperCase();
	    
	    System.out.printf("  Number of course index: ");
		Integer indexListSize_add = sc.nextInt();
			if (indexListSize_add<0) {
				System.out.println("Invalid indexlist size entry!");
				break;
			}
		ArrayList<Integer> indexList_add = new ArrayList<Integer>(indexListSize_add);
		for(int i=0; i<indexListSize_add;i++) {
		System.out.printf("    Index "+(i+1)+": ");
		indexsc=sc.nextInt();
		if (indexsc<=0) i--;
		else indexList_add.add(indexsc);
		}
		
		// lack the input of courseStructure(weightage), will be implemented in case 6.
		
	    System.out.println("  Course Component (Lecture, Tutorial, Lab): ");
	    System.out.printf("    This course has Lecture session? (Please enter Yes if it has, No if not) ");
	    boolean lec_add;
	    if(sc.next().toUpperCase().equals("YES"))
	    	lec_add = true;
	    else
	    	lec_add = false;
	    System.out.printf("    This course has Tutorial session? (Please enter Yes if it has, No if not) ");
	    boolean tut_add;
	    if(sc.next().toUpperCase().equals("YES"))
	    	tut_add = true;
	    else
	    	tut_add = false;
	    System.out.printf("    This course has Lab session? (Please enter Yes if it has, No if not) ");
	    boolean lab_add;
	    if(sc.next().toUpperCase().equals("YES"))
	    	lab_add = true;
	    else
	    	lab_add = false;
	    //System.out.printf(""+lec_add+tut_add+lab_add); 
	    boolean added_cou = addCourse(courseId_add, courseName_add, AUCredits_add, schoolCou_add, indexList_add, lec_add, tut_add, lab_add);
	    if(added_cou) {
	    	System.out.printf("\nCourse successfully added!\n");
	    	System.out.println("Here's the current course list: ");
	    	printCourseList();
	    	}
	    else
	    	System.out.printf("Adding course failed, please check the information and try again.");
 	break;
//Case 3: Register student for a course (include registering for Tutorial/Lab) ================================================
 case 3:
 	System.out.printf("\n< Register student for a course (include registering for Tutorial/Lab) >\n");
 	System.out.printf("\nStudent ID:");
	    String studentId_regi = sc.next().toUpperCase();
	    if (!checkexists(studentId_regi,"student.txt")) {
	    	System.out.println("Student doesnt exist.");
	    	break;}
	    System.out.printf("Course ID:");
	    String courseId_regi = sc.next().toUpperCase();
	    if (!checkexists(courseId_regi,"course.txt")) {
	    	System.out.println("Course doesnt exist.");
	    	break;}
	    boolean task = regiStuToCou(studentId_regi, courseId_regi);
	    if(task)
	    	System.out.printf("Successfully registered!\n"+
	                          "Student "+studentId_regi+" is registered in course "+courseId_regi+".");
	    else
		    System.out.printf("Registration failed, "+
	                          "please check the information and try again.\n");
	    break;
//Case 4: Check available slot in a class (vacancy in a class)	================================================================
 case 4:
 	System.out.printf("\n< Check available slot in a class (vacancy in a class) >\n");
 	System.out.printf("Course Index:");
	    Integer index_vacy = sc.nextInt();
	    if (!checkexists(String.valueOf(index_vacy),"index.txt")) {
	    	System.out.println("Index doesnt exist!");
	    	break;
	    }
	    Integer vacancy = checkVacancyAvailable(index_vacy);
	    if(vacancy>0)
	    	System.out.printf("Vacancy checked!\n"+
	                          "Vacancy available for course index "+index_vacy+" is "+vacancy+".");
	    else
	    	System.out.println("There currently is no vacancy available for course index "+index_vacy+".");
	    break;
//Case 5: Print student list by lecture, tutorial or laboratory session for a course ==========================================
 case 5:
 	System.out.printf("\n< Print student list by lecture, tutorial or laboratory session for a course >\n");
     System.out.printf("\nPlease select printing student list by which session:\n"+
 	                  "a. lecture session\n" + "b. tutorial/lab session\n"+"\nYour choice is: ");
     char choice_print = sc.next().toUpperCase().charAt(0);
     if (choice_print!='A'&&choice_print!='B') {
    	 System.out.println("Invalid choice!");
    	 break;
     }
 	
     switch(choice_print) {
 	case 'A':
	    	System.out.printf("Please enter the Course ID for printing the Student List by lecture session: ");
	    	String courseId_prinStuList = sc.next().toUpperCase();
	    	if (!checkexists(courseId_prinStuList,"course.txt")) {
	    		System.out.println("Course doesnt exist!");
	    		break;
	    	} 
	    	printStuListByLec(courseId_prinStuList);
	    	break;
 	case 'B':
 		System.out.printf("Please enter the Course Index for printing the Student List by tutorial/lab session: ");
 		Integer index_prinStuList = sc.nextInt();
    	if (!checkexists(String.valueOf(index_prinStuList),"index.txt")) {
    		System.out.println("Index doesnt exist!");
    		break;
    	} 
 		printStuListByTutLab(index_prinStuList);
 		break;
 	default:
 		break;
 	}

 	break;
//Case 6: Enter course assessment components weightage ========================================================================
 case 6:
	 String component_course_id;
 	System.out.printf("\n< Change course assessment components weightage >\n");
 	
 	do{
 		System.out.println("Enter the courseid: ");
 	    component_course_id=sc.next().toUpperCase();
 	if (!checkexists(component_course_id,"course.txt")) {
 		System.out.println("Course doesnt exist!");
 	}}while(!checkexists(component_course_id,"course.txt"));
 	
 	double finalExam_entr;
 	double assignment_entr=0.0;
 	double coursework_entr;
 	double participation_entr=0.0;
 	
 	System.out.printf("\nPlease enter course assessment component weightage:\n");
 	System.out.printf("  Final Exam Weightage: ");
 		do{
 			finalExam_entr = sc.nextDouble();
 			if(finalExam_entr<0||finalExam_entr>1) System.out.println("Invalid entry!");
 		}while(finalExam_entr<0||finalExam_entr>1); 
 	System.out.printf("  Coursework Exam Weightage: ");
    coursework_entr = 1-finalExam_entr;
 	System.out.print(coursework_entr);
 	System.out.printf("\n");
		
	if (coursework_entr>1e-6) {
		System.out.println("  Continue for sub-cnponents?");
		char check_continue=sc.next().toUpperCase().charAt(0);
		switch (check_continue) {
		case 'Y':
		 	System.out.printf("  Assignment Weightage in coursework: ");
	 		do{
	 			assignment_entr = sc.nextDouble();
	 			if(assignment_entr<0||assignment_entr>1) System.out.println("Invalid entry!");
	 		}while(assignment_entr<0||assignment_entr>1); 
		 	System.out.printf("  Participation Weightage in coursework: ");
		 	participation_entr = 1-assignment_entr;
		 	System.out.print(participation_entr);
		 	System.out.printf("\n");
		 	break;
		case 'N':
			break;
		}
		}
		boolean entered = enterCompoWeightage(component_course_id,finalExam_entr, coursework_entr, assignment_entr, participation_entr);
		if(entered)
		{
			System.out.printf("Final Exam: %.2f\n",finalExam_entr);
			System.out.printf("Coursework: %.2f\n",coursework_entr);
			System.out.printf("Assignment: %.2f\n",assignment_entr);
			System.out.printf("Participation: %.2f\n",participation_entr);}
		else	
			System.out.println("The entering failed, please check the information and try again.\n");
		break;
//Case 7: Enter coursework mark - inclusive of its components =================================================================
 case 7:
	 	String coursework_student_id;
	 	String coursework_course_id;
		System.out.printf("\n<Enter coursework mark>\n");
	 	do{
	 		System.out.println("Enter the studentid: ");
	 		coursework_student_id=sc.next().toUpperCase();
	 	if (!checkexists(coursework_student_id,"student.txt")) {
	 		System.out.println("Student doesnt exist!");
	 	}}while(!checkexists(coursework_student_id,"student.txt"));
	 	
	 	do{
	 		System.out.println("Enter the courseid: ");
	 		coursework_course_id=sc.next().toUpperCase();
	 	 	if (!checkexists(coursework_course_id,"course.txt")) {
	 	 		System.out.println("Course doesnt exist!");
	 	 	}
	 		}while(!checkexists(coursework_course_id,"course.txt"));
	 	
	 	boolean coursework_success=enterCouWorkMark(coursework_student_id,coursework_course_id);
	 		
	 	
	 	if (coursework_success==true) System.out.println("Coursework score successfully added");
	 	else System.out.println("Failed");
	 	break;
 	
//Case 8: Enter exam mark =====================================================================================================
 case 8:
	 	String exam_student_id;
	 	String exam_course_id;
	 	double exammark;
 		System.out.printf("\n<Enter exam mark>\n");
 	 	do{
 	 		System.out.println("Enter the studentid: ");
 	 	    exam_student_id=sc.next().toUpperCase();
 	 	if (!checkexists(exam_student_id,"student.txt")) {
 	 		System.out.println("Student doesnt exist!");
 	 	}}while(!checkexists(exam_student_id,"student.txt"));
 	 	
 	 	do{
 	 		System.out.println("Enter the courseid: ");
 	 		exam_course_id=sc.next().toUpperCase();
 	 	 	if (!checkexists(exam_course_id,"course.txt")) {
 	 	 		System.out.println("Course doesnt exist!");
 	 	 	}
 	 		}while(!checkexists(exam_course_id,"course.txt"));
 	 	
	 	boolean exam_success=enterExamMark(exam_student_id,exam_course_id);
	 		
 	 	
 	 	if (exam_success==true) System.out.println("Exam score successfully added");
 	 	else System.out.println("Failed");
 	break;
//Case 9: Print course statistics =============================================================================================
 case 9:
	 	System.out.printf("\n<Print course statistics>\n");
	 	String stat_courseid;
	 	do {
	 		System.out.println("Enter courseid: ");
	 		stat_courseid=sc.next().toUpperCase();
	 		if(!checkexists(stat_courseid,"course.txt")) {
	 			System.out.println("Course doesnt exist.");
	 		}
	 	}while(!checkexists(stat_courseid,"course.txt"));
	 	
	 	boolean stat_success=printCouStatistics(stat_courseid);
	 	if (stat_success==false) System.out.println("Fail to show the statistics.");
 	break;
//Case 10: Print student transcript =========================================================================================== 
 case 10:
	    String transcript_student_id;
		System.out.printf("\n<Print student transcript>\n");
 	 	do{
 	 		System.out.println("Enter the studentid: ");
 	 		transcript_student_id=sc.next().toUpperCase();
 	 		if (!checkexists(transcript_student_id,"student.txt")) {
 	 			System.out.println("Student doesnt exist");
 	 		}
 	 	}while(!checkexists(transcript_student_id,"student.txt"));
 	 	
 	 	printTranscript(transcript_student_id);
 	break;
//Case EXIT & DEFAULT =========================================================================================================
 case -1:
 	break;
 default:
 	break;
 } }while(choice!=-1);

}
		
public static boolean checkexists(String id, String path) {
	SerializeFile sw=new SerializeFile(path);
	if (path.compareTo("course.txt")==0) {
		return (sw.search(id,'c')!=-1);
	}
	else if (path.compareTo("index.txt")==0) {
		return (sw.search(id,'i')!=-1);
	}
	else if (path.compareTo("student.txt")==0) {
		return (sw.search(id,'s')!=-1);
	}
	return false;
}
	
public static boolean addStudents(String studentId_add, String studentName_add, char gender_add, String nationality_add, 
		String school_add, Integer year_add) {
	// Create a new student object?? then add into file Students?? 
	SerializeFile sw=new SerializeFile("student.txt");
	Students newStudent = new Students(studentId_add, studentName_add, gender_add, nationality_add, school_add, year_add);
	boolean added = sw.appendNew(newStudent);
	return added;
}

public static void printStudentList() {
	SerializeFile sw=new SerializeFile("student.txt");
	sw.fillArray();
	for (int i=0;i<sw.gettarget().size();i++){
		System.out.println(((Students)sw.gettarget().get(i)).toString());
	}
	
}

public static void printCourseList() {
	SerializeFile sw=new SerializeFile("course.txt");
	sw.fillArray();
	for (int i=0;i<sw.gettarget().size();i++){
		System.out.println(((Course)sw.gettarget().get(i)).toString());
	}
}
//Case 2: Add a course	
public static boolean addCourse(String courseId_add, String courseName_add, Integer AUCredits_add, String schoolCou_add, ArrayList<Integer> indexGroupList_add, 
		boolean lec_add, boolean tut_add, boolean lab_add) {
	
	// Create a new course object?? then add into file Course??    ?????????/ should the infor about list, structure be completed??
	// Create a component first ->
	try {
	SerializeFile sw=new SerializeFile("course.txt");
	CourseComponent component_add = new CourseComponent(lec_add, tut_add, lab_add);
	for(int i=0;i<indexGroupList_add.size();i++) {
		addIndex(indexGroupList_add.get(i),courseId_add,10);
		//default vacancy 
	}
	Course newCourse = new Course(courseId_add, courseName_add, AUCredits_add, schoolCou_add, indexGroupList_add, component_add);
	boolean added = sw.appendNew(newCourse);
	return added;	
	}catch (Exception e){
		System.out.println("e in addcourse");
		return false;
	}
//????		return true;
}

private static boolean addIndex(Integer index, String courseId, int vacancy) {
	CourseIndex i= new CourseIndex(index,courseId,vacancy,null,null);
	SerializeFile sw=new SerializeFile("index.txt");
	if(sw.checkempty()) {
		sw.appendNew(i);
		return true;
	}
	else {
		if (sw.search(String.valueOf(index),'i')!=-1) {
			System.out.println("AddIndex fail! Index already exists!");
			return false;
		}
		else {sw.appendNew(i);
			return true;}
		}
	}
	
	
//FURTHER LOOK

//Case 3: Register student for a course (include registering for Tutorial/Lab)
public static boolean regiStuToCou(String studentId_regi, String courseId_regi) {
	Scanner sc = new Scanner(System.in);
	SerializeFile sw_cou = new SerializeFile("course.txt");
	SerializeFile sw_stu = new SerializeFile("student.txt");
	SerializeFile sw_ind = new SerializeFile("index.txt");
//???????????????????????????????????????????????????????????????????????????????????//		
	Students studentregi_obj = (Students) sw_stu.read(studentId_regi, 's');
	Course regi_course = (Course) sw_cou.read(courseId_regi, 'c'); 
//to check if the course has been registered by the student or not
	if(regi_course.getIndexGroupList().size()==0) {
		System.out.println("No index for this course");
		return false;
	}
	if(studentregi_obj.getIndexList().size()!=0) {
	for(int i=0;i<studentregi_obj.getIndexList().size();i++){
			for(int j=0;j<regi_course.getIndexGroupList().size();j++){
				if (studentregi_obj.getIndexList().get(i).compareTo(regi_course.getIndexGroupList().get(j))==0) {
					System.out.println("Course already registered!");
					return false;
				}
				}
		}
	}
//--------------------------------------------------------------------
	System.out.println("Here are the indeices: ");
	regi_course.viewIndexGroupList();                   

	do {
		System.out.printf("Please enter the index you want to register: ");		
		Integer regi_index = sc.nextInt();
		Integer regi_vacancy = checkVacancyAvailable(regi_index);	
		sw_ind.fillArray();
		CourseIndex indexregi_obj = (CourseIndex) sw_ind.read(regi_index.toString(), 'i');  
		if(regi_vacancy!=-1) { 		                               // if (has vacancy) -> register (add record to corresponding files + update vacancy...)
			indexregi_obj.addStuToStuList(studentId_regi);  
			// sw_ind.fillArray(); ??????????????????????
			studentregi_obj.addIndexToIndexList(regi_index);
			
			indexregi_obj.updateVacancy();
			System.out.println("the updated vacancy is "+indexregi_obj.getVacancy());
			sw_ind.writeArray();
			sw_stu.writeArray();
			return true;
		}
		else {                                   
//	 prompts Admin to choose 1. choose another index to check vacancy (just keep on the do while loop?)
//                           2. put into waitlist for this index (update file: waitlist)-> return false + words (exit loop)
//                           3. just exit (do not register for this course) -> return false + words (exit loop)
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
				System.out.println("There is no such option.");
				return false;
			}
		}

	}while(true);

}


//Case 4: Check available slot in a class (vacancy in a class)
public static Integer checkVacancyAvailable(Integer index_vacy) {
	
	                                                         // search to get the CourseIndex object by index_vacy
	SerializeFile sw=new SerializeFile("index.txt");
	CourseIndex index_obj = (CourseIndex) sw.read(index_vacy.toString(), 'i');
	                                                         // object.getVacancy() return the vacancy available in that class
	Integer vacancy = index_obj.getVacancy();
	if(vacancy>0) {
	    return vacancy;
	    }
	else {
		System.out.println("There is no vacancy available for index "+index_vacy);
		return -1;
		}
	
}


//Case 5: Print student list by lecture, tutorial or laboratory session for a course
public static void printStuListByTutLab(Integer index_prinStuList) {
	
	System.out.println("Student list for tutotial or laboratory session");
	// search the CourseIndex object by this index_prinStuList from file CourseIndex
	SerializeFile sw=new SerializeFile("index.txt");
	CourseIndex index_obj = (CourseIndex) sw.read(index_prinStuList.toString(), 'i');
	// object.getStudentList() -> get all student name/Id ?? in this index group i.e. lab/tutorial
	index_obj.printStudentList();
	// traverse and print the studentList
}

public static void printStuListByLec(String courseId_prinStuList) {
	int i;
	System.out.println("Student list for lecture session");
	// search the Course object by this courseId_prinStuList from file Course
	SerializeFile sw_cou = new SerializeFile("course.txt");
	SerializeFile sw_ind = new SerializeFile("index.txt");
	Course course_obj = (Course) sw_cou.read(courseId_prinStuList, 'c');
	// object.getindexGroupList() -> get all index group belonging to this Course
	// for each index, call printStudentListByTutLab()?? 	
	if (course_obj.getIndexGroupList().size()==0) {
		System.out.println("No indeices are assigned to this course.");
		return;}
	for(i=0; i<course_obj.getIndexGroupList().size(); i++) {
		CourseIndex index_obj = (CourseIndex) sw_ind.read(course_obj.getIndexGroupList().get(i).toString(),'i');
		index_obj.printStudentList();
	}	
}


//Case 6: Enter course assessment components weightage
public static boolean enterCompoWeightage(String course_Id, double finalExam_entr, double coursework_entr, double assignment_entr, 
		 double participation_entr) {
	
	// LOOP: (while (true) ?)                        
	// do a check of whether all entering added == 1 (100%)
	// if == 1 ->
	// find a Course object, object.addCouStructure()
	// store the new object to the file Course->CourseComponent ??  -> EXIT LOOP
	// else ->  prompts to re-enter ?? () -> keep on LOOP ?
	//      ->  user choose to exit -> return false
	SerializeFile sw=new SerializeFile("course.txt");
	Course c=(Course) sw.read(course_Id, 'c');
	c.getCourseStructure().setWeightOfFinal(finalExam_entr);
	c.getCourseStructure().setWeightOfCoursework(coursework_entr);
	c.getCourseStructure().setWeightOfAssignment(assignment_entr);
	c.getCourseStructure().setWeightOfParticipation(participation_entr);
	sw.updateWrite(c);
	return true;}


//Case 7: Enter coursework mark - inclusive of its components
public static boolean enterCouWorkMark(String studentid, String courseid) {
	Scanner sc=new Scanner(System.in);
	// ????????????? depends on how we implement the StuCouGrade entity class, i.e. how we store this file ?????????????
	SerializeFile sw_stu=new SerializeFile("student.txt");
	SerializeFile sw_cou=new SerializeFile("course.txt");
	SerializeFile sw_stug=new SerializeFile("studentgrade.txt");
	Course c1=(Course)sw_cou.read(courseid,'c');
	Students s1=(Students)sw_stu.read(studentid,'s');
	if (c1.getCourseStructure().getWeightOfCoursework()<1e-6) {
		System.out.println("This course doesnt have coursework.");
		return false;
	}
	
	else {
		double courseworkmark;
		double participationmark=0;
		double assignmentmark=0;
		boolean hasassignment=c1.getCourseStructure().getWeightOfAssignment()>1e-6;
		boolean hasparticipation=c1.getCourseStructure().getWeightOfParticipation()>1e-6;
		if (hasassignment) {
			do {
				System.out.println("Enter assignment mark: ");
				assignmentmark=sc.nextDouble();
				if ((assignmentmark-100>0)||(assignmentmark<0)){
					System.out.println("Inavailavle cassignment mark entry!");
				}}while((assignmentmark-100>0)||(assignmentmark<0));
		}
		
		if(hasparticipation) {
			do {
				System.out.println("Enter participation mark: ");
				participationmark=sc.nextDouble();
				if ((participationmark-100>0)||(participationmark<0)){
					System.out.println("Inavailavle cassignment mark entry!");
				}}while((participationmark-100>0)||(participationmark<0));
		}
		
		if(!hasassignment&&!hasparticipation) {
			do {
				System.out.println("Enter coursework mark: ");
				courseworkmark=sc.nextDouble();
				if ((courseworkmark-100>0)||(courseworkmark<0)){
					System.out.println("Inavailavle coursework mark entry!");
				}}while((courseworkmark-100>0)||(courseworkmark<0));
		}
		else {
			courseworkmark=c1.getCourseStructure().getWeightOfAssignment()*assignmentmark+c1.getCourseStructure().getWeightOfParticipation()*participationmark;
		}
		
		if (participationmark==0) participationmark=-1;
		if (assignmentmark==0) assignmentmark=-1;
		
		if (sw_stug.search(studentid,courseid)!=-1) {
			StudentCourseGrade stug1=(StudentCourseGrade)sw_stug.read(studentid, courseid);
			stug1.setCourseworkScore(courseworkmark);
			stug1.setParticipationScore(participationmark);
			stug1.setAssignmentScore(assignmentmark);
			stug1.setTotalScore();
			sw_stug.updateWrite(stug1);
		}
		else {
			StudentCourseGrade stug2=new StudentCourseGrade(studentid,courseid,-1,courseworkmark,assignmentmark,participationmark);
			stug2.setTotalScore();
			sw_stug.appendNew(stug2);}
		return true;
	}
	}

//Case 8: Enter exam mark
// retake
public static boolean enterExamMark(String studentid, String courseid) {
	Scanner sc=new Scanner(System.in);
	SerializeFile sw_stu=new SerializeFile("student.txt");
	SerializeFile sw_stug=new SerializeFile("studentgrade.txt");
	
	SerializeFile sw_cou=new SerializeFile("course.txt");
	Course c1=(Course)sw_cou.read(courseid,'c');
	if (c1.getCourseStructure().getWeightOfFinal()<1e-6) {
		System.out.println("This course doesnt have final exam.");
		return false;
	}
	else {
		double exammark;
		
		do {
		System.out.println("Enter exam mark: ");
		exammark=sc.nextDouble();
		if ((exammark-100>0)||(exammark<0)){
			System.out.println("Inavailavle exam mark entry!");
		}}while((exammark-100>0)||(exammark<0));
		
		Students s1=(Students)sw_stu.read(studentid,'s');
		if (sw_stug.search(studentid,courseid)!=-1) {
			StudentCourseGrade stug1=(StudentCourseGrade)sw_stug.read(studentid, courseid);
			stug1.setExamScore(exammark);
			stug1.setTotalScore();
			sw_stug.updateWrite(stug1);
		}	
		else {
			StudentCourseGrade stug2=new StudentCourseGrade(studentid,courseid,exammark,-1,-1,-1);
			stug2.setTotalScore();
			sw_stug.appendNew(stug2);}
		return true;}
	
}
//Case 9: Print course statistics (coursePerformance)   //??????????????? StuCouGrade Class related ????????????????????//
public static boolean printCouStatistics(String cid) {
		SerializeFile sw_cou=new SerializeFile("course.txt");
		Course c=(Course)sw_cou.read(cid, 'c');
		boolean hasexam=c.getCourseStructure().getWeightOfFinal()>1e-6;
		boolean hascoursework=c.getCourseStructure().getWeightOfCoursework()>1e-6;
//		boolean hasassignment=c.getCourseStructure().getWeightOfAssignment()>1e-6;
//		boolean hasparticipation=c.getCourseStructure().getWeightOfParticipation()>1e-6;
		System.out.println(cid);
		SerializeFile sw_stug=new SerializeFile("studentgrade.txt");
		ArrayList<StudentCourseGrade> stug=sw_stug.readAll(cid, 'c');
		if (stug.size()==0) System.out.println("This course has not been registered yet.");
		else {	int countexamAp=0;
				int countexamA=0;
				int countexamAm=0;
				int countexamBp=0;
				int countexamB=0;
				int countexamBm=0;
				int countexamCp=0;
				int countexamC=0;
				
				int countcourseworkAp=0;
				int countcourseworkA=0;
				int countcourseworkAm=0;
				int countcourseworkBp=0;
				int countcourseworkB=0;
				int countcourseworkBm=0;
				int countcourseworkCp=0;
				int countcourseworkC=0;
				
				int counttotalAp=0;
				int counttotalA=0;
				int counttotalAm=0;
				int counttotalBp=0;
				int counttotalB=0;
				int counttotalBm=0;
				int counttotalCp=0;
				int counttotalC=0;
				
				if (hasexam) {
					for(int i=0;i<stug.size();i++) {
						if (stug.get(i).tograde('e')=="A+") countexamAp+=1;
						else if (stug.get(i).tograde('e')=="A") countexamA+=1;
						else if (stug.get(i).tograde('e')=="A-") countexamAm+=1;
						else if (stug.get(i).tograde('e')=="B+") countexamBp+=1;
						else if (stug.get(i).tograde('e')=="B") countexamB+=1;
						else if (stug.get(i).tograde('e')=="B-") countexamBm+=1;
						else if (stug.get(i).tograde('e')=="C+") countexamCp+=1;
						else if (stug.get(i).tograde('e')=="C") countexamC+=1;
					}
					formatPrintStatistic("exam",countexamAp,countexamA,countexamAm,countexamBp,countexamB,countexamBm,countexamCp,countexamC);
				}
				if (hascoursework) {
					for(int i=0;i<stug.size();i++) {
						if (stug.get(i).tograde('c')=="A+") countcourseworkAp+=1;
						else if (stug.get(i).tograde('c')=="A") countcourseworkA+=1;
						else if (stug.get(i).tograde('c')=="A-") countcourseworkAm+=1;
						else if (stug.get(i).tograde('c')=="B+") countcourseworkBp+=1;
						else if (stug.get(i).tograde('c')=="B") countcourseworkB+=1;
						else if (stug.get(i).tograde('c')=="B-") countcourseworkBm+=1;
						else if (stug.get(i).tograde('c')=="C+") countcourseworkCp+=1;
						else if (stug.get(i).tograde('c')=="C") countcourseworkC+=1;
					}
					formatPrintStatistic("coursework",countcourseworkAp,countcourseworkA,countcourseworkAm,countcourseworkBp,countcourseworkB,countcourseworkBm,countcourseworkCp,countcourseworkC);
				}
				if(hasexam&&hascoursework) {
					for(int i=0;i<stug.size();i++) {
						if (stug.get(i).tograde('t')=="A+") counttotalAp+=1;
						else if (stug.get(i).tograde('t')=="A") counttotalA+=1;
						else if (stug.get(i).tograde('t')=="A-") counttotalAm+=1;
						else if (stug.get(i).tograde('t')=="B+") counttotalBp+=1;
						else if (stug.get(i).tograde('t')=="B") counttotalB+=1;
						else if (stug.get(i).tograde('t')=="B-") counttotalBm+=1;
						else if (stug.get(i).tograde('t')=="C+") counttotalCp+=1;
						else if (stug.get(i).tograde('t')=="C") counttotalC+=1;
					}
						formatPrintStatistic("total grade",counttotalAp,counttotalA,counttotalAm,counttotalBp,counttotalB,counttotalBm,counttotalCp,counttotalC);
						}
						
						
				}
	return false;
	
}

public static void formatPrintStatistic(String name,int ap,int a,int am, int bp, int b, int bm, int cp, int c) {
	String space="              ";
	System.out.println(name);

	System.out.println("Grade"+space+"NumofStudents");
	System.out.println("A+   "+space+ap);
	System.out.println("A    "+space+a);
	System.out.println("A-   "+space+am);
	System.out.println("B+   "+space+bp);
	System.out.println("B    "+space+b);
	System.out.println("B-   "+space+bm);
	System.out.println("C+   "+space+cp);
	System.out.println("C    "+space+c);
	
}
//Case 10: Print student transcript
public static void printTranscript(String sid) {
	SerializeFile sw_stu=new SerializeFile("student.txt");
	SerializeFile sw_stug=new SerializeFile("studentgrade.txt");
	Students temp_s=(Students)sw_stu.read(sid, 's');
	String temp_str="";
	int i;
	System.out.println(temp_s.getStudentId()+" "+temp_s.getStudentName()+" "+temp_s.getSchool()+ " "+temp_s.getYear());
	ArrayList<StudentCourseGrade> temp_stug=sw_stug.readAll(sid,'s');
	if (temp_stug.size()==0) System.out.println("No courses are taken.");
	for (i=0;i<temp_stug.size();i++) {
		StudentCourseGrade scg=temp_stug.get(i);
		temp_str=scg.getCourseId()+" ";
		if (scg.getTotalScore()==-1) {
			temp_str+="Grading not finished.";
			System.out.println(temp_str);
			continue;
			}
		else if (scg.getTotalScore()!=-1) {
			temp_str+="total grade: "+scg.tograde('t')+" ";
			temp_str+="total mark: "+scg.getTotalScore()+" ";
		}
		if (scg.getExamScore()!=-1) temp_str=temp_str+ "exam:"+scg.getExamScore()+" ";
		if (scg.getCourseworkScore()!=-1) temp_str=temp_str+ "coursework:"+scg.getCourseworkScore()+" ";
		if (scg.getAssignmentScore()!=-1) temp_str=temp_str+ "assignment(part of coursework):"+scg.getAssignmentScore()+" ";
		if (scg.getParticipationScore()!=-1) temp_str=temp_str+ "participation(part of coursework):"+scg.getParticipationScore()+" ";
		System.out.println(temp_str);
		}
}


public static void printresult(File f) throws IOException, ClassNotFoundException {
	FileInputStream fi=new FileInputStream(f);
	ObjectInputStream oi=new ObjectInputStream(fi);
	ArrayList<Object> temp=new ArrayList<Object>();
	if (fi.available()>0)
	{while (fi.available()>0) {
		temp.add(oi.readObject());
	}
	for(int i=0;i<temp.size();i++) {
		System.out.println(((Course)(temp.get(i))).toString());
	}
	oi.close();}
	else System.out.println("empty file");
}

}
