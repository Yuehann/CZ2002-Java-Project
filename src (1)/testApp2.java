import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class testApp2 {

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
//Case 2: Add a course ========================================================================================================
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
//Case 3: Register student for a course (include registering for Tutorial/Lab) ================================================
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
//Case 4: Check available slot in a class (vacancy in a class)	================================================================
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
//Case 5: Print student list by lecture, tutorial or laboratory session for a course ==========================================
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
//Case 6: Enter course assessment components weightage ========================================================================
 case 6:
 	System.out.printf("\n< Change course assessment components weightage >\n");
 	System.out.println("Enter the courseid: ");
 	String component_course_id=sc.next();
 	System.out.printf("\nPlease enter course assessment component weightage:\n");
 	System.out.printf("  Final Exam Weightage: ");
 	double finalExam_entr = sc.nextDouble();
 	System.out.printf("  Coursework Exam Weightage: ");
 	double coursework_entr = sc.nextDouble();
 	System.out.printf("  Assignment Weightage in coursework: ");
 	double assignment_entr = sc.nextDouble();
 	System.out.printf("  Participation Weightage in coursework: ");
 	double participation_entr = sc.nextDouble();
//	if (finalExam_entr-1>1e-6
//			||(coursework_entr-1>1e-6)
//			||(assignment_entr-1>1e-6)
//			||(participation_entr-1>1e-6)
//			||(finalExam_entr+coursework_entr-1>1e-6)
//			||(coursework_entr==0 && (assignment_entr!=0||participation_entr!=0))
//			||(coursework_entr!=0&&(assignment_entr+participation_entr-1>1e-6||(assignment_entr!=0||participation_entr!=0))))
	// 3 cases unavailable: 1. final+coursework!=1; 2. coursework==0 but ass or participation!=0 3. coursework!=0 while a+p!=1
		boolean entered = enterCompoWeightage(component_course_id,finalExam_entr, coursework_entr, assignment_entr, participation_entr);
		if(entered)
			System.out.println("The course assessment components weightage are successfully entered!"+
					"\n  Final Exam: "+finalExam_entr+"\n  Coursework: "+coursework_entr+"\n  Assignment: "+assignment_entr+
					"\n  Participation: "+participation_entr);
		else	
			System.out.println("The entering failed, please check the information and try again.");
		break;
//Case 7: Enter coursework mark - inclusive of its components =================================================================
 case 7:
	 	boolean hasAssignment=false;
	 	boolean hasParticipation=false;
	 	boolean success=false;
	 	int coumark;
	 	SerializeFile sw_cou=new SerializeFile("course.txt");
	 	SerializeFile sw_stu=new SerializeFile("student.txt");
 		System.out.printf("\n<Enter coursework mark - inclusive of its components.>\n");
 	 	System.out.println("Enter the studentid: ");
 	 	String score_student_id=sc.next();
// 	 	show the course name he takes
 	 	System.out.println("Enter the courseid: ");
 	 	String score_course_id=sc.next();
// 	 	check if the student is actually in this course
 	 	sw_stu.fillArray();
 	 	sw_cou.fillArray();
 	 	Students s= (Students) sw_stu.read(score_student_id,'s');
 	 	Course c=(Course) sw_cou.read(score_course_id,'c');
// 	 	check if the course has coursework and components
 	 	if (c.getCourseStructure().getWeightOfAssignment()>0) hasAssignment=true;
 	 	if (c.getCourseStructure().getWeightOfParticipation()>0) hasParticipation=true;
 	 	if (c.getCourseStructure().getWeightOfCoursework()>0) {
 	 		if (!hasAssignment||!hasParticipation){
 	 			System.out.println("Enter coursework mark: ");
 	 			coumark=sc.nextInt();
 	 			success=enterCouWorkMark(score_student_id,score_course_id,String.valueOf(s.getYear()),coumark);
 	 		}
 	 		else {
 	 			System.out.println("Enter Assignment mark: ");
 	 			int coumark_ass=sc.nextInt();
 	 			System.out.println("Enter Participation mark: ");
 	 			int coumark_par=sc.nextInt();
 	 			success=enterCouWorkMark(score_student_id,score_course_id,String.valueOf(s.getYear()),coumark_ass,coumark_par);
 	 			
 	 		}
 	 	}
 	 	
 	 	else System.out.println("This is an exam-only course");
 	 	
 	 	if (success==true) System.out.println("Successfully added");
 	 	else System.out.println("Failed");
 	break;
 	
//Case 8: Enter exam mark =====================================================================================================
 case 8:
 		boolean hasexam=false;
 		boolean success1=false;
	 	sw_cou=new SerializeFile("course.txt");
	 	sw_stu=new SerializeFile("student.txt");
	 	sw_cou.fillArray();
	 	sw_stu.fillArray();
 		System.out.printf("\n<Enter exam mark>\n");
 	 	System.out.println("Enter the studentid: ");
 	 	String exam_student_id=sc.next();
 	 	System.out.println("Enter the courseid: ");
 	 	String exam_course_id=sc.next();
 	 	s= (Students) sw_stu.read(exam_student_id,'s');
 	 	c=(Course) sw_cou.read(exam_course_id,'c');
 	 	if (c.getCourseStructure().getWeightOfFinal()>0) hasexam=true;
 	 	if (hasexam) {
	 			System.out.println("Enter exam mark: ");
	 			coumark=sc.nextInt();
	 			success1=enterExamMark(exam_student_id,exam_course_id,String.valueOf(s.getYear()),coumark);}
 	 	else System.out.println("This course is coursework-only");
 	 	
 	 	if (success1==true) System.out.println("Successfully added");
 	 	else System.out.println("Failed");
 	break;
//Case 9: Print course statistics =============================================================================================
 case 9:
 	
 	break;
//Case 10: Print student transcript =========================================================================================== 
 case 10:
		System.out.printf("\n<Enter exam mark>\n");
 	 	System.out.println("Enter the studentid: ");
 	 	String transcript_student_id=sc.next();
 	 	printTranscript(transcript_student_id);
 	break;
//Case EXIT & DEFAULT =========================================================================================================
 case -1:
 	break;
 default:
 	break;
 } }while(choice!=-1);

}
		
	
public static boolean addStudents(String studentId_add, String studentName_add, char gender_add, String nationality_add, 
		String school_add, Integer year_add) {
	// Create a new student object?? then add into file Students?? 
	SerializeFile sw=new SerializeFile("student.txt");
	Students newStudent = new Students(studentId_add, studentName_add, gender_add, nationality_add, school_add, year_add);
	boolean added = sw.appendNew(newStudent);
	return added;
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
		addIndex(indexGroupList_add.get(i),courseId_add,40);
		//default vacancy 
	}
	Course newCourse = new Course(courseId_add, courseName_add, AUCredits_add, schoolCou_add, indexGroupList_add, component_add);
	boolean added = sw.appendNew(newCourse);
	printresult(sw.getfile());
	return added;	
	}catch (Exception e){
		System.out.println("e in addcourse");
		return false;
	}
//????		return true;
}

private static boolean addIndex(Integer index, String courseId, int vacancy) {
	System.out.println("here");
	CourseIndex i= new CourseIndex(index,courseId,vacancy,null,null);
	SerializeFile sw=new SerializeFile("index.txt");
	if(sw.checkempty()) {
		sw.appendNew(i);
		return true;
	}
	else {
		sw.fillArray();
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
	sw_ind.fillArray();
//???????????????????????????????????????????????????????????????????????????????????//		
	sw_stu.fillArray();
	Students studentregi_obj = (Students) sw_stu.read(studentId_regi, 's');
	System.out.printf(""+studentregi_obj);
	sw_cou.fillArray();
	Course regi_course = (Course) sw_cou.read(courseId_regi, 'c'); 
	System.out.printf(""+regi_course);
//to check if the course has been registered by the student or not
	for(int i=0;i<studentregi_obj.getIndexList().size();i++){
		System.out.println(studentregi_obj.getIndexList().get(i));
		for(int j=0;j<regi_course.getIndexGroupList().size();j++){
			System.out.println(regi_course.getIndexGroupList().get(j));
			if (studentregi_obj.getIndexList().get(i).compareTo(regi_course.getIndexGroupList().get(j))==0) {
				System.out.println("Course already registered!");
				return false;
			}
		}
	}
//--------------------------------------------------------------------
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
	sw.fillArray();
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


//Case 5: Print student list by lecture, tutorial or laboratory session for a course
public static void printStuListByTutLab(Integer index_prinStuList) {
	
	System.out.println("Student list for tutotial or laboratory session");
	// search the CourseIndex object by this index_prinStuList from file CourseIndex
	SerializeFile sw=new SerializeFile("index.txt");
	sw.fillArray();
	CourseIndex index_obj = (CourseIndex) sw.read(index_prinStuList.toString(), 'i');
	// object.getStudentList() -> get all student name/Id ?? in this index group i.e. lab/tutorial
	index_obj.printStudentList();
	// traverse and print the studentList
}

public static void printStuListByLec(String courseId_prinStuList) {
	
	System.out.println("Student list for lecture session");
	// search the Course object by this courseId_prinStuList from file Course
	SerializeFile sw_cou = new SerializeFile("course.txt");
	SerializeFile sw_ind = new SerializeFile("index.txt");
	sw_ind.fillArray();
	sw_cou.fillArray();
	Course course_obj = (Course) sw_cou.read(courseId_prinStuList, 'c');
	// object.getindexGroupList() -> get all index group belonging to this Course
	// for each index, call printStudentListByTutLab()?? 	
	for(int i=0; i<course_obj.getIndexGroupList().size(); i++) {
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
	
	//courseidnot found
	if ((finalExam_entr+coursework_entr-1>1e-6)||(coursework_entr==0&&(assignment_entr!=0||participation_entr!=0))||(coursework_entr!=0&&assignment_entr+participation_entr-1>1e-6))
		{
		System.out.println("Invalid number combination");
		return false;
		}
	
	else{
	SerializeFile sw=new SerializeFile("course.txt");
	sw.fillArray();
	Course c=(Course) sw.read(course_Id, 'c');
	c.getCourseStructure().setWeightOfFinal(finalExam_entr);
	c.getCourseStructure().setWeightOfCoursework(coursework_entr);
	c.getCourseStructure().setWeightOfAssignment(assignment_entr);
	c.getCourseStructure().setWeightOfParticipation(participation_entr);
	try {
		sw.updateWrite(c);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return true;}
}


//Case 7: Enter coursework mark - inclusive of its components
public static boolean enterCouWorkMark(String studentid, String courseid, String semYr,
		int courseworkGrd) {
			
	// ????????????? depends on how we implement the StuCouGrade entity class, i.e. how we store this file ?????????????
	SerializeFile sw_stu=new SerializeFile("student.txt");
	SerializeFile sw_stug=new SerializeFile("studentgrade.txt");
	sw_stu.fillArray();
	Students s1=(Students)sw_stu.read(studentid,'s');
	sw_stug.fillArray();
	if (sw_stug.search(studentid,courseid,semYr)!=-1) {
		StudentCourseGrade stug1=(StudentCourseGrade)sw_stug.read(studentid, courseid,semYr);
		stug1.setCourseworkScore(courseworkGrd);
		try {
			sw_stug.updateWrite(stug1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	else sw_stug.appendNew(new StudentCourseGrade(studentid,courseid,semYr,-1,courseworkGrd,-1,-1));
	return true;
	
}
public static boolean enterCouWorkMark(String studentid, String courseid, String semYr,
		int assignmentGrd,int participationGrd) {
	
	// ????????????? depends on how we implement the StuCouGrade entity class, i.e. how we store this file ?????????????
	SerializeFile sw_stu=new SerializeFile("student.txt");
	SerializeFile sw_stug=new SerializeFile("studentgrade.txt");
	SerializeFile sw_cou=new SerializeFile("course.txt");
	sw_stu.fillArray();
	sw_cou.fillArray();
	sw_stug.fillArray();
	Course c1=(Course)sw_cou.read(courseid,'c');
	Students s1=(Students)sw_stu.read(studentid,'s');
	if (sw_stug.search(studentid,courseid,semYr)!=-1) {
		StudentCourseGrade stug1=(StudentCourseGrade)sw_stug.read(studentid, courseid,semYr);
		stug1.setAssignmentScore(assignmentGrd);
		stug1.setParticipationScore(participationGrd);
		stug1.setCourseworkScore((int)(assignmentGrd*c1.getCourseStructure().getWeightOfAssignment()+participationGrd*c1.getCourseStructure().getWeightOfParticipation()));
		try {
			sw_stug.updateWrite(stug1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	else sw_stug.appendNew(new StudentCourseGrade(studentid,courseid,semYr,-1,(int)(assignmentGrd*c1.getCourseStructure().getWeightOfAssignment()+participationGrd*c1.getCourseStructure().getWeightOfParticipation()),assignmentGrd,participationGrd));
	return true;
}


//Case 8: Enter exam mark
// retake
public static boolean enterExamMark(String studentid, String courseid, String semYr,int examGrd) {
	
	SerializeFile sw_stu=new SerializeFile("student.txt");
	SerializeFile sw_stug=new SerializeFile("studentgrade.txt");
	SerializeFile sw_cou=new SerializeFile("course.txt");
	sw_stu.fillArray();
	sw_cou.fillArray();
	sw_stug.fillArray();
	Course c1=(Course)sw_cou.read(courseid,'c');
	Students s1=(Students)sw_stu.read(studentid,'s');
	if (sw_stug.search(studentid,courseid,semYr)!=-1) {
		StudentCourseGrade stug1=(StudentCourseGrade)sw_stug.read(studentid, courseid,semYr);
		stug1.setExamScore(examGrd);
		try {
			sw_stug.updateWrite(stug1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	else sw_stug.appendNew(new StudentCourseGrade(studentid,courseid,semYr,examGrd,-1,-1,-1));
	return true;
	
}
//Case 9: Print course statistics (coursePerformance)   //??????????????? StuCouGrade Class related ????????????????????//
public static void printCouStatistics() {
	
}
//Case 10: Print student transcript
public static void printTranscript(String sid) {
	SerializeFile sw_stu=new SerializeFile("student.txt");
	SerializeFile sw_stug=new SerializeFile("studentgrade.txt");
	sw_stu.fillArray();
	sw_stug.fillArray();
	Students temp_s=(Students)sw_stu.read(sid, 's');
	String temp_str="";
	int i;
	System.out.println(temp_s.getStudentId()+" "+temp_s.getStudentName()+" "+temp_s.getSchool()+ " "+temp_s.getYear());
	ArrayList<StudentCourseGrade> temp_stug=sw_stug.searchAll(sid,String.valueOf(temp_s.getYear()));
	if (temp_stug.size()==0) System.out.println("No courses are taken.");
	int totalgrade;
	for (i=0;i<temp_stug.size();i++) {
		StudentCourseGrade scg=temp_stug.get(i);
		temp_str=scg.getCourseId()+" ";
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
