
public class StuCouGrade {

	private String courseId;  // make an new stucou attribute?? U1722007KCZ2001 ????  
	private String semYr;  // Sem2Yr2
	
	private double finalExamGrd; // set as 4, 4.5, 5...
	private double quizGrd;
	private double assignmentGrd;
	private double projectGrd;
	private double participationGrd;
	
	private double courseGrade;
	
/*-------------------------constructor---------------------------- */	
// create a new Grades object with no attribute passed in
	public StuCouGrade() {
		this.courseId = "CZxxxx";
		this.semYr = "Sem1Yr1";
		
		this.finalExamGrd = 60.0;
		this.quizGrd = 60.0;
		this.assignmentGrd = 60.0;
		this.projectGrd = 60.0;
		this.participationGrd = 60.0;
		
		this.courseGrade = 60.0;
		
	}
// create a new Grades object with studentid,courseid,semYr,finalExamGrd,quizGrd,assignmentGrd,projectGrd,participationGrd,courseGrade passed in
    public StuCouGrade(String studentid, String courseid, String semYr, double finalExamGrd, double quizGrd, double assignmentGrd, 
    		double projectGrd, double participationGrd) {
    	
    }
/*-----------------------get&set attributes-------------------------- */
// get and set studentid
// get and set courseid
// get and set semYr
// get and set finalExamGrd
// get and set quizGrd
// get and set assignmentGrd
// get and set projectGrd
// get and set participationGrd
    
/*----------------------calculateCourseGrade--------------------------*/ //??? is this method belongs to this entity class or control class
    public double calcCourseGrade(String courseid, double finalExamGrd, double quizGrd, double assignmentGrd, double projectGrd, 
    		double participationGrd) {
    	
    	// search courseid in file Course to get that Course object, 
    	// object.getStructure() -> get the weightage of each kind of assessment
    	// calculate using weightage and grade of each assessment 
    	// return courseGrade for this Grades object                 ???? -> do not store this in the file now (need studentid to update)??
    	return 0.0;
    }
    
/*----------------------calculateGPA--------------------------*/
	
}
