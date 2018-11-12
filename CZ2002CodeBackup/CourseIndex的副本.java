import java.util.ArrayList;
public class CourseIndex {

	private Integer index;
	private String courseId;
	private Integer vacancy;
	private ArrayList<String> waitlist;
	private ArrayList<String> studentList;
	
	private String tutor;
	private String labTutor;
	
/*-------------------------constructor---------------------------- */	
// Creates a new CourseIndex without specified attributes
	public CourseIndex() {
		
	}
// Create a new CourseIndex with index, courseId, vacancy, waitlist, studentList passed in
	public CourseIndex(Integer index, String courseId, Integer vacancy, ArrayList<String> waitlist, 
			ArrayList<String> studentList) {
		this.index = index;
		this.courseId = courseId;
		this.vacancy = vacancy;
		this.waitlist = waitlist;
		this.studentList = studentList;
	}
/*-----------------------get&set attributes-------------------------- */	
// Get and set index
	public Integer getIndex() {
		return this.index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
// Get and set courseId
	public String getCourseId() {
		return this.courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
// Get and set vacancy
	public Integer getVacancy() {
		return this.vacancy;
	}
	public void setVacancy(Integer vacancy) {
		this.vacancy = vacancy;
	}
// Get and set waitlist
	public ArrayList<String> getWaitalsit() {
		return this.waitlist;
	}
	public void setWaitlsit(ArrayList<String> waitlsit) {
		this.waitlist = waitlsit;
	}
// Get and set studentList
	public ArrayList<String> getStudentList(){
		return this.studentList;
	}
	public void setStudentList(ArrayList<String> studentList) {
		this.studentList = studentList;
	}
	

	
}
