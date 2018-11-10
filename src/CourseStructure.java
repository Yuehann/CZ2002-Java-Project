
public class CourseStructure {

	private double finalExam;
	private double quiz;
	private double assignment;
	private double project;
	private double participation;
	
/*-------------------------constructor---------------------------- */
	// Creates a new courseStructure without specified attributes
	public CourseStructure() {
		this.finalExam=0.2;
		this.quiz=0.2;
		this.assignment=0.2;
		this.project=0.2;
		this.participation=0.2;
	}
	// Create a new courseStructure given weight of finalExam, quiz, assignment, project, participation
	public CourseStructure(double finalExam, double quiz, double assignment, double project, double participation) {
		this.finalExam=finalExam;
		this.quiz=quiz;
		this.assignment=assignment;
		this.project=project;
		this.participation=participation;
	}
/*---------------------------------------------------------------- */
	// Get the weight of each assessment
	public double getWeightOfFinal() {
		return this.finalExam;
	}
	public double getWeightOfQuiz() {
		return this.quiz;
	}
	public double getWeightOfAssignment() {
		return this.assignment;
	}
	public double getWeightOfProject() {
		return this.project;
	}
	public double getWeightOfParticipation() {
		return this.participation;
	}
	// Set the weight of each assessment
	public void setWeightOfFinal(double finalExam) {
		this.finalExam=finalExam;
	}
	public void setWeightOfQuiz(double quiz) {
		this.quiz=quiz;
	}
	public void setWeightOfAssignment(double assignment) {
		this.assignment=assignment;
	}
	public void setWeightOfProject(double project) {
		this.project=project;
	}
	public void setWeightOfParticipation(double participation) {
		this.participation=participation;
	}
/*---------------------------------------------------------------- */
	// print weight of course structure
	public void viewCourseStructure() {
		System.out.println("Course structure:");
		if(this.finalExam!=0.0)
			System.out.println("  Final exam - "+this.finalExam);
		if(this.quiz!=0.0)
			System.out.println("  Quiz - "+this.quiz);
		if(this.assignment!=0.0)
			System.out.println("  Assignment - "+this.assignment);
		if(this.project!=0.0)
			System.out.println("  Project - "+this.project);
		if(this.participation!=0.0)
			System.out.println("  Participation - "+this.participation);
	}
}
