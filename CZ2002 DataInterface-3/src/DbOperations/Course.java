package DbOperations;
import java.util.ArrayList;
public class Course {

	private String courseID;
	private String courseName;
	private Integer AUCredits;
	private String school;
	private String courseType;
	
	

/*-------------------------constructor---------------------------- */	
	// Creates a new Course without specified attributes
	public Course(){
		
	}
	// Creates a new Course with given ID, name, AU, waitList of index group, structure, component
	public Course(String courseID, String courseName, Integer AUcredits, String school, String courseType) {
		this.courseID=courseID;
		this.courseName = courseName;
		this.AUCredits = AUCredits;
		this.school = school;
		this.courseType = courseType;

	}
/*-----------------------get&set attributes-------------------------- */		
	// Get the ID of the course
	public String getCourseID() {
		return this.courseID;
	}
	// Change the ID of the course
	public void setCourseID(String courseID) {
		this.courseID=courseID;
	}
/*------------------------------------------------------------------ */		
	// Get the name of the course
	public String getCourseName() {
		return this.courseName;
	}
	// Change the name of the course
	public void setCourseName(String courseName) {
		this.courseName=courseName;
	}
/*------------------------------------------------------------------ */
	// Get the AU of the course
	public int getAUcredits() {
		return this.AUCredits;
	}
	// Change the AU of the course
	public void setAUCredits(int AUCredits) {
		this.AUCredits=AUCredits;
	}
/*------------------------------------------------------------------ */
	// Get school the course belongs to
	public String getSchool() {
		return this.school;
	}
	// Change school the course belongs to
	public void setSchool(String school) {
		this.school=school;
	}
/*------------------------------------------------------------------ */	
	// Get type of the course
	public String getCourseType() {
		return this.courseType;
	}
	// Change type of the course
	public void setCourseType(String courseType) {
		this.courseType=courseType;
	}}
/*------------------------------------------------------------------ */
	// Get the ArrayList of indexGroup's IDs of the course

