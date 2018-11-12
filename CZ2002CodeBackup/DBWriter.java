import java.io.*;
import java.util.*;

public class DBWriter extends DBAccess{
	private int where=super.index;
	
	    DBWriter(String filename) {
		super(filename);
	}
	 
	public String write(Course c, String id) {
		String temp_str="";
		temp_str+=c.getCourseID();
		temp_str+=" ";
		temp_str+=c.getCourseName();
		temp_str+=" ";
		temp_str+=String.valueOf(c.getAUcredits());
		temp_str+=" ";
		temp_str+=c.getSchool();
		temp_str+=" ";
		if (c.getIndexGroupList().size()!=0) {
			for(int i=0;i<c.getIndexGroupList().size();i++) {
				temp_str+=c.getIndexGroupList().get(i);
				if (i!=c.getIndexGroupList().size()-1) temp_str+="|"; 
			}
			}
		else temp_str+="empty";
		temp_str+=" ";
//		structure
// 		conponents
		return temp_str;
	}
	
	public String write(Students s) {
		String temp_str="";
		temp_str+=s.getStudentId();
		temp_str+=" ";
		temp_str+=s.getStudentName();
		temp_str+=" ";
		temp_str+=s.getGender();
		temp_str+=" ";
		temp_str+=s.getSchool();
		temp_str+=" ";
		temp_str+=s.getYear();
		temp_str+=" ";
		if (s.getIndexList().size()!=0) {
			for(int i=0;i<s.getIndexList().size();i++) {
				temp_str+=s.getIndexList().get(i);
				if (i!=s.getIndexList().size()-1) temp_str+="|"; 
			}}
		else temp_str+="empty";
		return temp_str;
	}
	
	public String write(CourseIndex i) {
		String temp_str="";
		temp_str+=i.getIndex();
		temp_str+=" ";
		temp_str+=i.getCourseId();
		temp_str+=" ";
		temp_str+=i.getVacancy();
		temp_str+=" ";
//		for(int j=0;i<i.getWaitList().size();j++) {
//			temp_str+=i.getWaitList().get(j);
//			if (j!=i.getWaitList().size()-1) temp_str+="|"; 
//		}
		temp_str+=" ";
		if (i.getStudentList()!=null) {
			for(int j=0;j<i.getStudentList().size();j++) {
				temp_str+=i.getStudentList().get(j);
				if (j!=i.getStudentList().size()-1) temp_str+="|"; 
			}}
		else temp_str+="empty";
//		temp_str+=" ";
//		temp_str+=i.getTutor();
//		temp_str+=i.getLabTutor();
		return temp_str;
	}

	
	public void appendNew(String target) throws IOException{
		BufferedWriter bw=new BufferedWriter(new FileWriter(super.f,true));
		bw.write(target);
		bw.newLine();
		System.out.println(target);
		bw.flush();
		bw.close();
	}
	
	public void update(String temp) throws IOException {
			String temp_str="";
			String check=null;
			ArrayList<String> temp_array=new ArrayList<String>();
			BufferedReader br=new BufferedReader(new FileReader(super.f));
			while ((check=br.readLine())!=null) {
				temp_array.add(check);
			}
			temp_str=super.search(temp);
			temp_array.set(where, temp_str);
			BufferedWriter bw=new BufferedWriter(new FileWriter(super.f));
			for(int i=0;i<=where;i++) {
				bw.write(temp_array.get(i));
				if (i!=where) bw.newLine();
			}
	}
	
//	public void updateParts() {}
	
	
	
}
