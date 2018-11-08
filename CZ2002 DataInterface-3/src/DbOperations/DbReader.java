package DbOperations;

import java.io.*;
import java.util.*;
//--------------------This class is used to read a line in the DB and transfer it to the corresponding object-------------------------------------------------------------------------------//
public class DbReader {
	private String filename;
	private ArrayList<String> buffread=new ArrayList<String>();//save the whole db as an arraylist
	
	//Constructor
	DbReader(String filename) throws IOException {// input filename and then put the content to buffread
		File f = new File(filename);
		BufferedReader br= new BufferedReader(new FileReader(f));
		String check=null;
		while ((check=br.readLine())!=null) {
			this.buffread.add(check);
		}
		br.close();
		}
	
	
	public ArrayList<String> getList(){
		return this.buffread;
	}
	
//--------------------return the line index---------------------------------------------------------------------------------------------------------------------------------------------------//
	public int search(String ID) {
		if (this.buffread!=null) {
			for(int i=0;i<this.buffread.size();i++) {
				if (buffread.get(i).split(" ")[0].compareTo(ID)==0) {
					return i;
				}
			}
			return -1;
		}
		else return -1;
	}
	
	
	
//	public int search(String ID) throws IOException {
//		String tempStr;
//		int count=0;
//		File f=new File(filename);
//		BufferedReader br=new BufferedReader(new FileReader(f));
//		while((tempStr= br.readLine())!=null) {
//			if (tempStr.split(" ")[0]==ID) {
//				br.close();
//				return count;
//			}
//			else count++;
//		}
//		br.close();
//		return -1;
//	}
	
	
//	public Student getContent(Student s) {
//		String temp= this.buffread.get(search(s.getstudentID));
//		String[] tempArray= temp.split(" ");
//		//set info
//		
//	}

	
	public void getContent(Course c) {
		String temp= this.buffread.get(search(c.getCourseID()));
		String[] tempArray= temp.split(" ");
		//set info	
	}
	
	
}
	
