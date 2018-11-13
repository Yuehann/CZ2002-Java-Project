import java.util.ArrayList;
import java.io.Serializable;

public class Course implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String courseID;
	private String courseName;
	private Integer AUCredits;
	private String school;
	private ArrayList<Integer> indexGroupList;  //????indexGroupClass,<indexGroup>,contain vacancy, Students?????//
	
	private CourseStructure structure = new CourseStructure();  // uni-directional
	private CourseComponent component;  // uni-directional
	private String coordinator;
/*-------------------------constructor---------------------------- */	
	// Creates a new Course without specified attributes
	public Course(){
		this.courseID="CZxxxx";
		this.courseName = "Course X";
		this.AUCredits = 3;
		this.school = "SCSE";
		
		this.indexGroupList = new ArrayList<Integer>();
		this.component = new CourseComponent();
	}
	// Creates a new Course with given ID, name, AU, school, waitList of index group, structure, component
	public Course(String courseID, String courseName, Integer AUCredits, String school, ArrayList<Integer> indexGroupList,
			CourseComponent component) {
		this.courseID=courseID;
		this.courseName = courseName;
		this.AUCredits = AUCredits;
		this.school = school;
		this.indexGroupList = indexGroupList;
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
	public CourseStructure getCourseStructure() {
		return this.structure;
	}
	// Change the course assessment structure
	public void setCourseStructure(CourseStructure structure) {
		this.structure=structure;
	}
/*------------------------------------------------------------------ */	
	// Get the component of the course(Lecture/Tutorial/Lab)
	public CourseComponent getCourseComponent() {
		return this.component;
	}
	// Change the component of the course(Lecture/Tutorial/Lab)
	public void setCourseComponent(CourseComponent component) {
		this.component=component;
	}
/*------------------------------------------------------------------ */	
// Get and set coordinator
	public String getCoordinator() {
		return this.coordinator;
	}
	public void setCoordinator(String coordinator) {
		this.coordinator = coordinator;
	}
	
/*------------------------------------------------------------------ */
	public void viewCourseInfo(Integer AUCredits,CourseStructure structure, CourseComponent component) {
		System.out.println("Course code: " + this.courseID);
		System.out.println("Course name: " + this.courseName);
		System.out.println("AU Credits: " + AUCredits);
		System.out.println("School of course: " + this.school);
		viewIndexGroupList();	
		structure.viewCourseStructure();
		component.viewCourseComponent();
		System.out.println("\n\n");
	}
	
}




