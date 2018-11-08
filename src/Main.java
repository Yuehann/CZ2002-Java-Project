
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		// String courseID, String courseName, Integer AUcredits, String school, ArrayList<Integer> indexGroupList, 
		// CourseStructure structure, CourseComponent component
		CourseStructure structure=new CourseStructure(0.6,0.0,0.2,0.2,0.0);
		CourseComponent component=new CourseComponent(true,true,false);
		ArrayList<Integer> indexGroupList=new ArrayList<Integer>(3);
		indexGroupList.add(18312);
		indexGroupList.add(18314);
		indexGroupList.add(18317);
		Course c=new Course("cz2001","Algorithm",3,"SCSE",indexGroupList,structure,component);
		DbWriter dw=new DbWriter("1.txt");
		dw.write(c);
		dw.updateWrite(c);
	}

}
