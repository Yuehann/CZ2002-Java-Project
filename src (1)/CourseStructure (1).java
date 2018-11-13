import java.io.Serializable;

public class CourseStructure implements Serializable {

	private static final long serialVersionUID = 6L;
	
	private double exam=0;
	private double coursework=0;
	private double assignment=0;
	private double participation=0;
	
/*-------------------------constructor---------------------------- */
	// Creates a new courseStructure without specified attributes
	public CourseStructure() {
		this.exam=1;
	}
	
	
	// Create a new courseStructure given weight of finalExam, quiz, assignment, project, participation
	public CourseStructure(double finalExam, double coursework, double assignment, double participation) {
		if ((finalExam+coursework-1>1e-6)||(coursework!=0&&assignment+participation-1>1e-6)||coursework==0&&(assignment!=0||participation!=0)){
			System.out.println("Invalid combination!");
		}
		else {
			this.exam=finalExam;
			this.coursework=coursework;
			this.assignment=assignment;
			this.participation=participation;
		}
	}
/*---------------------------------------------------------------- */
	// Get the weight of each assessment
	public double getWeightOfFinal() {
		return this.exam;
	}
	public double getWeightOfCoursework() {
		return this.coursework;
	}
	public double getWeightOfAssignment() {
		return this.assignment;
	}
	public double getWeightOfParticipation() {
		return this.participation;
	}
	// Set the weight of each assessment
	public void setWeightOfFinal(double finalExam) {
		this.exam=finalExam;
	}
	public void setWeightOfCoursework(double coursework) {
		this.coursework=coursework;
	}
	public void setWeightOfAssignment(double assignment) {
		this.assignment=assignment;
	}
	public void setWeightOfParticipation(double participation) {
		this.participation=participation;
	}
/*---------------------------------------------------------------- */
	// print weight of course structure
	public void viewCourseStructure() {
		System.out.println("Course structure:");
		if(this.exam!=0.0)
			System.out.println("  Final exam - "+this.exam);
		if(this.coursework!=0.0)
			System.out.println("  Quiz - "+this.coursework);
		if(this.assignment!=0.0)
			System.out.println("  Assignment - "+this.assignment);
		if(this.participation!=0.0)
			System.out.println("  Participation - "+this.participation);
	}
	
	public String toString() {
		String temp="";
		temp+=this.exam+"|"+this.coursework+"|"+this.assignment+"|"+this.participation;
		return temp;
				}
}
