import java.awt.geom.Arc2D.Float;
import java.io.*;
import java.util.ArrayList;
public class StudentCourseGrade implements Serializable{
	private String studentId;
	private String courseId;
	private String year;
	private int examScore=-1;
	private int courseworkScore=-1;
	private int assignmentScore=-1;
	private int participationScore=-1;
	
	
	public StudentCourseGrade(String sid,String cid,String year,int exam, int coursework, int ass, int participation) {
		this.studentId=sid;
		this.courseId=cid;
		this.year=year;
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
	
	public String getCourseId() {
		return this.courseId;
	}
	
	
	public void setCourseId(String s) {
		this.courseId=s;
	}
	
	public String getSemyr() {
		return this.year;
	}
	
	
	public void setSemyr(String s) {
		this.year=s;
	}
	
	public int getExamScore() {
		return this.examScore;
	}
	
	public void setExamScore(int i) {
		this.examScore=i;
	}
	
	public int getCourseworkScore() {
		return this.courseworkScore;
	}
	
	public void setCourseworkScore(int i) {
		this.courseworkScore=i;
	}
	
	public int getAssignmentScore() {
		return this.assignmentScore;
	}
	
	public void setAssignmentScore(int i) {
		this.assignmentScore=i;
	}
	
	public int getParticipationScore() {
		return this.participationScore;
	}
	
	public void setParticipationScore(int i) {
		this.participationScore=i;
	}
//	end
	
}
