import java.util.ArrayList;
import java.io.Serializable;

public class Students extends User implements Serializable{
	
	private static final long serialVersionUID = 3L;
	
	private String studentId;
	private String studentName;
	private char gender;
	private String nationality;
	private String school;
	private Integer year;
	
	private ArrayList<Integer> indexList = new ArrayList<Integer>();
	private StuCouGrade grade = new StuCouGrade();
	private double GPA = 0.00;
	
/*-------------------------constructor---------------------------- */	
// Creates a new Student without specified attributes
	public Students() {
		this.studentId = "U1xxxxxxx";
		this.studentName = "Student X";
		this.gender = 'M';
		this.nationality = "Singaporean";
		this.school = "SCSE";
		this.year = 1;
	}
// Creates a new Student with studentId, studentName, gender, nationality, school, year, indexList passed in
	public Students(String studentId, String studentName, char gender, String nationality, 
			String school, Integer year) {
		
		this.studentId = studentId;
		this.studentName = studentName;
		this.gender = gender;
		this.nationality = nationality;
		this.school = school;
		this.year = year;
		
	}
/*-----------------------get&set attributes-------------------------- */	
// Get and set studentId
	public String getStudentId() {
		return this.studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
// Get and set studentName
	public String getStudentName() {
		return this.studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
// Get and set gender
	public char getGender() {
		return this.gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
// Get and set nationality
	public String getNationality() {
		return this.nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
// Get and set school
	public String getSchool() {
		return this.school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
// Get and set year
	public Integer getYear() {
		return this.year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
// Get and set indexList, a list of course index that student registered in
	public ArrayList<Integer> getIndexList(){
		return this.indexList;
	}
	public void setIndexList(ArrayList<Integer> indexList) {
		this.indexList = indexList;
	}

// addCourse, dropCourse
}
