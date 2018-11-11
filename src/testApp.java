package Serialization;

import java.util.ArrayList;
import java.io.*;

public class testApp {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		CourseIndex i1=new CourseIndex(1,"cz2001",10,null,null);
		CourseIndex i2=new CourseIndex(2,"cz2001",10,null,null);
		CourseIndex i3=new CourseIndex(3,"cz2001",10,null,null);
		CourseIndex i4=new CourseIndex(4,"cz2001",10,null,null);
		CourseIndex i5=new CourseIndex(5,"cz2001",10,null,null);
	//test1 append to new file 
		SerializeFile sw=new SerializeFile("index1.txt");
		sw.appendNew(i1);
		sw.appendNew(i2);
		sw.appendNew(i3);
		sw.appendNew(i4);
		sw.appendNew(i5);
		System.out.println("test1 :");
		printresult(sw.getfile());
	//test2 append to existed file
		CourseIndex i6=new CourseIndex(6,"cz2001",10,null,null);
		sw.appendNew(i6);
		System.out.println("test2 :");
		printresult(sw.getfile());
	//test3 update waitlist
		i1.getWaitlist().add("u17");
		i1.getWaitlist().add("u18");
		sw.fillArray();
		sw.updateWrite(i1);
		System.out.println("test3 :");
		printresult(sw.getfile());
	//test4 delete one entry
		CourseIndex i7=new CourseIndex(1);
		sw.updateWrite(i7);
		System.out.println("test4 :");
		printresult(sw.getfile());
	//test5 delete till empty
		CourseIndex i8=new CourseIndex(2);
		CourseIndex i9=new CourseIndex(3);
		CourseIndex i10=new CourseIndex(4);
		CourseIndex i11=new CourseIndex(5);
		CourseIndex i12=new CourseIndex(6);
		sw.updateWrite(i8);
		sw.updateWrite(i9);
		sw.updateWrite(i10);
		sw.updateWrite(i11);
		sw.updateWrite(i12);
		System.out.println("test5 :");
		printresult(sw.getfile());
	}
		
	
	public static void printresult(File f) throws IOException, ClassNotFoundException {
		FileInputStream fi=new FileInputStream(f);
		ObjectInputStream oi=new ObjectInputStream(fi);
		ArrayList<Object> temp=new ArrayList<Object>();
		if (fi.available()>0)
		{while (fi.available()>0) {
			temp.add(oi.readObject());
		}
		for(int i=0;i<temp.size();i++) {
			System.out.println(((CourseIndex)(temp.get(i))).toString());
		}
		oi.close();}
		else System.out.println("empty file");
	}

}
