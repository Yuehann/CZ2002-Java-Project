import java.io.Serializable;
import java.util.ArrayList;
public class CourseIndex implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer index;
	private String courseId;
	private Integer vacancy;
	private ArrayList<String> waitlist;
	private ArrayList<String> studentList;
	
	private String tutor;
	private String labTutor;
	
/*-------------------------constructor---------------------------- */	
// Creates a new CourseIndex without specified attributes
	public CourseIndex(Integer index) {
		this.index=index;
	}
// Create a new CourseIndex with index, courseId, vacancy, waitlist, studentList passed in
	public CourseIndex(Integer index, String courseId, Integer vacancy, ArrayList<String> waitlist, 
			ArrayList<String> studentList) {
		this.index = index;
		this.courseId = courseId;
		this.vacancy = vacancy;
		if (waitlist!=null ) this.waitlist = waitlist;
		else this.waitlist=new ArrayList<String>();
		if (studentList!=null) this.studentList = studentList;
		else this.studentList=new ArrayList<String>();
		
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
	public ArrayList<String> getWaitlist() {
		return this.waitlist;
	}
	public void setWaitlist(ArrayList<String> waitlsit) {
		this.waitlist = waitlsit;
	}
// Get and set studentList
	public ArrayList<String> getStudentList(){
		return this.studentList;
	}
	public void setStudentList(ArrayList<String> studentList) {
		this.studentList = studentList;
	}
	
	public String toString() {
		String temp="";
		temp=temp+this.index+" "+this.courseId+ " "+this.vacancy+" ";
		
		if (this.waitlist!=null&&this.waitlist.size()!=0) {
			for(int i=0;i<this.waitlist.size();i++) {
				temp+=this.waitlist.get(i);
			}
			temp+=" "; 
		}
		else temp+="null ";
		
		if (this.studentList!=null&&this.studentList.size()!=0) {
			for(int i=0;i<this.studentList.size();i++) {
				temp+=this.studentList.get(i);
			}
		}
		else temp+="null";
		
		return temp;
	}
	
/*---------------------------------------------------------------------------*/
	public void addStuToStuList(String studentId) {
		this.studentList.add(studentId);
	}
	
	public boolean updateVacancy() {
		if(this.vacancy==0) {
			System.out.println("There is no vacancy available for this index.");
			return false;
		}
		else {
			this.vacancy -= 1;
			return true;
		}
	}
	
	public void addToWaitlist(String studentId) {
		this.waitlist.add(studentId);
	}
	
	public void printStudentList() {
		for(int i=0; i<this.studentList.size(); i++) {
			System.out.printf(this.studentList.get(i)+" ");
		}
	}

	
}