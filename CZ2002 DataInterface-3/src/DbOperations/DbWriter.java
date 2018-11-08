package DbOperations;
import java.io.*;
import java.util.*;

//--------------------This class is used to write objects DB-----------------------------------------------------------------------------------------------------------------------------//
public class DbWriter {
	//DB name
	private String filename;
	//Constructor
	DbWriter(String filename){
		this.filename=filename;
	}
//--------------------Format the object information into String---------------------------------------------------------------------------------------------------------------------------//
	public String write(Course c) {
//		write the object to a string
		String temp_all;
		String temp_structure;
		String temp_components;
		temp_all=c.getCourseID()+ " "+ c.getCourseName()+" "+ c.getAUcredits()+" "+ c.getSchool()+ " "+ c.getCourseType();
//		temp_structure=c.getCourseStructure().getWeightOfFinal()+"|"+c.getCourseStructure().getWeightOfQuiz()+"|"+
//				c.getCourseStructure().getWeightOfAssignment()+"|"+c.getCourseStructure().getWeightOfProject()+"|"+c.getCourseStructure().getWeightOfParticipation();
//		temp_components=String.valueOf(c.getCourseComponent().hasLec())+"|"+String.valueOf(c.getCourseComponent().hasTut())+"|"+String.valueOf(c.getCourseComponent().hasLab());
//		studentlist operation
//		String sltemp;
//		for (int i=0;i<c.studentList.size();i++) {
//			sltemp+=c.studentList.get(i);
//			if (i!=(c.studentList.size()-1)) sltemp+="|";
//			
//		}
		return temp_all;
	}

//--------------------Write a new line of data to the DB----------------------------------------------------------------------------------------------------------------------------------//
	public void newWrite(Course c) throws IOException {
		
		File f=new File(this.filename);
		BufferedWriter bw=new BufferedWriter(new FileWriter(f,true));
		bw.write(this.write(c));
		bw.newLine();
		bw.flush();
		bw.close();
	}
	
//-------------------Modify an existed line------------------------------------------------------------------------------------------------------------------------------------------------//	
	public void updateWrite(Course c) throws IOException {
//		String tempStr;
//		long len;
//		int count;
//		DbReader temp_r=new DbReader(this.filename);
//		int temp_index=temp_r.search(c.getcourseID);
//		//how to update using bw.write
//		RandomAccessFile rf=new RandomAccessFile (this.filename,"rw");
//		len=rf.length();
//		rf.seek(0);
//		for(long i=0;i<len;i++) {
//			if(rf.readByte()=='\n') {
//				rf.seek();
//			}
//		}
	
//------------- Finally chose a way in which the whole content is copied, modified, and rewrited -------------//
	DbReader dr=new DbReader(this.filename);
	
	ArrayList<String> temp_array=new ArrayList<String>();  
	
	int temp_index=dr.search(c.getCourseID());
	
	String temp_str=this.write(c);
	
	temp_array.addAll(dr.getList());
	
	
	temp_array.set(temp_index,temp_str);
	
	BufferedWriter bw=new BufferedWriter(new FileWriter(this.filename));
	
	for (int i=0;i<temp_array.size();i++) {
		bw.write(temp_array.get(i));
		bw.newLine();
	}
	
	bw.flush();
	bw.close();
	
		
		
	}
	
	

	
}
