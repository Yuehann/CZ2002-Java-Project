import java.awt.geom.Arc2D.Float;
import java.io.*;
import java.util.ArrayList;
public class StudentCourseGrade implements Serializable{
	private String studentId;
	private String courseId;
	private double examScore=-1;
	private double courseworkScore=-1;
	private double assignmentScore=-1;
	private double participationScore=-1;
	private double totalScore=-1;
	
	
	public StudentCourseGrade(String sid,String cid,double exam, double coursework, double ass, double participation) {
		this.studentId=sid;
		this.courseId=cid;
		this.examScore=exam;
		this.courseworkScore=coursework;
		this.assignmentScore=ass;
		this.participationScore=participation;
	}
	
//	get&set
	public void setStudentId(String s) {
		this.studentId=s;
	}
	
	public String getStudentId() {
		return this.studentId;
	}
	
	
	public void setCourseId(String s) {
		this.courseId=s;
	}
	
	public String getCourseId() {
		return this.courseId;
	}
	
	public double getExamScore() {
		return this.examScore;
	}
	
	public void setExamScore(double i) {
		this.examScore=i;
	}
	
	public double getCourseworkScore() {
		return this.courseworkScore;
	}
	
	public void setCourseworkScore(double i) {
		this.courseworkScore=i;
	}
	
	public double getAssignmentScore() {
		return this.assignmentScore;
	}
	
	public void setAssignmentScore(double i) {
		this.assignmentScore=i;
	}
	
	public double getParticipationScore() {
		return this.participationScore;
	}
	
	public void setParticipationScore(double i) {
		this.participationScore=i;
	}
//	end
	public void setTotalScore() {
		SerializeFile sw=new SerializeFile ("course.txt");
		Course c=(Course)sw.read(this.courseId,'c');
		boolean hasexam=c.getCourseStructure().getWeightOfFinal()>1e-6;
		boolean hascoursework=c.getCourseStructure().getWeightOfCoursework()>1e-6;
		double exam_partial=c.getCourseStructure().getWeightOfFinal()*this.examScore;
		double coursework_partial=c.getCourseStructure().getWeightOfCoursework()*this.courseworkScore;
		if (hasexam&&this.examScore==-1) {
			System.out.println("Exam score not set yet.");
			return;
		}
		else if (hascoursework&&this.courseworkScore==-1) {
			System.out.println("Courseworkscore not set yet.");
			return;
		}
		if (hasexam&&this.examScore!=-1) {
			this.totalScore+=exam_partial;
		}
		if (hascoursework&&this.courseworkScore!=-1) {
			this.totalScore+=coursework_partial;
		}
		this.totalScore+=1;
		}
	
	public double getTotalScore() {
		return this.totalScore;
	}
	
	public String tograde(char mode) {
		if (mode=='t') {
			if (this.totalScore==-1) return "Grading is not finished.";
			if (this.totalScore>=90) return "A+";
			else if(this.totalScore>=80) return "A";
			else if(this.totalScore>=75) return "A-";
			else if(this.totalScore>=70) return "B+";
			else if(this.totalScore>=65) return "B";
			else if(this.totalScore>=60) return "B-";
			else if(this.totalScore>=55) return "C+";
			else if(this.totalScore>=55) return "C";
			return "F";}
		if (mode=='e') {
			if (this.examScore==-1) return "Grading is not finished.";
			if (this.examScore>=90) return "A+";
			else if(this.examScore>=80) return "A";
			else if(this.examScore>=75) return "A-";
			else if(this.examScore>=70) return "B+";
			else if(this.examScore>=65) return "B";
			else if(this.examScore>=60) return "B-";
			else if(this.examScore>=55) return "C+";
			else if(this.examScore>=55) return "C";
			return "F";}
		if (mode=='c') {
			if (this.courseworkScore==-1) return "Grading is not finished.";
			if (this.courseworkScore>=90) return "A+";
			else if(this.courseworkScore>=80) return "A";
			else if(this.courseworkScore>=75) return "A-";
			else if(this.courseworkScore>=70) return "B+";
			else if(this.courseworkScore>=65) return "B";
			else if(this.courseworkScore>=60) return "B-";
			else if(this.courseworkScore>=55) return "C+";
			else if(this.courseworkScore>=55) return "C";
			return "F";}
		return null;
	}
}

