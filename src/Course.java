import java.util.ArrayList;
public class Course {

	private String courseID;
	private String courseName;
	private Integer AUCredits;
	private String school;
	private String courseType;
	private ArrayList<Integer> indexGroupList;  //????indexGroupClass,<indexGroup>,contain vacancy, Students?????//
	
	private courseStructure structure;  // uni-directional
	private courseComponent component;  // uni-directional
	private Prof professors;
/*-------------------------constructor---------------------------- */	
	// Creates a new Course without specified attributes
	public Course(){
		
	}
	// Creates a new Course with given ID, name, AU, waitList of index group, structure, component
	public Course(String courseID, String courseName, Integer AUcredits, String school, String courseType, ArrayList<Integer> indexGroupList, courseStructure sturcture, courseComponent component) {
		this.courseID=courseID;
		this.courseName = courseName;
		this.AUCredits = AUCredits;
		this.school = school;
		this.courseType = courseType;
		this.indexGroupList = indexGroupList;
		this.structure = structure;
		this.component = component;
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
	}
/*------------------------------------------------------------------ */
	// Get the ArrayList of indexGroup's IDs of the course
	public ArrayList<Integer> getIndexGroupList(){
		return this.indexGroupList;
	}
	// Change the ArrayList of indexGroup's IDs of the course
	public void setIndexGroupList(ArrayList<Integer> indexGroupList){
		this.indexGroupList=indexGroupList;
	}
	// Print indexGroup's ID for this course
	public void viewIndexGroupList() {
		System.out.print("Course index group: ");
		for(int i = 0; i<indexGroupList.size(); i++)
		{
			System.out.print(indexGroupList.get(i));
			if (i != indexGroupList.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
/*------------------------------------------------------------------ */	
	// Get the course assessment structure
	public courseStructure getCourseStructure() {
		return this.structure;
	}
	// Change the course assessment structure
	public void setCourseStructure(courseStructure structure) {
		this.structure=structure;
	}
/*------------------------------------------------------------------ */	
	// Get the component of the course(Lecture/Tutorial/Lab)
	public courseComponent getCourseComponent() {
		return this.component;
	}
	// Change the component of the course(Lecture/Tutorial/Lab)
	public void setCourseComponent(courseComponent component) {
		this.component=component;
	}
/*------------------------------------------------------------------ */
	public void viewCourseInfo(Integer AUCredits,courseStructure structure, courseComponent component) {
		System.out.println("Course code: " + this.courseID);
		System.out.println("Course name: " + this.courseName);
		System.out.println("AU Credits: " + AUCredits);
		System.out.println("Course type: " + this.courseType);
		System.out.println("School of course: " + this.school);
		viewIndexGroupList();	
		structure.viewCourseStructure();
		component.viewCourseComponent();
		System.out.println("\n\n");
	}
}

