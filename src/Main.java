import java.util.ArrayList;
import java.io.*;

public class Main implements Serializable{

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Course i1=new Course();
		Course i2=new Course();
		Course i3=new Course();
		Course i4=new Course();
		Course i5=new Course();
	//test1 append to new file 
		SerializeFile sw=new SerializeFile("course1.txt");
		sw.appendNew(i1);
		sw.appendNew(i2);
		sw.appendNew(i3);
		sw.appendNew(i4);
		sw.appendNew(i5);

		System.out.println("test1 :");
		printresult(sw.getfile());
//		System.out.println(sw.read("1", 'i'));
		
	//test2 append to existed file
		Course i6=new Course();
		sw.appendNew(i6);
		System.out.println("test2 :");
		printresult(sw.getfile());
	//test3 update waitlist
		i1.getIndexGroupList().add(17);
		i1.getIndexGroupList().add(18);
		sw.fillArray();
		sw.updateWrite(i1);
		System.out.println("test3 :");
		printresult(sw.getfile());
	//test4 delete one entry
		Course i7=new Course();
		sw.updateWrite(i7);
		System.out.println("test4 :");
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